package com.michaelspringproject.store.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Michael");
        return "index";
    }

}
