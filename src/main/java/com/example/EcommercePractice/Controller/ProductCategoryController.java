package com.example.EcommercePractice.Controller;


import com.example.EcommercePractice.Entity.ProductCategory;
import com.example.EcommercePractice.Service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("/api/product-categories")
@Slf4j
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping
    public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory) {
        log.info("Received request to create ProductCategory");
        return productCategoryService.createProductCategory(productCategory);
    }

    @PutMapping
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory) {
        log.info("Received request to update ProductCategory with ID: {}", productCategory.getId());
        return productCategoryService.updateProductCategory(productCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteProductCategory(@PathVariable int id) {
        log.info("Received request to delete ProductCategory with ID: {}", id);
        productCategoryService.deleteProductCategory(id);
    }

    @GetMapping("/{id}")
    public ProductCategory getProductCategoryById(@PathVariable int id) {
        log.info("Received request to fetch ProductCategory with ID: {}", id);
        return productCategoryService.getProductCategoryById(id);
    }

    @GetMapping("/getall")
    public List<ProductCategory> getAllProductCategories() {
        log.info("Received request to fetch all ProductCategories");
        return productCategoryService.getAllProductCategories();
    }
}
