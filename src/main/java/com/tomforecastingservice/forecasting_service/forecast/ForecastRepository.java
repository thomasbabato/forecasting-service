package com.tomforecastingservice.forecasting_service.forecast;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {
    List<Forecast> findByProductId(Long productId);

}
