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
        productOptionRepository.save(new ProductOption(4, "750ml", 1800, 10));
        productOptionRepository.save(new ProductOption(4, "1litre", 4600, 10));
        productOptionRepository.save(new ProductOption(5, "750ml", 1955, 10));
        productOptionRepository.save(new ProductOption(6, "750ml", 7000, 10));
        productOptionRepository.save(new ProductOption(7,"1litre", 850, 10));
        productOptionRepository.save(new ProductOption(8,"750ml", 4500, 10));
        productOptionRepository.save(new ProductOption(9,"750ml", 7000, 10));
        productOptionRepository.save(new ProductOption(10,"750ml", 800, 10));
        productOptionRepository.save(new ProductOption(10,"250ml", 290, 10));
        productOptionRepository.save(new ProductOption(11,"350ml", 810, 10));
        productOptionRepository.save(new ProductOption(11,"750ml", 1500, 10));
        productOptionRepository.save(new ProductOption(12,"250ml", 220, 10));
        productOptionRepository.save(new ProductOption(12,"750ml", 600, 10));
        productOptionRepository.save(new ProductOption(13,"250ml", 310, 10));
        productOptionRepository.save(new ProductOption(14,"750ml", 900, 10));
        productOptionRepository.save(new ProductOption(15,"750ml", 2000, 10));
        productOptionRepository.save(new ProductOption(16,"250ml", 420, 10));
        productOptionRepository.save(new ProductOption(16,"350ml", 580, 15));
        productOptionRepository.save(new ProductOption(16,"750ml", 1300, 30));
        productOptionRepository.save(new ProductOption(17,"250ml", 400, 10));
        productOptionRepository.save(new ProductOption(17,"750ml", 1200, 10));
        productOptionRepository.save(new ProductOption(18,"250ml", 250, 10));
        productOptionRepository.save(new ProductOption(18,"350ml", 420, 10));
        productOptionRepository.save(new ProductOption(18,"375ml", 590, 10));
        productOptionRepository.save(new ProductOption(18,"750ml", 1300, 10));
        productOptionRepository.save(new ProductOption(19,"375ml", 1100, 10));
        productOptionRepository.save(new ProductOption(19,"750ml", 2200, 10));
        productOptionRepository.save(new ProductOption(20,"1litre", 680, 10));
        productOptionRepository.save(new ProductOption(21,"1litre", 755, 10));
        productOptionRepository.save(new ProductOption(22,"1litre", 680, 10));
        productOptionRepository.save(new ProductOption(23,"1litre", 580, 10));
        productOptionRepository.save(new ProductOption(24,"350ml", 100, 10));
        productOptionRepository.save(new ProductOption(25,"330ml", 155, 10));
        productOptionRepository.save(new ProductOption(26,"330ml", 170, 10));
        productOptionRepository.save(new ProductOption(27,"500ml", 190, 10));
        productOptionRepository.save(new ProductOption(28,"500ml", 200, 10));
        productOptionRepository.save(new ProductOption(29,"500ml", 170, 10));
        productOptionRepository.save(new ProductOption(30,"500ml", 210, 10));
        productOptionRepository.save(new ProductOption(31,"500ml", 195, 10));
        productOptionRepository.save(new ProductOption(32,"500ml", 210, 10));
        productOptionRepository.save(new ProductOption(33,"500ml", 200, 10));
        productOptionRepository.save(new ProductOption(34,"500ml", 190, 10));


    }

    public List<ProductOption> getProductOptions() {
        return productOptionRepository.getAllProducts();
    }
}
