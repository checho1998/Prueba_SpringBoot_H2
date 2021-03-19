package com.prueba.h2.Controllers;

import com.prueba.h2.Entitys.User;
import com.prueba.h2.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class UserController {

    @Autowired
    UserRepository uRepository;

    @GetMapping
    public String index(Model model, User user){
        model.addAttribute("user",new User());
        model.addAttribute("users",uRepository.findAll());
        return "index";
    }

    @PostMapping("/createUser")
    public String createUser (Model model, User user){
        uRepository.save(user);
        model.addAttribute("user",new User());
        model.addAttribute("users",uRepository.findAll());
        return "index";
    }

    @GetMapping("/selecUser/{id}")
    public String selecUser(Model model,@PathVariable(name="id") Long id){
        User selecUser = uRepository.findById(id).get();
        if (selecUser.isProcesado()){
            selecUser.setProcesado(false);
        }
        else{
            selecUser.setProcesado(true);
        }
        uRepository.save(selecUser);
        model.addAttribute("user",selecUser);
        model.addAttribute("users",uRepository.findAll());
        return "index";
    }

    @GetMapping("/updateUsers")
    public String updateUsers (Model model){
        model.addAttribute("users",uRepository.findAll());
        return "updateVista";
    }

}
