package com.by.blue.berries.main.controller;

import com.by.blue.berries.domain.Product;
import com.by.blue.berries.domain.Role;
import com.by.blue.berries.domain.User;
import com.by.blue.berries.repos.ProductRepository;
import com.by.blue.berries.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Value("${upload.path}")
    private String uploadPath;

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
    public String addProduct(Product product,
                             @RequestParam("file")MultipartFile file) throws IOException {
        if(file != null){
           File uploadFolder = new File(uploadPath);
           if(!uploadFolder.exists()){
               uploadFolder.mkdir();
           }

           String uuidFile = UUID.randomUUID().toString();
           String resultFileName = uuidFile + "." + file.getOriginalFilename();

           file.transferTo(new File(uploadPath+ "/" +resultFileName));

           product.setFilename(resultFileName);
        }
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
        product.setProductName(form.get("productName"));
        product.setPrice(Double.parseDouble(form.get("price")));
        productRepository.updateProductById(Double.parseDouble(form.get("price")), form.get("productName"), id);
        return "redirect:/admin/products";
    }

    @PostMapping("/product/{id}/delete")
    public String productDelete(@PathVariable Long id) throws IOException {
        Product product = productRepository.getById(id);
        Files.deleteIfExists(Paths.get(uploadPath.substring(1)+"/"+product.getFilename()));
        productRepository.delete(product);
        return "redirect:/admin/products";
    }
}
