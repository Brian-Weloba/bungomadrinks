package co.ke.bungomadrinks.web.products.models;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductOptions {
    private static AtomicInteger lastGeneratedId = new AtomicInteger(0);
    private static int productOptionId;
    private int ProductId;
    private String OptionName;
    private float ProductOptionPrice;

    public ProductOptions() {
        this.productOptionId = getNextProductOptionsId();
    }

    public static int getNextProductOptionsId() {
        return lastGeneratedId.incrementAndGet();
    }

    public static int getProductOptionId() {
        return productOptionId;
    }

    public static void setProductOptionId(int productOptionId) {
        ProductOptions.productOptionId = productOptionId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getOptionName() {
        return OptionName;
    }

    public void setOptionName(String optionName) {
        OptionName = optionName;
    }

    public float getProductOptionPrice() {
        return ProductOptionPrice;
    }

    public void setProductOptionPrice(float productOptionPrice) {
        ProductOptionPrice = productOptionPrice;
    }
}
