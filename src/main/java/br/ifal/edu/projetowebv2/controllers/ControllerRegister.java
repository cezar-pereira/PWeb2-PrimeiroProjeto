package br.ifal.edu.projetowebv2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ControllerRegister {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index.html");
    }

    @RequestMapping("register_student")
    public ModelAndView registerStudent(String inputName, String inputEmail, String inputCpf, @RequestParam List<String> areaActing,
            String inputGender, String selectModule, String inputPassword) {
        ModelAndView response = new ModelAndView("registers.html");

        response.addObject("nome", inputName);
        response.addObject("email", inputEmail);
        response.addObject("cpf", inputCpf);
        response.addObject("sexo", inputGender);
        response.addObject("modulo", selectModule);
        response.addObject("area", areaActing);
        response.addObject("senha", inputPassword);

        return response;
    }
}