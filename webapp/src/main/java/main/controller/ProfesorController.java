package main.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import main.model.Professor;
import main.service.ProfessorService;

@Controller
@SessionAttributes("professor")
public class ProfesorController {
	
	@Autowired
	ProfessorService professorService;

    @GetMapping("/professors")
    public String getCoursesListA(Model model) {
    	List<Professor> professors = professorService.findByLastNameWithoutTBA();
        model.addAttribute("professors", professors);
        return "professors";
    }
    
    @GetMapping("/addProfessor")
    public String addProfessorForm(Model model) {
        Professor professor = new Professor();
        model.addAttribute("professor", professor);
        return "edit-professor";
    }
    
	@PostMapping("/processFormProfessor")
    public String addProfessor(@Valid @ModelAttribute Professor professor, BindingResult bindingResult, SessionStatus status) {	
		if(bindingResult.hasErrors()) {
			return "edit-professor";
		}
		professorService.save(professor);
		status.isComplete();
        return "redirect:/professors";   
	}
    
    @GetMapping("/editProfessor/{id}")
    public String editProfessor(@PathVariable int id, Model model) {
        Professor professor = null;
        if(id >= 0) {
            professor = professorService.getById(id);
            if(professor != null) {
            	model.addAttribute("professor", professor);
                return "/edit-professor";
            }
        }
        return "redirect:/professors";
    }
    
    @GetMapping("/deleteProfessor/{id}")
    public String deleteProfessor(@PathVariable int id) {
        if (id >= 0) {
            Professor professor = professorService.getById(id);
            if(professor != null) {
                professorService.delete(id);
            }
        }
        return "redirect:/professors";
    }
      
}
