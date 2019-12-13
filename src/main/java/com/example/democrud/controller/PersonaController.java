package com.example.democrud.controller;

import com.example.democrud.model.Persona;
import com.example.democrud.service.api.PersonaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonaController {

    @Autowired
    private PersonaServiceAPI personaServiceAPI;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", personaServiceAPI.getAll());
        return "index";
    }

    @RequestMapping("/save/{id}")
    public String showSave(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("persona", personaServiceAPI.get(id));
        }else{
            model.addAttribute("persona",new Persona());
        }
        return "save";
    }

    @PostMapping("/save")
    public String save(Persona persona, Model model) {
        personaServiceAPI.save(persona);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        personaServiceAPI.delete(id);
        return "redirect:/";
    }


}
