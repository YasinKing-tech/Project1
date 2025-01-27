package com.example.mvc.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.Entity.EmpEntity;
import com.example.mvc.Model.EmpModel;
import com.example.mvc.Service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;

    @GetMapping("/form")
    public String GetForm(Model model) {
        // Create an instance of EmpModel
        EmpModel empModel = new EmpModel();
        
        // Add the EmpModel object to the model with the name "employee"
        model.addAttribute("employee", empModel);
        
        // Return the name of the Thymeleaf template (Form.html)
        return "Form";
    }
    @PostMapping("/register")
    public String SendForm(@ModelAttribute EmpModel empModel) {
    	empService.SendForm(empModel);
    	 return "Success";
    }
    @GetMapping("/Getdetails")
     public String GetDetails(Model model) {
    	List<EmpEntity>Details =empService.GetDetails();
    	  model.addAttribute("Details",Details);
    	  return "Details";
    	
    }
    @GetMapping("/Delete")
    public String Delete(@RequestParam long EmpId) {
    	empService.Delete(EmpId);
    	return "redirect:/Getdetails";
    	
    }
    @GetMapping("/Edit")
     public String Edit(@RequestParam long EmpId ,Model model) {
    EmpModel empModel=empService.Edit(EmpId);
    	model.addAttribute("empModel",empModel);
    	model.addAttribute("EmpId", EmpId);
    	return "EditForm";
    }
    @PostMapping("/update")
    public String UpdateById(@ModelAttribute EmpModel empModel, @RequestParam long EmpId) {
        empService.UpdateById(EmpId, empModel); // Update logic
        return "redirect:/Getdetails"; // Redirect after updating
    }
    @GetMapping("/SearchEmp")
    public String SearchById(@RequestParam long EmpId, Model model) {
        EmpEntity emp = empService.SearchById(EmpId);
        model.addAttribute("empEntity", emp);
        return "Search";  // Ensure this matches the name of the Thymeleaf template
    }
    @GetMapping("/addEmployee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("empModel", new EmpModel()); // Empty model for the form
        return "addEmployee"; // Return the view to display the form
    }

    // POST request to save the new employee details
    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute EmpModel empModel) {
        empService.saveEmployee(empModel); // Save employee using the service
        return "redirect:/Getdetails"; // Redirect to the employee list page after saving
    }




        
}
