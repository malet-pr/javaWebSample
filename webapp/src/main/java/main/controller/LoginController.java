package main.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, Model model, Principal principal, RedirectAttributes flash) {
		if(principal != null) {
			return "redirect:/home";
		}
		if(error != null) {
			flash.addFlashAttribute("error", "Incorrect Login Information");
		}
		return "login";
	}

}
