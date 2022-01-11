package co.ke.bungomadrinks.web.products.models;

import java.sql.Timestamp;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static AtomicInteger lastGeneratedId = new AtomicInteger(0);
    private String productId;
    private final String productSKU;
    private String productName;
    private float basicProductPrice;
    private String basicUnitVolume;
    private String productShortDescription;
    private String productLongDescription;
    private String productImage;
    private int productCategoryId;
    private Timestamp productUpdateDate;
    private Timestamp productCreateDate;
    private String productStatus;
    private int productStock;
    private String productType;

    public Product() {
        this.productId = getProductUniqueId();
        this.productSKU = UUID.randomUUID().toString();
        this.productUpdateDate = new Timestamp(System.currentTimeMillis());
        this.productCreateDate = new Timestamp(System.currentTimeMillis());
    }

    public Product(String productName, float basicProductPrice, String basicUnitVolume, String productShortDescription, String productLongDescription, String productImage, int productCategoryId, String productStatus, int productStock, String productType) {
        this.productId = getProductUniqueId();
        this.productSKU = UUID.randomUUID().toString();
        this.productName = productName;
        this.basicProductPrice = basicProductPrice;
        this.basicUnitVolume = basicUnitVolume;
        this.productShortDescription = productShortDescription;
        this.productLongDescription = productLongDescription;
        this.productImage = productImage;
        this.productCategoryId = productCategoryId;
        this.productUpdateDate = new Timestamp(System.currentTimeMillis());
        this.productCreateDate = new Timestamp(System.currentTimeMillis());
        this.productStatus = productStatus;
        this.productStock = productStock;
        this.productType = productType;
    }

    //method to increment id
    public static String getProductUniqueId() {
        return String.valueOf(lastGeneratedId.incrementAndGet());
    }


    public String getProductId() {
        return productId;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getBasicProductPrice() {
        return basicProductPrice;
    }

    public void setBasicProductPrice(float basicProductPrice) {
        this.basicProductPrice = basicProductPrice;
    }

    public String getBasicUnitVolume() {
        return basicUnitVolume;
    }

    public void setBasicUnitVolume(String basicUnitVolume) {
        this.basicUnitVolume = basicUnitVolume;
    }

    public String getProductShortDescription() {
        return productShortDescription;
    }

    public void setProductShortDescription(String productShortDescription) {
        this.productShortDescription = productShortDescription;
    }

    public String getProductLongDescription() {
        return productLongDescription;
    }

    public void setProductLongDescription(String productLongDescription) {
        this.productLongDescription = productLongDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Timestamp getProductUpdateDate() {
        return productUpdateDate;
    }

    public void setProductUpdateDate(Timestamp productUpdateDate) {
        this.productUpdateDate = productUpdateDate;
    }

    public Timestamp getProductCreateDate() {
        return productCreateDate;
    }

    public void setProductCreateDate(Timestamp productCreateDate) {
        this.productCreateDate = productCreateDate;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
