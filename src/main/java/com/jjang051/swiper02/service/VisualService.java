package com.jjang051.swiper02.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jjang051.swiper02.dto.VisualDto;
import com.jjang051.swiper02.entity.Visual;
import com.jjang051.swiper02.repository.VisualRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class VisualService {

    @Value("${file.upload}")
    private String upload;


    private final VisualRepository visualRepository;

    public Visual saveVisual(VisualDto visualDto) {
        if(visualDto.getVisual()!=null) {
            String originalVisual = visualDto.getVisual().getOriginalFilename();
            String fileName =  originalVisual.substring(0,originalVisual.lastIndexOf("."));
            String extention =  originalVisual.substring(originalVisual.lastIndexOf("."));
            log.info("originalVisual==={}",originalVisual);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String renameDate = now.format(formatter);
            Path uploadPath = Paths.get(upload+"/"+fileName+"_"+renameDate+extention);
            try {
                visualDto.getVisual().transferTo(uploadPath.toFile());    
                visualDto.setOriginalVisual(originalVisual);
                visualDto.setRenameVisual(fileName+"_"+renameDate+extention);
                Visual visual = visualDto.toEntity(visualDto);
                Visual savedVisual = visualRepository.save(visual);  //Visual
                //return savedVisual.getId();
                return savedVisual;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public List<Visual> getAllList() {
        return visualRepository.findAll();
    }
}
