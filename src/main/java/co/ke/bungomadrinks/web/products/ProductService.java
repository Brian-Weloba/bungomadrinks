package co.ke.bungomadrinks.web.products;

import co.ke.bungomadrinks.web.products.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    Product gin = new Product(
            "Gilbey's",
            1300,
            "750ml",
            "Gilbey's is a brand of gin that originated in the United Kingdom.",
            "Gilbey's is a brand of gin that originated in the United Kingdom.",
            "https://www.thecocktaildb.com/images/media/drink/vqyxqp1487603168.jpg",
            1,
            "inStock",
            85,
            "Gin");
    Product barcadi = new Product(
            "Bacardi",
            1300,
            "750ml",
            "Bacardi is a brand of gin that originated in the United Kingdom.",
            "Bacardi is a brand of gin that originated in the United Kingdom.",
            "https://www.thecocktaildb.com/images/media/drink/vqyxqp1487603168.jpg",
            1,
            "inStock",
            85,
            "Gin");
    Product jd = new Product(
            "Jack Daniels",
            1300,
            "750ml",
            "Jack Daniels is a brand of gin that originated in the United Kingdom.",
            "Jack Daniels is a brand of gin that originated in the United Kingdom.",
            "https://www.thecocktaildb.com/images/media/drink/vqyxqp1487603168.jpg",
            1,
            "inStock",
            85,
            "Gin");

    public List<Product> getAllProducts() {
        return List.of(gin, barcadi, jd);
    }
}
