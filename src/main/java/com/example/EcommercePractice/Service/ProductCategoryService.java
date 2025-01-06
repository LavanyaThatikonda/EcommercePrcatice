package com.example.EcommercePractice.Service;

import com.example.EcommercePractice.Entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductCategoryService {

     ProductCategory createProductCategory(ProductCategory productCategory);
     ProductCategory updateProductCategory(ProductCategory productCategory);
     void deleteProductCategory(int id);
     ProductCategory getProductCategoryById(int id);
     List<ProductCategory>getAllProductCategories();

}
