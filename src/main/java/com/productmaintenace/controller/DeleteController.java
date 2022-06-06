package com.productmaintenace.controller;


import com.productmaintenace.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class DeleteController {
    private ProductService productService;

    @GetMapping("confirmdelete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "confirmdelete";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
