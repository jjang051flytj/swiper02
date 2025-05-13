package com.jjang051.swiper02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jjang051.swiper02.dto.VisualDto;
import com.jjang051.swiper02.service.VisualService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("/admin")
@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final VisualService visualService;

    @GetMapping("/visual")
    public String visual() {
        //log 찍어서 넘어온 값 출력 해보기....
        return "admin/visual";
    }

    @PostMapping("/visual")
    public String visual(@ModelAttribute VisualDto visualDto) {
        //log 찍어서 넘어온 값 출력 해보기....
        log.info("visualDto==={}",visualDto);
        visualService.saveVisual(visualDto);
        return "admin/visual";
    }
}
