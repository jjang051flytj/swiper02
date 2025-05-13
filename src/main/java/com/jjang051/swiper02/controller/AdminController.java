package com.jjang051.swiper02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jjang051.swiper02.dto.VisualDto;
import com.jjang051.swiper02.entity.Visual;
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
    public String visual(@ModelAttribute VisualDto visualDto, RedirectAttributes redirectAttributes) {
        //log 찍어서 넘어온 값 출력 해보기....
        log.info("visualDto==={}",visualDto);
        Visual visual = visualService.saveVisual(visualDto);
        if(visual!=null) {
            log.info("입력되었습니다");
            redirectAttributes.addFlashAttribute("message", "입력완료되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("message", "입력실패.");
        }
        return "redirect:/admin/visual";
    }

    
}
