package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class TestController {
	private static int ctn = 0;
	
	public TestController(){
		System.out.println("TestController ctn = " + ctn);
		TestController.ctn ++;
	}

}
