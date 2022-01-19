package co.ke.bungomadrinks.web.products.repositories;

import co.ke.bungomadrinks.web.products.models.Product;
import co.ke.bungomadrinks.web.products.models.ProductCategory;
import co.ke.bungomadrinks.web.products.models.ProductOption;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    public Product getProduct(Long id) {
        Product product = entityManager.find(Product.class, id);
        getCategories(product);
        getOptions(product);
        return product;
    }


    @Transactional
    public List<Product> getAllProducts() {
        //find all products
        List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        for (Product product : products) {
            getCategories(product);
            getOptions(product);
            product.setStock();
        }
        return products;
    }

    @Transactional
    public Product deleteProduct(Long id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        return product;
    }

    @Transactional
    public void saveProduct(Product product) {
        entityManager.persist(product);
    }

    public void getCategories(Product product) {
        List<ProductCategory> productCategories = entityManager.createQuery("SELECT pc FROM ProductCategory pc", ProductCategory.class).getResultList();
        for (ProductCategory productCategory : productCategories) {
            if (productCategory.getProductId() == product.getProductId()) {
                product.addProductCategory(productCategory);
            }
        }
    }

    public void getOptions(Product product) {
        List<ProductOption> productOptions = entityManager.createQuery("SELECT p FROM ProductOption p", ProductOption.class).getResultList();
        for (ProductOption productOption : productOptions) {
            if (productOption.getProductId() == product.getProductId()) {
                product.addProductOption(productOption);
            }
        }
    }


    public void updateProduct(Long id, Product product) {
        Product productToUpdate = entityManager.find(Product.class, id);
        productToUpdate.setProductName(product.getProductName());
        productToUpdate.setProductImage(product.getProductImage());
        productToUpdate.setProductDescription(product.getProductDescription());
        entityManager.persist(productToUpdate);
    }


    public List<ProductOption> getProductOptions(Long id) {
        List<ProductOption> options = entityManager.createQuery("SELECT p FROM ProductOption p", ProductOption.class).getResultList();
        List<ProductOption> optionsToReturn = new ArrayList<>();
        for (ProductOption option : options) {
            if (option.getProductId() == id) {
                optionsToReturn.add(option);
            }
        }
        return optionsToReturn;
    }

    public List<ProductCategory> getProductCategories(Long id) {
        List<ProductCategory> productCategories = entityManager.createQuery("SELECT pc FROM ProductCategory pc", ProductCategory.class).getResultList();
        List<ProductCategory> productCategoriesToReturn = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            if (productCategory.getProductId() == id) {
                productCategoriesToReturn.add(productCategory);
            }
        }
        return productCategoriesToReturn;
    }
}
