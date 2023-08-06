package com.javangar.mentofitvx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
    
    @GetMapping("/messages")
    public String messages() {
        return "messages";
    }

    @GetMapping("/settings")
    public String settings() {
        return "settings";
    }

    @GetMapping("/menu-main")
    public String menumain() {
        return "menu-main";
    }

    @GetMapping("/menu-highlights")
    public String menuhighlights() {
        return "menu-highlights";
    }

    @GetMapping("/menu-bell")
    public String menubell() {
        return "menu-bell";
    }

    @GetMapping("/follow")
    public String follow() {
        return "follow";
    }

    @GetMapping("/course")
    public String course() {
        return "course";
    }

}
