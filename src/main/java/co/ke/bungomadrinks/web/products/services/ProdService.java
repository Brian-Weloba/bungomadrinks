package co.ke.bungomadrinks.web.products.services;

import co.ke.bungomadrinks.web.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdService {

    @Autowired
    private ProductRepository prodRepository;
}
