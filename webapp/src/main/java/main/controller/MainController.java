package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import main.model.Course;
import main.model.Subject;
import main.service.CourseService;
import main.service.SubjectService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private SubjectService subjectService;
	
	public List<String> DAYS = new ArrayList<>(
			Arrays.asList("Mon-Thu","Tue-Fri","Wed-Sat","Mon-Wed-Thu","Tue-Fri-Sat"));

	public List<String> TIMES = new ArrayList<>(
			Arrays.asList("9-11 AM","11-1 AM/PM","1-3 PM","3-5 PM","5-7 PM"));
	
	// COURSES
	
	@GetMapping("/courses")
	public String getHomePage(Model model) {
		List<Course> courses = courseService.getAll();
		model.addAttribute("courses", courses);
		return "courses";
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
		return "redirect:/courses";
	}
	
	
	@GetMapping("/deleteCourse/{id}")
	public String deleteOffer(@PathVariable int id) {
		if (id >= 0) {
			Course course = courseService.getById(id);
			if(course != null) {
				courseService.delete(id);
			}
		}
		return "redirect:/courses";
	}
	
	@GetMapping("/editCourse/{id}")
	public String editCourseString(@PathVariable int id, Model model) {
		Course course = null;
		if(id >= 0) {
			course = courseService.getById(id);
			if(course != null) {
				model.addAttribute("course", course);
				model.addAttribute("DAYS", DAYS);
				model.addAttribute("TIMES", TIMES);
				return "course-form";
			}
		}
		return "redirect:/courses";
	}
	
	// SUBJECTS
	
	@GetMapping("/subjects")
	public String getSubjectList(Model model) {
		List<Subject> subjects = subjectService.getAll();
		model.addAttribute("subjects", subjects);
		return "subjects";
	}
	
}
