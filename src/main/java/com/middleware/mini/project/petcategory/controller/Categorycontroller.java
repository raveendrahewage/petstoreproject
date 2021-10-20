package com.middleware.mini.project.petcategory.controller;

import com.middleware.mini.project.petcategory.DTO.CategoryDTO;
import com.middleware.mini.project.petcategory.Services.CategoryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pet-category")
public class Categorycontroller {

    @Inject
    private CategoryService categoryService;

    @POST
    @Path("add-category")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCategory(CategoryDTO categoryDTO){
        return categoryService.addCategoryType(categoryDTO)
                ?
                Response.status(Response.Status.OK).build()
                :
                Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCategoryByName(@PathParam("id") long id){
        CategoryDTO typeById = categoryService.getCategoryById(id);
        return typeById==null
                ?
                Response.status(Response.Status.BAD_REQUEST).build()
                :
                Response.ok(typeById).status(Response.Status.OK).build();
    }

    @GET
    @Path("/")
    public Response getAllCategories(){
        List<CategoryDTO> all = categoryService.getAllCategories();
        return all.isEmpty()
                ?
                Response.status(Response.Status.BAD_REQUEST).build()
                :
                Response.ok(all).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategoryById(@PathParam("id") long id,CategoryDTO dto){
        return categoryService.updateCategory(dto,id)
            ?
            Response.status(Response.Status.OK).build()
            :
            Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCategoryById(@PathParam("id") long id){
        return categoryService.deleteCategory(id)
                ?
                Response.status(Response.Status.OK).build()
                :
                Response.status(Response.Status.BAD_REQUEST).build();
    }
}
