package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import main.model.Course;
import main.service.CourseService;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
	
	@Autowired
	private CourseService courseService;
	
	static List<String> DAYS = null;
	static {DAYS = new ArrayList<>();
		DAYS.add("Mon-Thu");
		DAYS.add("Tue-Fri");
		DAYS.add("Wed-Sat");
		DAYS.add("Mon-Wed-Thu");
		DAYS.add("Tue-Fri-Sat");
	}
	static List<String> TIMES = null;
	static {TIMES = new ArrayList<>();
		TIMES.add("9-11 AM");
		TIMES.add("11-1 AM/PM");
		TIMES.add("1-3 PM");
		TIMES.add("3-5 PM");
	}
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		List<Course> courses = courseService.getAll();
		model.addAttribute("courses", courses);
		return "index";
	}
	
	@GetMapping("/addCourse")
	public String showForm(Model model) {
		Course course = new Course();
		model.addAttribute("course",  course);
		model.addAttribute("DAYS", DAYS);
		model.addAttribute("TIMES", TIMES);
		return "course-form";
	}
	
	@PostMapping("/processForm")
	public String processCourse(@ModelAttribute Course course) {
		courseService.save(course);
		return "redirect:/";
	}
	
	@GetMapping("/deleteCourse/{id}")
	public String deleteOffer(@PathVariable int id) {
		if (id > 0) {
			Course course = courseService.getById(id);
			if(course != null) {
				courseService.delete(id);
			}
		}
		return "redirect:/";
	}
	
	@GetMapping("/editCourse/{id}")
	public String editCourseString(@PathVariable int id, Model model) {
		if(id > 0) {
			Course course = courseService.getById(id);
			model.addAttribute("DAYS", DAYS);
			model.addAttribute("TIMES", TIMES);
			if(course != null) {
				model.addAttribute("course", course);
				return "course-form";
			}
		}
		return "redirect:/";
	}

	
}
