package com.productmaintenace.controller;

import com.productmaintenace.entity.Product;
import com.productmaintenace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductMainController {
    @Autowired  private ProductService productService;

    @GetMapping("/products")
    public String showProductHome(Model model){
          model.addAttribute("products" , productService.getAllProducts());
          return "products";
    }
    @GetMapping("/back")
    public String back(){
        return "redirect:/products";
    }
}
