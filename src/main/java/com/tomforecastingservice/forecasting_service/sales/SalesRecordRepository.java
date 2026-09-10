package com.tomforecastingservice.forecasting_service.sales;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRecordRepository extends JpaRepository<SalesRecord, Long> {
    List<SalesRecord> findByProductId(Long productId);

}
