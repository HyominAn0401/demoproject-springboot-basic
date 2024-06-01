package com.example.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "Hyomin");
        return "greetings";
    }

    @GetMapping("/bye")
    public String Bye(Model model){
        model.addAttribute("username", "hyomin");
        return "bye";
    }
}
