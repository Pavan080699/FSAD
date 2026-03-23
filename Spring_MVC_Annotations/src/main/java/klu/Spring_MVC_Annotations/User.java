package klu.Spring_MVC_Annotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/controller")
public class User {
	@GetMapping("/welcome")
	@ResponseBody
	public String display() {
		return "welcome Controller";
	}
	
	@GetMapping("/d1")
	@ResponseBody
	public String display1() {
		return "Controller from display1 method";
	}
	
	@GetMapping("/d2")
	@ResponseBody
	public String display2() {
		return "Controller from display2 method";
	}
	
	@GetMapping("/d3")
	public int display3() {
		return 3366;
	}
	
	//with parameter name   @RequestParam   http://localhost:8080/controller/d9?id=313
	
	@GetMapping("/d9")
	public int display9(@RequestParam("id") int uid) {
		return uid;
	}
	
	//without parameter name     @PathVariable     http://localhost:8080/controller/d10/31313
	
	@GetMapping("/d10/{eid}")
	public int display10(@PathVariable("eid") int uid1) {
		return uid1;
	}
	
	
	
	
	
	
	@GetMapping("/d4")
	public String display4() {
		return "Controller from display4 method";
	}
	
	@GetMapping(value = "/d5")
	public String display5() {
		return "Controller from display5 method";
	}
	
	@GetMapping(value = "/d6")
	public String display6() {
		return "iyaltiki idhi ayidha?";
	}
	
	
}
