package demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.service.SyncService;
/**
 * {@link http://www.360sdn.com/springmvc/2013/0906/846.html}
 * spring mvc 的Controller类是单例(singleton)的吗?
2013-09-06 18:05:25   来源：   评论：0 点击：1607
使用Spring MVC有一段时间了,之前一直使用Struts2,在struts2中action都是原型(prototype)的， 说是因为线程安全问题,对于Spring MVC中bean默认都是(singleton)单例的,那么用@Controller注解标签注入的Controller类是单例实现的?

测试结果发现spring3中的controller默认是单例的，若是某个controller中有一个私有的变量i,所有请求到同一个controller时，使用的i变量是共用的，即若是某个请求中修改了这个变量a，则，在别的请求中能够读到这个修改的内容。 若是在@Controller之前增加@Scope("prototype")，就可以改变单例模式为多例模式

以下是测试步骤,代码与结果.

1. 如果是单例类型类的,那么在Controller类中的类变量应该是共享的,如果不共享,就说明Controller类不是单例。以下是测试代码：

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ExampleAction {
    private int singletonInt=1;
     @RequestMapping(value = "/test")
     @ResponseBody
     public String singleton(HttpServletRequest request,
             HttpServletResponse response) throws Exception {
         String data=request.getParameter("data");
         if(data!=null&&data.length()>0){
             try{
              int paramInt= Integer.parseInt(data);
             singletonInt = singletonInt + paramInt;
             }
             catch(Exception ex){
                 singletonInt+=10;
             }
         }else{
             singletonInt+=1000;
         } 
         return String.valueOf(singletonInt);
    }
}
分别三次请求： http://localhost:8080/example/test.do?data=15

得到的返回结果如下。

第一次： singletonInt=15

第二次： singletonInt=30

第三次： singletonInt=45

从以上结果可以得知，singletonInt的状态是共享的,因此Controller是单例的。

2. 如果Controller类是单例，那么多个线程请求同一个Controller类中的同一个方法，线程是否会堵塞
@RequestMapping(value = "/sleepdata")
@ResponseBody
public String switcher(HttpServletRequest request
     , HttpServletResponse response)
           throws Exception {
  String sleep = request.getParameter("sleep");
  if (sleep.equals("on")) {
      Thread.currentThread().sleep(100000);
       return "sleep on";
   } else {
       return sleep;
  }
}  
验证方法：分别发送两个请求，

第一个请求：http://localhost:8080/coreplat/sleepdata.do?sleep=on

第二个请求：http://localhost:8080/coreplat/sleepdata.do?sleep=test

验证结果：第一个请求发出去以后，本地服务器等待100s，然后返回结果"sleep on",在本地服务器等待的者100s当中，发送第二个请求，直接返回结果"test"。说明之间的线程是不互相影响的。
 *
 */
@Controller
@RequestMapping("/sync")
public class SyncController {
	@Resource
	private SyncService syncService;
	
	private int singletonInt=1;
    @RequestMapping(value = "/test")
    @ResponseBody
    public String singleton(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data=request.getParameter("data");
        if(data!=null&&data.length()>0){
            try{
             int paramInt= Integer.parseInt(data);
            singletonInt = singletonInt + paramInt;
            }
            catch(Exception ex){
                singletonInt+=10;
            }
        }else{
            singletonInt+=1000;
        } 
        return String.valueOf(singletonInt);
   }
    
    @RequestMapping(value = "/syncOnController")
    @ResponseBody
    public synchronized String syncOnController(HttpServletRequest request, HttpServletResponse response)
               throws Exception {
      String sleep = request.getParameter("sleep");
      if (sleep.equals("on")) {
          Thread.currentThread().sleep(20000);
           return "sleep on";
       } else {
           return sleep;
      }
    }  
    
    @RequestMapping(value = "/syncOnService")
    @ResponseBody
    public String syncOnService(HttpServletRequest request, HttpServletResponse response)
               throws Exception {
      return this.syncService.syncOnService(request);
    }  

}
