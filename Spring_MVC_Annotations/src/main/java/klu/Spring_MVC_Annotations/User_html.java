package klu.Spring_MVC_Annotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class User_html {
	
	@GetMapping("/html")
	public String gethtml() {
		return "index";
	}
}
