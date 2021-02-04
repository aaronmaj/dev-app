package com.dev.app.account.controller;

import com.dev.app.account.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class SubCategoryController {

    private final SubCategoryService subCategoryService;
}
