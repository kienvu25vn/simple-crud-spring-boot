package com.productmaintenace.controller;


import com.productmaintenace.entity.Product;
import com.productmaintenace.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class EditController {
    private ProductService productService;

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "edit";
    }

    @PostMapping("/editproduct/{id}")
    public String updateProduct(@PathVariable Long id, @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            return "edit";
        }
        Product productEdit = productService.getProductById(id);
        productEdit.setId(id);
        productEdit.setCode(product.getCode());
        productEdit.setDescription(product.getDescription());
        productEdit.setPrice(product.getPrice());
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
