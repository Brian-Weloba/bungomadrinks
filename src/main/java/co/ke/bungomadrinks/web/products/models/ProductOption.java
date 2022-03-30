package co.ke.bungomadrinks.web.products.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ALL")
@Entity
@Table(name = "product_options")
public class ProductOption {
    private static final AtomicInteger lastGeneratedId = new AtomicInteger(0);
    private static final AtomicInteger productSkuGenerated = new AtomicInteger(1000);
    @Id
    private long productOptionId;
    private long productId;
    private String optionVolume;
    private float productOptionPrice;
    private int productStock;
    private int productSku;


    public ProductOption() {
        this.productOptionId = getNextProductOptionsId();
    }

    public ProductOption(long productId, String optionVolume, float productOptionPrice, int productStock) {
        this.productOptionId = getNextProductOptionsId();
        this.productId = productId;
        this.optionVolume = optionVolume;
        this.productOptionPrice = productOptionPrice;
        this.productSku = getNextProductSku();
        this.productStock = productStock;
    }

    public static int getNextProductOptionsId() {
        return lastGeneratedId.incrementAndGet();
    }

    public static int getNextProductSku() {
        return productSkuGenerated.incrementAndGet();
    }

    public long getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionId(int productOptionId) {
        this.productOptionId = productOptionId;
    }

    public String getoptionVolume() {
        return optionVolume;
    }

    public void setoptionVolume(String optionVolume) {
        this.optionVolume = optionVolume;
    }

    public float getproductOptionPrice() {
        return productOptionPrice;
    }

    public void setproductOptionPrice(float productOptionPrice) {
        this.productOptionPrice = productOptionPrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public int getProductSku() {
        return productSku;
    }

    public void setProductSku(int productSku) {
        this.productSku = productSku;
    }
}
