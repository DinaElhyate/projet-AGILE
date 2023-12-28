package com.example.demo.controllers;

import com.example.demo.beans.Assistant;
import com.example.demo.beans.Assistant ;
import com.example.demo.servicesImpl.ParticipeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assistant")
public class ParticipeController {

    @Autowired
    private ParticipeServiceimpl participeServiceimpl;

    @PostMapping("/add")
    public Assistant  create(@RequestBody Assistant  participe) {
        return participeServiceimpl.create(participe);
    }

    @PutMapping("/edit/{id}")
    public Assistant  update(@RequestBody Assistant  participe, @PathVariable Long id) {
        return participeServiceimpl.update(participe, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return participeServiceimpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public Assistant  get(@PathVariable Long id) {
        return participeServiceimpl.get(id);
    }

    @GetMapping("/all")
    public List<Assistant> getAll() {
        return participeServiceimpl.getAll();
    }
}