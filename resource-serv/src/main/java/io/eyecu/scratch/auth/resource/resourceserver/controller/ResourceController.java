package io.eyecu.scratch.auth.resource.resourceserver.controller;

import io.eyecu.scratch.auth.resource.resourceserver.model.Model;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ResourceController {


    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(path = "/model/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Model getModel(@PathVariable("id") Integer id,
                          Principal principal) {

        Model model = new Model();
        model.setId(id);
        model.setName(principal.getName());
        return model;
    }

}
