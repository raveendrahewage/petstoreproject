package com.middleware.mini.project.pet.controller;

import com.middleware.mini.project.pet.DTO.PetDTO;
import com.middleware.mini.project.pet.Service.PetService;
import com.middleware.mini.project.petcategory.DTO.CategoryDTO;
import com.middleware.mini.project.petcategory.Entity.Category;
import com.middleware.mini.project.petcategory.Services.CategoryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pet")
public class PetController {
    @Inject
    private PetService petService;

    @POST
    @Path("add-pet")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPet(PetDTO petDTO){
        return petService.addPet(petDTO)
                ?
                Response.status(Response.Status.OK).build()
                :
                Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPetById(@PathParam("id") long id){
        PetDTO petById = petService.getPetById(id);
        return petById==null
                ?
                Response.status(Response.Status.BAD_REQUEST).build()
                :
                Response.ok(petById).status(Response.Status.OK).build();
    }

    @GET
    @Path("/")
    public Response getAllPets(){
        List<PetDTO> all = petService.getAllPets();
        return all.isEmpty()
                ?
                Response.status(Response.Status.BAD_REQUEST).build()
                :
                Response.ok(all).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePetById(@PathParam("id") long id,PetDTO dto){
        return petService.updatePet(dto,id)
                ?
                Response.status(Response.Status.OK).build()
                :
                Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePetById(@PathParam("id") long id){
        return petService.deletePet(id)
                ?
                Response.status(Response.Status.OK).build()
                :
                Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/search-all")
    public Response searchAll(@QueryParam("content") String content){
        List<PetDTO> allByContent = petService.searchAll(content);
        return allByContent.isEmpty()
                ?
                Response.status(Response.Status.BAD_REQUEST).build()
                :
                Response.ok(allByContent).build();
    }
}
