package co.ke.bungomadrinks.web.products.models;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

//@Entity
//@Table(name = "product_options")
public class ProductOption {
    private static AtomicInteger lastGeneratedId = new AtomicInteger(0);
//    @Id
    private static int productOptionId;
    private String OptionName;
    private float ProductOptionPrice;

    public ProductOption() {
        this.productOptionId = getNextProductOptionsId();
    }

    public static int getNextProductOptionsId() {
        return lastGeneratedId.incrementAndGet();
    }

    public static int getProductOptionId() {
        return productOptionId;
    }

    public static void setProductOptionId(int productOptionId) {
        ProductOption.productOptionId = productOptionId;
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
