package co.ke.bungomadrinks.web;

import co.ke.bungomadrinks.web.products.controllers.ProductController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WebApplication.class, args);
        ProductController pc = context.getBean(ProductController.class);

        pc.addProducts();
    }

}
