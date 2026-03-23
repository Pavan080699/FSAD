package klu.Spring_MVC_Annotations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/restcontroller")
public class User_restcontroller {
	
	@GetMapping("/d7")
	public String display7() {
		return "RestController from display7 method";
	}
	
	@GetMapping("/d8")
	public String display8() {
		return "RestController from display8 method";
	}

}
