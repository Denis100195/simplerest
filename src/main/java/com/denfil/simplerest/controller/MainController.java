package com.denfil.simplerest.controller;

import com.denfil.simplerest.dto.Cat;
import com.denfil.simplerest.repo.CatRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class MainController {
    private CatRepo catRepo;

    public MainController(CatRepo catRepo){
        this.catRepo = catRepo;
    }
    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat){
        catRepo.save(cat);
        log.info("New row" + cat);
    }
    @GetMapping("/api/all")
    public List<Cat> getAll(){
        List<Cat> catList = catRepo.findAll();
        return catList;
    }
    @GetMapping("/api/getById/{id}")
    public Cat getCat(@PathVariable(name = "id") Integer id){
        return catRepo.findById(id).orElseThrow();
    }
    @DeleteMapping("/api/deleteById/{id}")
    public void deleteCatById(@PathVariable(name="id") Integer id){
        if (catRepo.findById(id).isPresent()){
            catRepo.deleteById(id);
            log.info("Cat with ID: " + id + " WAS DELETED");
        }
        else log.info("Cat with ID: " + id + " does not exist");
    }
    @PutMapping("/api/")
    public void changeCat(@RequestBody Cat cat){
        if (catRepo.findById(cat.getId()).isPresent()){
            catRepo.save(cat);
            log.info("Cat with ID: " + cat.getId() + " WAS CHANGED");
        }
        else log.info("Cat with ID: " + cat.getId() + " does not exist");
    }
}
