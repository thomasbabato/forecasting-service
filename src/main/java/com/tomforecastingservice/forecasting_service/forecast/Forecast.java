package com.tomforecastingservice.forecasting_service.forecast;

import com.tomforecastingservice.forecasting_service.product.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "forecasts")
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "forecast_date")
    private LocalDate forecastDate;

    @Column(name = "predicted_quantity")
    private BigDecimal predictedQuantity;

    @Column(name = "generated_at")
    @CreationTimestamp
    private Instant generatedAt;


    // getters & setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(LocalDate forecastDate) {
        this.forecastDate = forecastDate;
    }

    public BigDecimal getPredictedQuantity() {
        return predictedQuantity;
    }

    public void setPredictedQuantity(BigDecimal predictedQuantity) {
        this.predictedQuantity = predictedQuantity;
    }

    public Instant getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Instant generatedAt) {
        this.generatedAt = generatedAt;
    }
}
