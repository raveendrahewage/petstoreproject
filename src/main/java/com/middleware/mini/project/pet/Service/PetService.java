package com.middleware.mini.project.pet.Service;
import com.middleware.mini.project.pet.DTO.PetDTO;
import com.middleware.mini.project.pet.Entity.Pets;
import com.middleware.mini.project.pet.Entity.Repository.PetsRepository;
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
public class PetService {
    @Inject
    private PetsRepository petsRepository;
    @Inject
    private CategoryRepository categoryRepository;

    @Transactional
    public boolean addPet(PetDTO pet){
        Category categoryById=categoryRepository.findById(pet.getTypeId());
        if(categoryById!=null){
            Pets newPet = new Pets(
                    pet.getPetName(),
                    pet.getBirthday(),
                    pet.getGender(),
                    pet.getOwner(),
                    pet.getWeight(),
                    categoryById
            );
            petsRepository.persist(newPet);
            return petsRepository.isPersistent(newPet);
        }
        return false;
    }

    @Transactional
    public PetDTO getPetById(long id){
        PetDTO petDTO =null;
        for (Pets pet : petsRepository.list("id", id)) {
            petDTO = new PetDTO(
                    pet.getPetId(),
                    pet.getCategory().getTypeId(),
                    pet.getPetName(),
                    pet.getBirthday(),
                    pet.getGender(),
                    pet.getOwner(),
                    pet.getWeight()
            );
        }
        return petDTO;
    }

    public List<PetDTO> getAllPets(){
        List<PetDTO> list=new LinkedList<>();
        for (Pets pet : petsRepository.findAll().stream().collect(Collectors.toList())) {
            list.add(
                    new PetDTO(
                            pet.getPetId(),
                            pet.getCategory().getTypeId(),
                            pet.getPetName(),
                            pet.getBirthday(),
                            pet.getGender(),
                            pet.getOwner(),
                            pet.getWeight()
                    ));
        }
        return list;
    }

    public boolean updatePet(PetDTO dto,long id){
        Pets petById=petsRepository.findById(id);
        return petById != null && setPet(dto, petById);
    }

    @Transactional
    private boolean setPet(PetDTO dto ,Pets petById){
        if(!dto.getPetName().equals("") && dto.getPetName()!=null){
            petById.setPetName(dto.getPetName());
        }
        if(dto.getBirthday()!=null){
            petById.setBirthday(dto.getBirthday());
        }
        if(!dto.getGender().equals("") && dto.getGender()!=null){
            petById.setGender(dto.getGender());
        }
        if(!dto.getOwner().equals("") && dto.getOwner()!=null){
            petById.setOwner(dto.getOwner());
        }
        if(dto.getWeight()!=0){
            petById.setOwner(dto.getOwner());
        }
        return true;
    }

    public boolean deletePet(long id){
        Pets petById=petsRepository.findById((id));
        return petById != null && petsRepository.deleteById(petById.getPetId());
    }
}
