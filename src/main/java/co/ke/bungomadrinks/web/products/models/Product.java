package co.ke.bungomadrinks.web.products.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "Products")
public class Product {
    private static AtomicInteger lastGeneratedId = new AtomicInteger(0);
    @Id
    private long productId;
    private final String productSKU;
    private String productName;
    private float basicProductPrice;
    private String basicUnitVolume;
    private String productShortDescription;
    private String productLongDescription;
    private String productImage;
    @Transient
    private List<ProductCategory> productCategories;
    private Timestamp productUpdateDate;
    private Timestamp productCreateDate;
    private String productStatus;
    private int productStock;
    private String productType;
    @Transient
    private List<ProductOption> productOptions;

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
        this.productUpdateDate = new Timestamp(System.currentTimeMillis());
        this.productCreateDate = new Timestamp(System.currentTimeMillis());
        this.productStatus = productStatus;
        this.productStock = productStock;
        this.productType = productType;
    }

    //method to increment id
    public static long getProductUniqueId() {
        return lastGeneratedId.incrementAndGet();
    }


    public long getProductId() {
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

    public List<ProductCategory> getProductCategoryId() {
        return productCategories;
    }

    public void setProductCategoryId(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
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

    public void addProductCategory(ProductCategory productCategory) {
        this.productCategories.add(productCategory);
    }

    public void removeProductCategory(ProductCategory productCategory) {
        this.productCategories.remove(productCategory);
    }

    public void removeAllProductCategories() {
        this.productCategories.clear();
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public List<ProductOption> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOption> productOptions) {
        this.productOptions = productOptions;
    }

    public void addProductOption(ProductOption productOption) {
        this.productOptions.add(productOption);
    }

    public void removeProductOption(ProductOption productOption) {
        this.productOptions.remove(productOption);
    }

    public void removeAllProductOptions() {
        this.productOptions.clear();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productSKU='" + productSKU + '\'' +
                ", productName='" + productName + '\'' +
                ", basicProductPrice=" + basicProductPrice +
                ", basicUnitVolume='" + basicUnitVolume + '\'' +
                ", productShortDescription='" + productShortDescription + '\'' +
                ", productLongDescription='" + productLongDescription + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productCategories=" + productCategories +
                ", productUpdateDate=" + productUpdateDate +
                ", productCreateDate=" + productCreateDate +
                ", productStatus='" + productStatus + '\'' +
                ", productStock=" + productStock +
                ", productType='" + productType + '\'' +
                '}';
    }
}
