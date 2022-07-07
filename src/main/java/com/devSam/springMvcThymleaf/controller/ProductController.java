package com.devSam.springMvcThymleaf.controller;

import com.devSam.springMvcThymleaf.Entity.Product;
import com.devSam.springMvcThymleaf.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
//    view homepage
    @RequestMapping("/")
    public String ViewHomePage(Model model){
        List<Product> productList = productService.ListAll();
        model.addAttribute("productList",productList);
        return "index";
    }
    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Product product =new Product();
        model.addAttribute("product",product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView EditNewProductForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_product");
        Product product =productService.get(id);
        mav.addObject("product",product);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long Id){
        productService.delete(Id);
        return "redirect:/";
    }

}
