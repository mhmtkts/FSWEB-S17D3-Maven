package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    public Map<Integer, Koala> koalas = new HashMap<>();

    @GetMapping
    public List<Koala> findAll(){ return koalas.values().stream().toList();}

    @GetMapping("/{id}")
    public Koala findById(@PathVariable int id){
        return koalas.get(id);
    }

    @PostMapping
    public Koala save(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }

    @PutMapping("/{id}")
    public Koala save(@PathVariable int id, @RequestBody Koala koala){
        koalas.put(id, koala);
        return koalas.get(id);
    }

    @DeleteMapping("/{id}")
    public Koala save(@PathVariable int id){
        return koalas.remove(id);
    }

}

