package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import main.model.Course;
import main.service.CourseService;
import java.util.List;

@Controller
public class MainController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		List<Course> courses = courseService.getAll();
		model.addAttribute("courses", courses);
		return "index";
	}
	
}
