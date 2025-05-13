package com.jjang051.swiper02.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jjang051.swiper02.entity.Visual;
import com.jjang051.swiper02.service.VisualService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class HomeController {

    private final VisualService visualService;

    @GetMapping("/index")
    public String home(Model model ) {
        
        List<Visual> visualList = visualService.getAllList();
        model.addAttribute("visualList", visualList);
        return "index/index";
    }
    
}
