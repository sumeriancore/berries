package com.by.blue.berries.main.controller;

import com.by.blue.berries.domain.Product;
import com.by.blue.berries.repos.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String productsFormAdd(Model model){
        model.addAttribute("adminPage", new Product());
//        model.addAttribute("products", productRepository.findAll().stream().map(b -> new Gson().toJson(b)).collect(Collectors.toList()));
        model.addAttribute("products", productRepository.findAll());
        System.out.println(model.asMap());
        return "adminPage";
    }

    @PostMapping
    public String greetingSubmit(@ModelAttribute Product product, @RequestParam String productName, @RequestParam Double price) {
        product.setPrice(price);
        product.setProductName(productName);
        productRepository.save(product);
        return "redirect:/admin";
    }
}
