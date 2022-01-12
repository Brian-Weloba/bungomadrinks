package co.ke.bungomadrinks.web.products.repositories;

import co.ke.bungomadrinks.web.products.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
        return entityManager.find(Product.class, id);
    }

    @Transactional
    public List<Product> getAllProducts() {
        //find all products
        String jpql = "SELECT p FROM Product p";
        return entityManager.createQuery(jpql, Product.class).getResultList();
    }

    @Transactional
    public void saveProduct(Product product) {
        entityManager.persist(product);
    }
}
