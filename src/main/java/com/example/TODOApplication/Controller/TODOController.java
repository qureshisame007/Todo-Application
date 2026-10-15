package com.example.TODOApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.TODOApplication.Service.TODOService;
import com.example.TODOApplicationEntity.Todo;

@Controller
public class TODOController {
	
	
	@Autowired
	TODOService todoService;
	
	@RequestMapping("/")
	public String getAllTodo(Model model) {
		
		List<Todo> listOfTodos =  todoService.getAllTodos();
		model.addAttribute("listoftodos",listOfTodos);
		return "task";
		  
	  }
	
	//@RequestMapping(value = "/updatetodo/{id}", method = RequestMethod.POST)
	@RequestMapping(value = "/addtodo" ,method=RequestMethod.POST)

	@ResponseBody
	public String createTodo(@ModelAttribute Todo todo) {
		todoService.saveTODO(todo);
		return "success";

	}
	
	

	@RequestMapping(value = "/updatetodo/{id}")
	  public String updateTodo(@PathVariable("id") Long id, @ModelAttribute Todo todo) {
		
		todoService.updateTodo(id , todo);
		return "redirect:/";
	  
	 }
	  
	@RequestMapping("/deleteTODO/{id}")
	  public String deleteTodo(@PathVariable("id") Long id) {
		
		todoService.deleteTODO(id);
		return "redirect:/";
	  
	  }
	 
	
	 
	
	

}
