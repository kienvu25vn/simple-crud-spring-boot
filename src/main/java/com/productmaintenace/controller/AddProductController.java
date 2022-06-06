package com.productmaintenace.controller;

import com.productmaintenace.entity.Product;
import com.productmaintenace.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AddProductController {

        private ProductService productService;
        @GetMapping("/add")
        public String addView(Model model){
            Product product = new Product();
            model.addAttribute("product", product);
            return "add";
        }
        @PostMapping("/addproduct")
        public String saveProduct( @Valid Product product ,Errors errors){
            if(errors.hasErrors()){
                return "add";
            }
            productService.saveProduct(product);
            return "redirect:/products";

    }
}
