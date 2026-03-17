package com.nabgha.demowebproducts.web;

import com.nabgha.demowebproducts.entities.Product;
import com.nabgha.demowebproducts.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AllArgsConstructor
@Controller
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/user/index")
    public String index(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<Product> products = productRepository.findByNameContainsIgnoreCase(keyword);
        model.addAttribute("productList", products);
        model.addAttribute("keyword", keyword);
        return "products";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

    @PostMapping("/admin/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }

    @GetMapping("/admin/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) throw new RuntimeException("Product not found");
        model.addAttribute("product", product);
        return "new-product";
    }

    @GetMapping("/admin/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }

    @PostMapping("/admin/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "new-product";
        productRepository.save(product);
        return "redirect:/user/index";
    }

    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
