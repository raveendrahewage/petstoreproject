package com.middleware.mini.project.petcategory.Services;

import com.middleware.mini.project.petcategory.DTO.CategoryDTO;
import com.middleware.mini.project.petcategory.Entity.Category;
import com.middleware.mini.project.petcategory.Entity.Repository.CategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class CategoryService {
    @Inject
    private CategoryRepository categoryRepository;


    public boolean addCategoryType(CategoryDTO type){
        Category category = new Category(
                type.getName(),
                type.getDynasty(),
                type.getRegion(),
                type.getScientificName()
        );
        categoryRepository.persist(category);
        return categoryRepository.isPersistent(category);
    }

    public CategoryDTO getCategoryById(long id){
        CategoryDTO categoryDTO =null;
        for (Category category : categoryRepository.list("id", id)) {
            categoryDTO = new CategoryDTO(
                    category.getTypeId(),
                    category.getName(),
                    category.getDynasty(),
                    category.getRegion(),
                    category.getScientificName()
            );
        }
        return categoryDTO;
    }


    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> list=new LinkedList<>();
        for (Category category : categoryRepository.findAll().stream().collect(Collectors.toList())) {
            list.add(
                new CategoryDTO(
                        category.getTypeId(),
                        category.getName(),
                        category.getDynasty(),
                        category.getRegion(),
                        category.getScientificName()
            ));
        }
        return list;
    }

    public boolean updateCategory(CategoryDTO dto,long id){
        Category categoryById=categoryRepository.findById(id);
        return categoryById != null && setCategory(dto, categoryById);
    }

    @Transactional
    private boolean setCategory(CategoryDTO dto ,Category categoryById){
        if(!dto.getName().equals("") && dto.getName()!=null){
            categoryById.setName(dto.getName());
        }
        if(!dto.getDynasty().equals("") && dto.getDynasty()!=null){
            categoryById.setDynasty(dto.getDynasty());
        }
        if(!dto.getRegion().equals("") && dto.getRegion()!=null){
            categoryById.setRegion(dto.getRegion());
        }
        if(!dto.getScientificName().equals("") && dto.getScientificName()!=null){
            categoryById.setScientificName(dto.getScientificName());
        }
        return true;
    }

    public boolean deleteCategory(long id){
        Category categoryById=categoryRepository.findById((id));
        return categoryById != null && categoryRepository.deleteById(categoryById.getTypeId());
    }
}
