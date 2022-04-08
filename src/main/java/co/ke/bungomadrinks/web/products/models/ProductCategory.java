package co.ke.bungomadrinks.web.products.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "product_categories")
public class ProductCategory {
    private static final AtomicInteger lastGeneratedId = new AtomicInteger(0);
    @Id
    private long productCategoryId;
    private long productId;
    private String categoryName;
    @Column(columnDefinition = "TEXT")
    private String categoryDescription;

    public ProductCategory() {
        productCategoryId = getNextProductCategoryId();
    }

    public ProductCategory(long productId, String categoryName, String categoryDescription) {
        this.productCategoryId = getNextProductCategoryId();
        this.productId = productId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public ProductCategory(String categoryName, String categoryDescription) {
        this.productCategoryId = getNextProductCategoryId();
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public static int getNextProductCategoryId() {
        return lastGeneratedId.incrementAndGet();
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescrioption) {
        categoryDescription = categoryDescrioption;
    }
}
