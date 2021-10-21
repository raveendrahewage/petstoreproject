package com.middleware.mini.project.petcategory.Entity.Repository;

import com.middleware.mini.project.petcategory.Entity.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {
}
