package co.ke.bungomadrinks.web.products.models;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductCategory {
    private static AtomicInteger lastGeneratedId = new AtomicInteger(0);
    private static int productCategoryId;
    private String CategoryName;
    private String CategoryDescrioption;

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
        return CategoryDescrioption;
    }

    public void setCategoryDescrioption(String categoryDescrioption) {
        CategoryDescrioption = categoryDescrioption;
    }
}
