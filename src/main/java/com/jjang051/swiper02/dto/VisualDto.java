package com.jjang051.swiper02.dto;

import org.springframework.web.multipart.MultipartFile;

import com.jjang051.swiper02.entity.Visual;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VisualDto {
    private int id;

    private String mainMessage;
    private String subMessage;

    private int num;

    private MultipartFile visual;
    private String renameVisual;
    private String originalVisual;

    public static Visual toEntity(VisualDto visualDto) {
        return Visual.builder()
                .mainMessage(visualDto.getMainMessage())
                .subMessage(visualDto.getSubMessage())
                .renameVisual(visualDto.getRenameVisual())
                .originalVisual(visualDto.getOriginalVisual())
                .num(visualDto.getNum())
                .build();
    }

}
