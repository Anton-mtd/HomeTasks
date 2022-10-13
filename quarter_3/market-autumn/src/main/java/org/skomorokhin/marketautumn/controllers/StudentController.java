package org.skomorokhin.marketautumn.controllers;


import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello autumn market.";
    }

    @GetMapping("/buy")
    @ResponseBody
    public String buy() {
        return "buy";
    }


    //http://localhost:8189/app/calculate?a=5&b=4
    @GetMapping("/calculate")
    @ResponseBody
    public int calculate(@RequestParam int a, @RequestParam(required = false, defaultValue = "0") int b) {
        return a + b;
    }


    //http://localhost:8189/app/products/12/info
    @GetMapping("/products/{id}/info")
    @ResponseBody
    public String info(@PathVariable String id) {
        return "product with id = " + id;
    }

    @GetMapping("/page")
    public String page(Model model, @RequestParam Integer id) {
        model.addAttribute("studentFront", studentService.getStudentById(id));
        return "student.html";
    }


    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students.html";
    }

}
