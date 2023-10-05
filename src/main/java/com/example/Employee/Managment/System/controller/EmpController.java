package com.example.Employee.Managment.System.controller;

import com.example.Employee.Managment.System.model.Employee;
import com.example.Employee.Managment.System.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {


    private final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Employee> employees = empService.getAllEmployee();
        model.addAttribute("employees",employees);
        return "index";
    }
    @GetMapping("/addemply")
    public String addEmpForm(){
        return "add_emply";
    }

    @PostMapping("/register")
    public String registerEmply(@ModelAttribute Employee employee, HttpSession session){

        session.setAttribute("msg", "Employee Added Successfully..");
        empService.addEmployee(employee);
        return "redirect:/";

    }

    @GetMapping("/edit/{id}")
    public String editEmply(@PathVariable Long id,Model model){

        Employee employee = empService.getEmployeeById(id);

        model.addAttribute("employee",employee);

        return "edit";
    }

    @PostMapping("/update")
    public String updateEmply(@ModelAttribute Employee employee, HttpSession session){

        empService.addEmployee(employee);
        session.setAttribute("msg","Employee Updated Successfully..");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmply(@PathVariable long id,HttpSession session ){
        empService.deleteById(id);
        session.setAttribute("msg","Employee Deleted Successfully..");
        return "redirect:/";
    }


}
