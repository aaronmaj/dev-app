package com.dev.app.account.controller;

import com.dev.app.account.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aaron majambo
 */
@RequiredArgsConstructor
@RestController
@RequestMapping
public class CategoryController {
    private final CategoryService categoryService;
}
