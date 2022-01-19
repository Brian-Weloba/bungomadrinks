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
                "Gilbey's London Gin",
                3,
                "Gilbey’s Gin is a classic juniper-led London Dry Gin. It is crystal clear with light, floral aromas of juniper along with hints of sweet orange. The palate is clean, light, and dry. Assertive and sharp with a presence of botanicals, juniper, bitter orange rind, and coriander. The finish is moderately long with lingering citrus notes. Gilbey’s Gin is distilled from grain neutral spirits along with 12 other botanicals. It has a reputation of being an inexpensive gin. It may be enjoyed on its own, part of a mixed drink, or a base for cocktails.",
                "gilbeys-gin.jpg",
                "Gin"));

        prodRepository.saveProduct(new Product(
                "Gordon's London Dry Gin",
                4,
                "Almost 250 years ago, Alexander Gordon started his distillery in London and set about creating the recipe for a brilliant tasting gin. Gordon's high quality and distinctive juniper flavour has come to define the taste of the classic G&T. \n Gordon's today is a gin that's enjoyed, not dissected. It's the perfect gin to start a Friday evening, or a Tuesday night catch up with friends, where we share a moment and have a laugh with people we love.",
                "GORDONS-GIN.jpg",
                "Gin"));

        prodRepository.saveProduct(new Product(
                "Johnnie Walker Red Label",
                7,
                "Flowers that bloom into flames. Johnnie Walker Red Label is the world’s best-selling Scotch Whisky. And is made for mixing, both in exhilarating cocktails and with your favorite people. It brings together whiskies specially chosen for their bold, vibrant flavors that add a fiery kick to any mix.",
                "JOHNNIE-WALKER-RED.jpg",
                "Whisky"));

        prodRepository.saveProduct(new Product(
                "Johnnie Walker Black Label",
                9,
                "Johnnie Walker Black Label is one of life’s true icons. A masterful blend of single malt and grain whiskies from across Scotland, aged for at least 12 years. The result is a timeless classic with depth and balance of flavor. Drink it with ice, neat or in a Highball.",
                "johnnie-walker-black-label.jpg",
                "Liquer"));

        prodRepository.saveProduct(new Product(
                "Amarula",
//                10,
                "Amarula is a brand of rum that originated in the United States.",
                "amarula.jpg",
                "Liquer"));

        prodRepository.saveProduct(new Product(
                "Tanqueray",
//                11,
                "Johnnie Walker Green Label is a hidden gem with vibrant secrets to reveal. And with malts from the four corners of Scotland, aged for at least 15 years, it captures the distinct flavors of each landscape in perfect balance. A whisky that’s in harmony with nature..",
                "tanqueray.jpg",
                "Gin"));

        prodRepository.saveProduct(new Product(
                "Cellar Cask Red",
                "Cellar Cask Red is a brand of red wine that originated in the United States.",
                "cellar-cask-red.jpg",
                "Wine"));

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
