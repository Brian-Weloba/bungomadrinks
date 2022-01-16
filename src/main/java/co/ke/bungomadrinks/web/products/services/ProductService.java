package co.ke.bungomadrinks.web.products.services;

import co.ke.bungomadrinks.web.products.models.Product;
import co.ke.bungomadrinks.web.products.models.ProductCategory;
import co.ke.bungomadrinks.web.products.models.ProductOption;
import co.ke.bungomadrinks.web.products.repositories.ProductCategoryRepository;
import co.ke.bungomadrinks.web.products.repositories.ProductOptionRepository;
import co.ke.bungomadrinks.web.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository prodRepository;
    private final ProductOptionRepository productOptionRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductService(ProductRepository prodRepository,
                          ProductOptionRepository productOptionRepository,
                          ProductCategoryRepository productCategoryRepository) {
        this.prodRepository = prodRepository;
        this.productOptionRepository = productOptionRepository;
        this.productCategoryRepository = productCategoryRepository;
    }


    public void addProducts() {
        prodRepository.saveProduct(new Product(
                "Gilbey's",
                "Gilbey's is a brand of gin, made in the United Kingdom, which is owned by the company of the same name. It is produced in the United Kingdom, and is sold in the United States and Europe.",
                "Gilbey's is a brand of gin that originated in the United Kingdom.",
                "https://www.thecocktaildb.com/images/media/drink/vqyxqp1487603168.jpg",
                "Gin"));

        prodRepository.saveProduct(new Product(
                "Bacardi",
                "Bacardi is a brand of rum that originated in Cuba.",
                "Based in Cuba, Bacardi is a brand of rum that originated in Cuba.",
                "https://www.thecocktaildb.com/images/media/drink/vqyxqp1487603168.jpg",
                "Rum"));

        prodRepository.saveProduct(new Product(
                "Jack Daniels",
                "Jack Daniels is a brand of whiskey that originated in the United States.",
                "Jack Daniels is a brand of whiskey that originated in the United States.",
                "https://www.thecocktaildb.com/images/media/drink/vqyxqp1487603168.jpg",
                "Whisky"));


    }


    public List<Product> getAllProducts() {
        return prodRepository.getAllProducts();
    }

    public Product getProduct(Long id) {
        return prodRepository.getProduct(id);
    }

    public void addProduct(Product product) {
        prodRepository.saveProduct(product);
    }

    public void updateProduct(Long id, Product product) {
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
        prodRepository.updateProduct(id, product);
    }

    public void deleteProduct(Long id) {
        prodRepository.deleteProduct(id);
    }

    public List<ProductOption> getProductOptions(Long id) {
        return prodRepository.getProductOptions(id);
    }

    public void addProductOption(Long id, ProductOption productOption) {
        Product product = prodRepository.getProduct(id);
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
        product.addProductOption(productOption);
        prodRepository.updateProduct(id, product);
    }

    public void updateProductOption(Long id, Long optionId, ProductOption productOption) {
        Product product = prodRepository.getProduct(id);
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
//        product.updateProductOption(optionId, productOption);
        productOptionRepository.updateProductOption(optionId, productOption);
        prodRepository.updateProduct(id, product);
    }

    public void deleteProductOption(Long id, Long optionId) {
        Product product = prodRepository.getProduct(id);
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
        productOptionRepository.deleteProductOption(optionId);
        prodRepository.updateProduct(id, product);
    }

    public ProductOption getProductOptionById(Long id, Long optionId) {
        return productOptionRepository.getProductOptionById(optionId);
    }

    public List<ProductCategory> getProductCategories(Long id) {
        return prodRepository.getProductCategories(id);
    }

    public ProductCategory addProductCategory(Long id, ProductCategory productCategory) {
        productCategoryRepository.addProductCategory(id, productCategory);
        return productCategory;
    }

    public ProductCategory updateProductCategory(Long id, Long categoryId, ProductCategory productCategory) {
        productCategoryRepository.updateProductCategory(categoryId, productCategory);
        return productCategory;
    }

    public void deleteProductCategory(Long id, Long categoryId) {
        productCategoryRepository.deleteProductCategory(categoryId);
    }

    public ProductCategory getProductCategory(Long id, Long categoryId) {
        return productCategoryRepository.getProductCategory(categoryId);
    }
}
