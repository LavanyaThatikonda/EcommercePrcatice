package com.example.EcommercePractice.ServiceImpl;


import com.example.EcommercePractice.Entity.ProductCategory;
import com.example.EcommercePractice.Repository.ProductCategoryRepository;
import com.example.EcommercePractice.Service.ProductCategoryService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Profile("prod")  // This service will only be active in the 'prod' profile
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductCategoryService productCategoryService;

    // Removed @Value and defaultCreator as we are no longer using it
//    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
//        this.productCategoryRepository = productCategoryRepository;
//    }

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        log.debug("Attempting to create a new ProductCategory: {}", productCategory);

        // Removed the setting of defaultCreator
        // If createdBy is null, it will be left as null, or you can handle it differently if needed

        ProductCategory savedCategory = productCategoryRepository.save(productCategory);
        log.info("ProductCategory created successfully with ID: {}", savedCategory.getId());
        return savedCategory;
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        log.debug("Attempting to update ProductCategory: {}", productCategory);

        Optional<ProductCategory> existingCategory = productCategoryRepository.findById(productCategory.getId());
        if (existingCategory.isPresent()) {
            ProductCategory updatedCategory = productCategoryRepository.save(productCategory);
            log.info("ProductCategory with ID: {} updated successfully", productCategory.getId());
            return updatedCategory;
        } else {
            log.error("ProductCategory with ID: {} not found for update", productCategory.getId());
            throw new RuntimeException("ProductCategory not found");
        }
    }

    @Override
    public void deleteProductCategory(int id) {
        log.debug("Attempting to delete ProductCategory with ID: {}", id);

        Optional<ProductCategory> categoryToDelete = productCategoryRepository.findById(id);
        if (categoryToDelete.isPresent()) {
            productCategoryRepository.delete(categoryToDelete.get());
            log.info("ProductCategory with ID: {} deleted successfully", id);
        } else {
            log.error("ProductCategory with ID: {} not found for deletion", id);
            throw new RuntimeException("ProductCategory not found");
        }
    }

    @Override
    public ProductCategory getProductCategoryById(int id) {
        log.debug("Fetching ProductCategory with ID: {}", id);

        Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
        if (productCategory.isPresent()) {
            log.info("ProductCategory found with ID: {}", id);
            return productCategory.get();
        } else {
            log.error("ProductCategory with ID: {} not found", id);
            throw new RuntimeException("ProductCategory not found");
        }
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        log.debug("Fetching all ProductCategories");

        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        log.info("Fetched {} ProductCategories", productCategories.size());
        return productCategories;
    }
}
