package com.jjang051.swiper02.service;

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

    private final VisualRepository visualRepository;

    public int saveVisual(VisualDto visualDto) {
        Visual visual = visualDto.toEntity(visualDto);
        visualRepository.save(visual);
        return 0;
    }

}
