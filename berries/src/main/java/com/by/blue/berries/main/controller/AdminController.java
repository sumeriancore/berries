package com.by.blue.berries.main.controller;

import com.by.blue.berries.domain.Product;
import com.by.blue.berries.domain.Role;
import com.by.blue.berries.domain.User;
import com.by.blue.berries.repos.ProductRepository;
import com.by.blue.berries.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/products")
    public String productsFormAdd(Model model){
        model.addAttribute("adminPage", new Product());
        model.addAttribute("products", productRepository.findAll());
        return "productList";
    }

    @PostMapping("/products")
    public String addProduct(Product product){
        productRepository.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/users")
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }

    @GetMapping("/users/{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEditForm";
    }

    @PostMapping
    public String userUpdate(@RequestParam("id") User user,
                             @RequestParam Map<String, String> form,
                             @RequestParam String username){
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

        user.getRoles().clear();

        for(String key : form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);

        return "redirect:/admin/users";
    }

    @PostMapping("/product/{id}/edit")
    public String productUpdate(@RequestParam Map<String, String> form,
                                @PathVariable Long id){
        Product product = productRepository.getById(id);
        productRepository.delete(product);
        product.setProductName(form.get("productName"));
        product.setPrice(Double.parseDouble(form.get("price")));
        productRepository.save(product);
        return "redirect:/admin/products";
    }
}
