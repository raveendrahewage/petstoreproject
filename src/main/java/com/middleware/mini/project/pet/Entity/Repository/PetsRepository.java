package com.middleware.mini.project.pet.Entity.Repository;

import com.middleware.mini.project.pet.Entity.Pets;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PetsRepository implements PanacheRepository<Pets> {

}
