package co.ke.bungomadrinks.web.products.models;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

//@Entity
//@Table(name = "product_categories")
public class ProductCategory {
    private static AtomicInteger lastGeneratedId = new AtomicInteger(0);
//    @Id
    private static int productCategoryId;
    private String CategoryName;
    private String CategoryDescription;

    public ProductCategory() {
        productCategoryId = getNextProductCategoryId();
    }

    public static int getNextProductCategoryId() {
        return lastGeneratedId.incrementAndGet();
    }

    public static int getProductCategoryId() {
        return productCategoryId;
    }

    public static void setProductCategoryId(int productCategoryId) {
        ProductCategory.productCategoryId = productCategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryDescrioption() {
        return CategoryDescription;
    }

    public void setCategoryDescrioption(String categoryDescrioption) {
        CategoryDescription = categoryDescrioption;
    }
}
