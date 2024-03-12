package com.denfil.simplerest.controller;

import com.denfil.simplerest.dto.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/api/main")
    public String mainListener(){
        return "Hello World!";
    }
    @GetMapping("/api/get")
    public String getCat(){
        Cat cat = new Cat("Barsik", 5, 15);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("error with cat");
        }
        return jsonData;
    }
    @GetMapping("/api/getcat")
    public Cat getMyCat(){
        return new Cat("Alex", 10, 14);
    }
    @PostMapping("/api/special")
    public String getSpecialCat(@RequestParam String name){
        try {
            return objectMapper.writeValueAsString(
                    new Cat(name, 12, 13)
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error with name");
        }
    }
}
