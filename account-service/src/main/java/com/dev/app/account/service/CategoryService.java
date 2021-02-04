package com.dev.app.account.service;

import com.dev.app.account.domain.Category;
import com.dev.app.account.repository.CategoryRepository;
import com.dev.app.common.resources.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper categoryMapper;

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        return convertToDto(categoryRepository.findById(id).orElse(null));
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> convertToDto(category))
                .collect(Collectors.toList());
    }

    public CategoryDto create(CategoryDto categoryDto){
        Category category = convertToEntity(categoryDto);
        return convertToDto(categoryRepository.save(category));
    }
    public String delete(Long id ){
        categoryRepository.deleteById(id);
        return "Category deleted successfully";
    }
    private CategoryDto convertToDto(Category category) {
        categoryMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return categoryMapper.map(category, CategoryDto.class);
    }

    private Category convertToEntity(CategoryDto categoryDto) {
        Category category = categoryMapper.map(categoryDto, Category.class);

        return category;
    }

}
