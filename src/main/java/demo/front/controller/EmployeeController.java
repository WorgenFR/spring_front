package demo.front.controller;

import demo.front.model.Employee;
import demo.front.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String Home(Model model){
        Iterable<Employee> listEmployee = employeeService.getEmployees();
        model.addAttribute("employees", listEmployee);
        return "home";
    }

    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable("id") final int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee";
    }
}
