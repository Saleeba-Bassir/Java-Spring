package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Burger;
import com.example.demo.repositories.BurgerRepository;

@Service
public class BurgerService {
    // adding the burger repository as a dependency
    @Autowired
    private BurgerRepository burgerRepository;

    // returns all the burger
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }

    // creates a burger
    public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }
//
//    // retrieves a burger
//    public Burger findBurger(Long id) {
//        return burgerRepository.findById(id).orElse(null);
//    }
}
