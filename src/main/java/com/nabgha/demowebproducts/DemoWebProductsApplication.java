package com.nabgha.demowebproducts;

import com.nabgha.demowebproducts.entities.Product;
import com.nabgha.demowebproducts.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class DemoWebProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebProductsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
                productRepository.save(Product.builder()
                                .name("Computer")
                                .price(10000.00)
                                .quantity(12)
                        .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(10005.00)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smartphone")
                    .price(20000.00)
                    .quantity(2)
                    .build());
            productRepository.save(Product.builder()
                    .name("MacBook Pro 2026")
                    .price(30000.00)
                    .quantity(1)
                    .build());
            productRepository.findAll()
                    .forEach(System.out::println);
        };
    }
}
