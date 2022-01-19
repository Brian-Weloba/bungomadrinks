package co.ke.bungomadrinks.web.products.services;

import co.ke.bungomadrinks.web.products.models.ProductOption;
import co.ke.bungomadrinks.web.products.repositories.ProductOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOptionService {

    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public ProductOptionService(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    public void addProductOptions() {
        productOptionRepository.save(new ProductOption(1, "250ml", 420, 10));
        productOptionRepository.save(new ProductOption(1, "350ml", 580, 15));
        productOptionRepository.save(new ProductOption(1, "750ml", 1300, 30));
        productOptionRepository.save(new ProductOption(2, "750ml", 1700, 10));
        productOptionRepository.save(new ProductOption(3, "250ml", 650, 10));
        productOptionRepository.save(new ProductOption(3, "375ml", 980, 15));
        productOptionRepository.save(new ProductOption(3, "1litre", 2400,10));
        productOptionRepository.save(new ProductOption(4, "375ml", 1800, 10));
        productOptionRepository.save(new ProductOption(4, "1litre", 4600, 10));
        productOptionRepository.save(new ProductOption(5, "750ml", 4500, 10));
        productOptionRepository.save(new ProductOption(6, "750ml", 7000, 10));


    }

    public List<ProductOption> getProductOptions() {
        return productOptionRepository.getAllProducts();
    }
}
