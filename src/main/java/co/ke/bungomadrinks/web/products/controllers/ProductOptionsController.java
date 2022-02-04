package co.ke.bungomadrinks.web.products.controllers;

import co.ke.bungomadrinks.web.products.models.ProductOption;
import co.ke.bungomadrinks.web.products.services.ProductOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products/options")
@CrossOrigin("*")
public class ProductOptionsController {

    private final ProductOptionService productOptionsService;

    @Autowired
    public ProductOptionsController(ProductOptionService productOptionsService) {
        this.productOptionsService = productOptionsService;
    }

    @GetMapping
    public List<ProductOption> getProductOptions() {
        return productOptionsService.getProductOptions();
    }

}