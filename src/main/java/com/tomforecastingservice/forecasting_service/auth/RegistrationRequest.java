package com.tomforecastingservice.forecasting_service.auth;

public class RegistrationRequest {
    private String email;
    private String password;
    private String restaurantName;
    private String restaurantTimeZone;


    // generated getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantTimeZone() {
        return restaurantTimeZone;
    }

    public void setRestaurantTimeZone(String restaurantTimeZone) {
        this.restaurantTimeZone = restaurantTimeZone;
    }
}
