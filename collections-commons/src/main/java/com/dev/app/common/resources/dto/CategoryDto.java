package com.dev.app.common.resources.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
}
