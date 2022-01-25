package co.ke.bungomadrinks.web.products.controllers;

import co.ke.bungomadrinks.web.products.models.Product;
import co.ke.bungomadrinks.web.products.models.ProductCategory;
import co.ke.bungomadrinks.web.products.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/categories")
@CrossOrigin("*")
public class ProductCategoriesController {
    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoriesController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping("/{id}")
    public ProductCategory getProductCategoryByProductId(@PathVariable("id") Long productId) {
        return productCategoryService.getProductCategoryByProductId(productId);
    }

    @PostMapping
    public void createProductCategory(ProductCategory productCategory) {
        productCategoryService.createProductCategory(productCategory);
    }

    @DeleteMapping
    public void deleteProductCategory(Long id) {
        productCategoryService.deleteProductCategory(id);
    }

    @PutMapping
    public void updateProductCategory(@RequestBody ProductCategory productCategory) {
        productCategoryService.updateProductCategory(productCategory);
    }

    @GetMapping("/get")
    public List<Product> getAllProductsByCategoryName(@RequestParam("name") String name) {
        return productCategoryService.getAllProductsByCategoryName(name);
    }
}
