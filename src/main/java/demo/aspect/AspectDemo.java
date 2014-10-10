package demo.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class AspectDemo {
	
	Logger LOG = Logger.getLogger(AspectDemo.class);
	
	@Pointcut("execution(* demo.controller.UserController.getDynamicUsers(..))")
	public void exeTest(){}
	
	@Around("exeTest()")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		LOG.info("我进来 了");
	    HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

	    LOG.info("拦截到路径: " + request.getRequestURL());
	    
	    Object target = joinPoint.getTarget();
		Object[] args = joinPoint.getArgs();  
        HttpServletRequest in = null;   
        HttpServletResponse out = null;
        for (int i = 0; i < args.length; i++) {  
            if (args[i] instanceof HttpServletRequest) {  
                in = (HttpServletRequest) args[i];  
            } else if(args[i] instanceof HttpServletResponse){
            	out = (HttpServletResponse) args[i];
            }
        }  
		//return request;
		LOG.info(in.getParameter("nj"));
        LOG.info("我要出去了");
        JSONObject obj = (JSONObject)joinPoint.proceed();
	    LOG.info(obj.get("total"));
	    
	    return obj;

	  }
}
