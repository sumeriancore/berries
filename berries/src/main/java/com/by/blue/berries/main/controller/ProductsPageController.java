package com.by.blue.berries.main.controller;

import com.by.blue.berries.domain.Product;
import com.by.blue.berries.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsPageController {

//    @Autowired
//    private ProductRepository productRepo;
//
//    @GetMapping("/products")
//    public String products(Model model){
//        List<Product> productList = productRepo.findAll();
//        productList.stream().forEach(b -> model.addAttribute("productName", b.getProductName()));
//        return "products";
//    }
}
