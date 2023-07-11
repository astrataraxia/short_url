package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OriginUrlDto {

    @NotNull
    private String originUrl;

}
