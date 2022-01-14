package co.ke.bungomadrinks.web.products.controllers;

import co.ke.bungomadrinks.web.products.models.Product;
import co.ke.bungomadrinks.web.products.models.ProductCategory;
import co.ke.bungomadrinks.web.products.models.ProductOption;
import co.ke.bungomadrinks.web.products.services.ProductCategoryService;
import co.ke.bungomadrinks.web.products.services.ProductOptionService;
import co.ke.bungomadrinks.web.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final ProductOptionService productOptionService;

    @Autowired
    public ProductController(ProductService productService, ProductCategoryService productCategoryService, ProductOptionService productOptionService) {
        this.productCategoryService = productCategoryService;
        this.productService = productService;
        this.productOptionService = productOptionService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}/options")
    public List<ProductOption> getProductOptions(@PathVariable("id") Long id) {
        return productService.getProductOptions(id);
    }

    @PostMapping("add" + "/{id}/options")
    public void addProductOption(@PathVariable("id") Long id, @RequestBody ProductOption productOption) {
        productService.addProductOption(id, productOption);
    }

    @PutMapping("/{id}/options/{optionId}")
    public void updateProductOption(@PathVariable("id") Long id, @PathVariable("optionId") Long optionId, @RequestBody ProductOption productOption) {
        productService.updateProductOption(id, optionId, productOption);
    }

    @DeleteMapping("delete/{id}/options/{optionId}")
    public void deleteProductOption(@PathVariable("id") Long id, @PathVariable("optionId") Long optionId) {
        productService.deleteProductOption(id, optionId);
    }

    @GetMapping("/{id}/options/{optionId}")
    public ProductOption getProductOptionById(@PathVariable("id") Long id, @PathVariable("optionId") Long optionId) {
        return productService.getProductOptionById(id, optionId);
    }

    @GetMapping("/{id}/categories")
    public List<ProductCategory> getProductCategories(@PathVariable("id") Long id) {
        return productService.getProductCategories(id);
    }

    @PostMapping("/{id}/categories")
    public ProductCategory addProductCategory(@PathVariable("id") Long id, @RequestBody ProductCategory productCategory) {
        return productService.addProductCategory(id, productCategory);
    }

    @PutMapping("/{id}/categories/{categoryId}")
    public ProductCategory updateProductCategory(@PathVariable("id") Long id, @PathVariable("categoryId") Long categoryId, @RequestBody ProductCategory productCategory) {
        return productService.updateProductCategory(id, categoryId, productCategory);
    }

    @DeleteMapping("/{id}/categories/{categoryId}")
    public void deleteProductCategory(@PathVariable("id") Long id, @PathVariable("categoryId") Long categoryId) {
        productService.deleteProductCategory(id, categoryId);
    }

    @GetMapping("/{id}/categories/{categoryId}")
    public ProductCategory getProductCategoryById(@PathVariable("id") Long id, @PathVariable("categoryId") Long categoryId) {
        return productService.getProductCategory(id, categoryId);
    }

    public void addProducts() {
        productCategoryService.addProductCategories();
        productService.addProducts();
        productOptionService.addProductOptions();
    }

}
