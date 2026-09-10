package com.tomforecastingservice.forecasting_service.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByRestaurantIdAndName(Long restaurantId, String name);
    List<Product> findByRestaurantId(Long restaurantId);

}
