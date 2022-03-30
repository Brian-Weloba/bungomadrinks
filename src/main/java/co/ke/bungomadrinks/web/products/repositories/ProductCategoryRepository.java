package co.ke.bungomadrinks.web.products.repositories;

import co.ke.bungomadrinks.web.products.models.ProductCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductCategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(ProductCategory.class, id));
    }

    @Transactional
    public void save(ProductCategory productCategory) {
        entityManager.persist(productCategory);
    }

    @Transactional
    public List<ProductCategory> findAll() {
        return entityManager.createQuery("select pc from ProductCategory pc", ProductCategory.class).getResultList();
    }

    @Transactional
    public ProductCategory findByProductId(Long productId) {
        return entityManager.find(ProductCategory.class, productId);
    }

    public void addProductCategory(Long id, ProductCategory productCategory) {
        productCategory.setProductId(id);
        entityManager.persist(productCategory);
    }

    public void updateProductCategory(Long categoryId, ProductCategory productCategory) {
        ProductCategory productCategory1 = entityManager.find(ProductCategory.class, categoryId);
        if (productCategory1 != null && productCategory1.getCategoryName() != null) {
            productCategory1.setCategoryName(productCategory.getCategoryName());
        }
        if (productCategory.getCategoryDescription() != null) {
            Objects.requireNonNull(productCategory1).setCategoryDescription(productCategory.getCategoryDescription());
        }
        entityManager.persist(productCategory1);
    }

    public void deleteProductCategory(Long categoryId) {
        ProductCategory productCategory = entityManager.find(ProductCategory.class, categoryId);
        if (productCategory != null) {
            entityManager.remove(productCategory);
        }
    }

    public ProductCategory getProductCategory(Long categoryId) {
        return entityManager.find(ProductCategory.class, categoryId);
    }
}
