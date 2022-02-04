package co.ke.bungomadrinks.web.products.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "Products")
public class Product {
    private static final AtomicInteger lastGeneratedId = new AtomicInteger(0);
    @Id
    private long productId;
    private String productName;
    private int defaultOption;
    @Column(columnDefinition = "TEXT")
    private String productDescription;
    private String productImage;
    @Transient
    private List<ProductCategory> productCategories = new ArrayList<>();
    private Timestamp productUpdateDate;
    private Timestamp productCreateDate;
    private String productStatus;
    @Transient
    private int productStock;
    private String productType;
    @Transient
    private List<ProductOption> productOptions = new ArrayList<>();

    public Product() {
        this.productId = getProductUniqueId();
        this.productUpdateDate = new Timestamp(System.currentTimeMillis());
        this.productCreateDate = new Timestamp(System.currentTimeMillis());
    }


    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public Product(String productName, String productDescription, String productImage, String productType) {
        this.productId = getProductUniqueId();
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productUpdateDate = new Timestamp(System.currentTimeMillis());
        this.productCreateDate = new Timestamp(System.currentTimeMillis());
        this.productType = productType;
    }

    public Product(String productName, int defaultOption, String productDescription, String productImage, String productType) {
        this.productId = getProductUniqueId();
        this.productName = productName;
        this.defaultOption = defaultOption;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productUpdateDate = new Timestamp(System.currentTimeMillis());
        this.productCreateDate = new Timestamp(System.currentTimeMillis());
        this.productType = productType;
    }

    //method to increment id
    public static long getProductUniqueId() {
        return lastGeneratedId.incrementAndGet();
    }

    public void setStock() {
        this.productStock = fetchProductStock();
        this.productStatus = updateProductStatus();
    }

    public int fetchProductStock() {
        int stock = 0;
        for (ProductOption productOption : productOptions) {
            if (productOption.getProductStock() > 0) {
                stock += productOption.getProductStock();
            }
        }

        return stock;
    }

    public String updateProductStatus() {
        if (this.productStock > 0) {
            return "Available";
        } else {
            return "Out of Stock";
        }
    }

    public int getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(int defaultOption) {
        this.defaultOption = defaultOption;
    }

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public float getBasicProductPrice() {
//        return basicProductPrice;
//    }
//
//    public void setBasicProductPrice(float basicProductPrice) {
//        this.basicProductPrice = basicProductPrice;
//    }
//
//    public String getBasicUnitVolume() {
//        return basicUnitVolume;
//    }
//
//    public void setBasicUnitVolume(String basicUnitVolume) {
//        this.basicUnitVolume = basicUnitVolume;
//    }

//    public String getProductShortDescription() {
//        return productShortDescription;
//    }
//
//    public void setProductShortDescription(String productShortDescription) {
//        this.productShortDescription = productShortDescription;
//    }
//
//    public String getProductLongDescription() {
//        return productLongDescription;
//    }
//
//    public void setProductLongDescription(String productLongDescription) {
//        this.productLongDescription = productLongDescription;
//    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
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
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productCategories=" + productCategories +
                ", productUpdateDate=" + productUpdateDate +
                ", productCreateDate=" + productCreateDate +
                ", productStatus='" + productStatus + '\'' +
                ", productStock=" + productStock +
                ", productType='" + productType + '\'' +
                '}';
    }

    public void updateProductOption(Long optionId, ProductOption productOption) {

    }
}
