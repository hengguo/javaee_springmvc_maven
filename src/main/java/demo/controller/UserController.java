package demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.domain.User;
import demo.service.UserService;
import demo.util.JsonHelper;
import demo.util.JsonUtil;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private Logger LOG = Logger.getLogger(UserController.class);
	private static int ctn = 0;

	public UserController() {
		System.out.println("UserController ctn = " + ctn);
		UserController.ctn++;
	}
	@Resource
	private UserService userService;
	
	@RequestMapping("dynamicUserView")
	public String dynamicUserView(){
		return "dynamicDataGridColumn";
	}
	
	@RequestMapping("editableDatagridView")
	public String editableDatagridView(){
		return "editableDataGridColumn";
	}
	@RequestMapping("editableDatagridView2")
	public String editableDatagridView2(){
		return "editableDataGridColumn2";
	}
	@RequestMapping("footerDataGridView")
	public String footerDataGridView(){
		return "footerDataGrid";
	}
	@RequestMapping(value="/getUsers")
	public ModelAndView getUsers(HttpServletRequest request, HttpServletResponse response){
		List<User> users = new ArrayList<User>();
		User u1 = new User();
		u1.setCreateTime(new Date());u1.setName("A1");
		User u2 = new User();
		u2.setCreateTime(new Date());u2.setName("A2");
		users.add(u1);users.add(u2);
		request.setAttribute("test", "ttt");
		return new ModelAndView("userList", "users", users);
		
	}
	
	
	@RequestMapping(value="/getDynamicUsers", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getDynamicUsers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		LOG.info("getDynamicUsers 进来了");
		Map<String, Object> map = (Map<String, Object>) request.getAttribute("SPRING");
		//System.out.println(1/0);

        System.out.println("recive message:\t"+map);
		List<User> users =userService.selectUsers(new HashMap<Object, Object>());
		LOG.info("getDynamicUsers要出去了");
		return JsonUtil.writeListOBJToDataGrid(users.size(), users);
	}
	
	@RequestMapping(value="/getFooter", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getFooter(HttpServletRequest request, HttpServletResponse response) throws Exception{

		List<User> users =userService.selectUsers(new HashMap<Object, Object>());
		JSONObject object = new JSONObject();
		object.put("total", users.size());
    	object.put("rows", JsonHelper.getJsonString4Object(JsonUtil.toGJson(users), "yyyy-MM-dd HH:mm:ss"));
    	float totalPrice = 0;
    	for(User user : users){
    		totalPrice += user.getId();
    	}
		object.put("footer", "[{\"name\":\"总计（元）：\",\"password\":" + totalPrice + "}]");
		return object.toString();
	}
	
	@RequestMapping(value="/nullReturn", produces = "text/plain;charset=UTF-8")
	public void nullReturn(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String, Object> map = (Map<String, Object>) request.getAttribute("SPRING");

        System.out.println("recive message:\t"+map);
		List<User> users =userService.selectUsers(new HashMap<Object, Object>());
	}
	
	@RequestMapping("deleteAndInsert")
	public void deleteAndInsert(HttpServletRequest request){
		User user = new User();
		user.setId(101);
		user.setName("D");
		user.setPassword("D");
		this.userService.deleteAndInsert(user);
	}
}
