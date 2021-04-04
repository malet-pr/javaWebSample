package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import main.model.Course;
import main.model.KeyValueProfessor;
import main.model.KeyValueSubject;
import main.model.Professor;
import main.model.Subject;
import main.service.CourseService;
import main.service.ProfessorService;
import main.service.SubjectService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Controller
@SessionAttributes("course")
public class CourseController {

    @Autowired
	private CourseService courseService;
    @Autowired
	private ProfessorService professorService;
    @Autowired
    private SubjectService subjectService;
    
    @PersistenceContext
    EntityManager em;

    private List<String> DAYS = new ArrayList<>(
        Arrays.asList("Mon-Thu","Tue-Fri","Wed-Sat","Mon-Wed-Thu","Tue-Fri-Sat"));

    private List<String> TIMES = new ArrayList<>(
        Arrays.asList("9-11 AM","11-1 AM/PM","1-3 PM","3-5 PM","5-7 PM"));
    
    	@GetMapping({"/","/home"})
    	public String getHomePage() {   		
    		return "home";
    	}

        @GetMapping("/coursesAdmin")
        public String getCoursesListA(Model model) {
        	List<Course> courses = courseService.getAll();
            model.addAttribute("courses", courses);
            return "courses";
        }
        
        @GetMapping("/coursesStudent")
        public String getCoursesListS(Model model) {
        	List<Course> courses = courseService.getAvailable();
            model.addAttribute("courses", courses);
            return "courses";
        }
        
        @GetMapping("/addCourse")
        public String addCourseForm(Model model) {
            Course course = new Course();
            model.addAttribute("course", course);
            model.addAttribute("DAYS", DAYS);
            model.addAttribute("TIMES", TIMES);
            return "/new-course";
        }
   
        // NOTA: se rompe si faltan profesor o materia. ARREGLARLO //
        // tiene una solución temporal //
        
		@PostMapping("/processForm")
        public String addCourse(@ModelAttribute Course course, SessionStatus status) {	
			
			// these ifs are necessary for the method not to break if autocomplete is empty
			if(course.getProfessor().getId() == 0) {
				course.getProfessor().setId(1);
			}
			if(course.getSubject().getId() == 0) {
				course.getSubject().setId(1);
			}
			// end of issues
			
			course.setProfessorId();
			course.setSubjectId();
			courseService.save(course);
			status.isComplete();
            return "redirect:/coursesAdmin";   
		}
                
        @GetMapping("/deleteCourse/{id}")
        public String deleteCourse(@PathVariable int id) {
            if (id >= 0) {
                Course course = courseService.getById(id);
                if(course != null) {
                    courseService.delete(id);
                }
            }
            return "redirect:/coursesAdmin";
        }
        
        @GetMapping("/editCourse/{id}")
        public String editCourseString(@PathVariable int id, Model model) {
            Course course = null;
            if(id >= 0) {
                course = courseService.getById(id);
                if(course != null) {
                	String profName = course.getProfessor().getLastName() +", "+course.getProfessor().getFirstName();
                	String subjName = course.getSubject().getName();
                	List<String> oldValues = new ArrayList<>(Arrays.asList("Current subject: " + subjName,"Current professor: " + profName));
                	model.addAttribute("course", course);
                    model.addAttribute("DAYS", DAYS);
                    model.addAttribute("TIMES", TIMES);
                    model.addAttribute("oldValues", oldValues);
                    return "/edit-course";
                }
            }
            return "redirect:/coursesAdmin";
        }
        
		@PostMapping("/processForm2")
        public String editCourse(@ModelAttribute Course course, SessionStatus status) {	
			
			// these ifs are necessary for the method not to break if autocomplete is empty
			if(course.getProfessor().getId() == 0) {
				course.getProfessor().setId(1);
			}
			if(course.getSubject().getId() == 0) {
				course.getSubject().setId(1);
			}
			// end of issues
			
			course.setProfessorId();
			course.setSubjectId();
			courseService.save(course);
			status.isComplete();
            return "redirect:/coursesAdmin";   
		}

        @GetMapping("/professorList")
        @ResponseBody
        public List<KeyValueProfessor> professorList(@RequestParam String term) {
            List<Professor> professors = professorService.findByLastNameLikeIgnoreCaseAndIsActive(term);
            List<KeyValueProfessor> list = new ArrayList<>();
            for(Professor prof : professors) {
            	KeyValueProfessor kvp = new KeyValueProfessor();
            	kvp.setValue(prof.getId());
            	String fullName = prof.getLastName() + ", " + prof.getFirstName();
            	kvp.setLabel(fullName);
            	list.add(kvp);
            }
            return list;
        }

        @GetMapping("/subjectList")
        @ResponseBody
        public List<KeyValueSubject> subjectList(@RequestParam String term) {
            List<Subject> subjects = subjectService.findByNameLikeIgnoreCase(term);
            List<KeyValueSubject> list = new ArrayList<>();
            for(Subject sub : subjects) {
            	KeyValueSubject kvs = new KeyValueSubject();
            	kvs.setValue(sub.getId());
            	kvs.setLabel(sub.getName());
            	list.add(kvs);
            }
            return list;
        }
        
        @GetMapping("/addStudent/{id}")
        public String addStudent(@PathVariable int id, Authentication auth) {
        	courseService.addStudent(id, auth.getName());
        	return "redirect:/coursesStudent";
        }  
        
        @GetMapping("/viewSubject/{id}")
        public String viewCourse(@PathVariable int id, Model model) {
        	Subject subject = subjectService.getById(id);
        	model.addAttribute("subject", subject);
        	return "/subjectView";
        }
        
}