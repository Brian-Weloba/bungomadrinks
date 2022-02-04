package co.ke.bungomadrinks.web.products.services;

import co.ke.bungomadrinks.web.products.models.Product;
import co.ke.bungomadrinks.web.products.models.ProductCategory;
import co.ke.bungomadrinks.web.products.repositories.ProductCategoryRepository;
import co.ke.bungomadrinks.web.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository, ProductRepository productRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
    }


    public void addProductCategories() {
        productCategoryRepository.save(new ProductCategory(1, "Gin", "Gin is a distilled alcoholic drink made from juniper berries (Juniperus communis), juniper berry juice, and sugar. Gin is made by the distillation of juniper berries, which are the seeds of juniper plants. Juniper berries are used in herbal remedies, and are also used in making many types of tonic."));
        productCategoryRepository.save(new ProductCategory(2, "Rum", "Rum is a distilled alcoholic drink made from sugarcane juice, water, and ethanol. The name rum comes from the Old Spanish word rumb, meaning bitter. The term rum is also used for other types of rum, e.g., vodka, cognac, and tequila."));
        productCategoryRepository.save(new ProductCategory(3, "Whiskey", "Whiskey is a distilled alcoholic drink made from fermented grain mash, typically corn (maize), rye, or wheat, flavored with hops, sometimes flavored with other fruits, spices, or artificial flavorings, and flavored with water, distillates, or brandy. Whiskey is typically aged in wooden casks, but also in bottles, kegs, and jugs."));
        productCategoryRepository.save(new ProductCategory(3, "Hot", "Products on High Demand"));
        productCategoryRepository.save(new ProductCategory(1, "Hot", "Products on High Demand"));

    }

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory getProductCategoryByProductId(Long productId) {
        return productCategoryRepository.findByProductId(productId);
    }

    public void createProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    public void updateProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }

    public List<Product> getAllProductsByCategoryName(String name) {
//        List<ProductCategory> productCategories = productCategoryRepository.findAll();
//        List<Product> products = new ArrayList<>();
//        for (ProductCategory productCategory : productCategories) {
//            if (productCategory.getCategoryName().equalsIgnoreCase(name)) {
//                Product prod = productRepository.getProduct(productCategory.getProductId());
//                products.add(prod);
//            }
//        }

        List<Product> products = productRepository.findAllByProductCategory(name);


        return products;
    }
}
