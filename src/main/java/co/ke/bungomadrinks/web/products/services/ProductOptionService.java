package co.ke.bungomadrinks.web.products.services;

import co.ke.bungomadrinks.web.products.models.ProductOption;
import co.ke.bungomadrinks.web.products.repositories.ProductOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOptionService {

    private final ProductOptionRepository productOptionRepository;

    @Autowired
    public ProductOptionService(ProductOptionRepository productOptionRepository) {
        this.productOptionRepository = productOptionRepository;
    }

    public void addProductOptions() {
        productOptionRepository.save(new ProductOption(1, "250ml", 400, 10));
        productOptionRepository.save(new ProductOption(1, "375ml", 600, 15));
        productOptionRepository.save(new ProductOption(1, "1l", 1700, 22));
        productOptionRepository.save(new ProductOption(1, "750ml", 1000, 30));
        productOptionRepository.save(new ProductOption(3, "250ml", 400, 10));
        productOptionRepository.save(new ProductOption(3, "375ml", 600, 15));
        productOptionRepository.save(new ProductOption(2, "1l", 1700, 22));

    }

}
