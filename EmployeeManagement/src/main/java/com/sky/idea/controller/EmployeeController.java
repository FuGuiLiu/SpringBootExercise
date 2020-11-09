package com.sky.idea.controller;

import com.sky.idea.dao.DepartmentDao;
import com.sky.idea.dao.EmployeeDao;
import com.sky.idea.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Administrator
 */
@Controller
public class EmployeeController {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employees")
    public String employees(Model model) {
        EmployeeDao employeeDao = new EmployeeDao();
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("employees", all);
        return "/employee/list";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("departments", departmentDao.getDepartments());
        return "/employee/addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    @GetMapping(value = "/employee/{id}")
    public String updateEmployee(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("departments", departmentDao.getDepartments());
        model.addAttribute("employee", employeeDao.get(id));
        return "/employee/updateEmployee";
    }

    @RequestMapping(value = "/employee/update", method = RequestMethod.POST)
    public String update(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    @GetMapping(value = "/employee/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employees";
    }
}
