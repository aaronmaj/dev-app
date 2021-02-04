package com.dev.app.account.service;

import com.dev.app.account.domain.Category;
import com.dev.app.account.domain.SubCategory;
import com.dev.app.account.repository.SubCategoryRepository;
import com.dev.app.common.resources.dto.CategoryDto;
import com.dev.app.common.resources.dto.SubCategoryDto;
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
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final ModelMapper subCategoryMapper;

    @Transactional(readOnly = true)
    public SubCategoryDto findById(Long id) {
        return convertToDto(subCategoryRepository.findById(id).orElse(null));
    }

    public List<SubCategoryDto> findAll() {
        return subCategoryRepository.findAll()
                .stream()
                .map(subCategory -> convertToDto(subCategory))
                .collect(Collectors.toList());
    }

    public SubCategoryDto create(SubCategoryDto subCategoryDto){
        SubCategory subCategory = convertToEntity(subCategoryDto);
        return convertToDto(subCategoryRepository.save(subCategory));
    }
    public String delete(Long id ){
        subCategoryRepository.deleteById(id);
        return "Category deleted successfully";
    }
    private SubCategoryDto convertToDto(SubCategory subCategory) {
        subCategoryMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return subCategoryMapper.map(subCategory, SubCategoryDto.class);
    }

    private SubCategory convertToEntity(SubCategoryDto subCategoryDto) {
        SubCategory subCategory = subCategoryMapper.map(subCategoryDto, SubCategory.class);

        return subCategory;
    }

}
