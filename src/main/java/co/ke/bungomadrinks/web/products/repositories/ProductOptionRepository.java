package co.ke.bungomadrinks.web.products.repositories;

import co.ke.bungomadrinks.web.products.models.ProductOption;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductOptionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(ProductOption productOption) {
        entityManager.persist(productOption);
    }

    public void updateProductOption(Long optionId, ProductOption productOption) {
        ProductOption productOptionToUpdate = entityManager.find(ProductOption.class, optionId);
        productOptionToUpdate.setoptionVolume(productOption.getoptionVolume());
        productOptionToUpdate.setproductOptionPrice(productOption.getproductOptionPrice());
        productOptionToUpdate.setProductId(productOption.getProductId());
        entityManager.persist(productOptionToUpdate);
    }

    public void deleteProductOption(Long optionId) {
        ProductOption productOptionToDelete = entityManager.find(ProductOption.class, optionId);
        entityManager.remove(productOptionToDelete);
    }

    public ProductOption getProductOptionById(Long optionId) {
        return entityManager.find(ProductOption.class, optionId);
    }

    public List<ProductOption> getAllProducts() {
        return entityManager.createQuery("SELECT p FROM ProductOption p", ProductOption.class).getResultList();
    }
}
