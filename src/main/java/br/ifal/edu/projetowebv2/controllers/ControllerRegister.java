package br.ifal.edu.projetowebv2.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifal.edu.projetowebv2.model.Student;
import br.ifal.edu.projetowebv2.repository.StudentRepository;

@RestController
public class ControllerRegister {

    @Autowired
    private StudentRepository studentRepo;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "register_update_student", method = RequestMethod.POST)
    public ModelAndView registerStudent(Student student, RedirectAttributes redirect) {

        // quando eu faço verificacoes de campo usando o objeto da o erro 500

        // return new ModelAndView("redirect:/registers");
        // if (validateName(student.getName())) {
        // studentRepo.save(student);
        // return new ModelAndView("redirect:/registers");
        // } else {
        // return new ModelAndView("redirect:/registers");
        // }

        // if (validatorRegister(student)) {
        // studentRepo.save(student);
        // return new ModelAndView("redirect:/registers");
        // } else {
        // return new ModelAndView("index");
        // }

        if (student.getId() == 0) {
            redirect.addFlashAttribute("messageSucess", "Estudante cadastrado com sucesso!");
            studentRepo.save(student);
        } else {
            if (checkPresenceStudent(student.getId())) {
                redirect.addFlashAttribute("messageSucess", "Estudante atualizado com sucesso!");
                studentRepo.save(student);
            } else
                redirect.addFlashAttribute("messageError", "Erro ao atualizar estudante!");
        }

        return new ModelAndView("redirect:/registers");
    }

    @RequestMapping("/registers")
    public ModelAndView listStudent(Model model, Pageable pageable) {
        ModelAndView response = new ModelAndView("registers.html");

        Iterable<Student> students = studentRepo.findAll();

        response.addObject("students", students);

        return response;
    }

    @RequestMapping("/delete/{idStudent}")
    public ModelAndView deleteStudent(@PathVariable("idStudent") long id, RedirectAttributes redirect) {

        if (checkPresenceStudent(id)) {
            studentRepo.deleteById(id);
            redirect.addFlashAttribute("messageSucess", "Estudante deletado com sucesso!");
        } else {
            redirect.addFlashAttribute("messageError", "Erro ao deletar estudante!");
        }

        return new ModelAndView("redirect:/registers");
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Optional<Student> findOne(Long id) {
        return studentRepo.findById(id);
    }

    private boolean checkPresenceStudent(long id) {
        Optional<Student> student = studentRepo.findById(id);

        if (student.isPresent())
            return true;
        else
            return false;
    }

    /* --- INÍCIO VALIDAÇÕES --- */
    boolean validatorRegister(Student student) {
        if (validateName(student.getName())) {
            if (validateEmail(student.getEmail()))
                if (validadeCpf(student.getCpf()))
                    if (validadeSex(student.getSex()))
                        if (validadeAreaActing(student.getAreas()))
                            if (validadePassword(student.getPassword())) {
                                return true;
                            }
        }
        return false;
    }

    boolean validateName(String name) {
        if (name.length() > 2)
            return true;
        return false;
    }

    boolean validateEmail(String email) {
        if (email.contains("@") && email.contains(".") && email.length() > 7)
            return true;
        return false;
    }

    boolean validadeCpf(String cpf) {
        if (cpf.length() != 11)
            return false;
        return true;
    }

    boolean validadeSex(String sex) {
        if (sex.equalsIgnoreCase("masculino") || sex.equalsIgnoreCase("feminino"))
            return true;
        return false;
    }

    boolean validadeAreaActing(String areaActing) {
        if (areaActing.isEmpty())
            return false;
        return true;
    }

    boolean validadePassword(String password) {
        if (password.length() < 6)
            return false;
        return true;
    }
    /* --- FIM VALIDAÇÕES --- */
}
