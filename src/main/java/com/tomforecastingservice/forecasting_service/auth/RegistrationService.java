package com.tomforecastingservice.forecasting_service.auth;

import com.tomforecastingservice.forecasting_service.restaurant.Restaurant;
import com.tomforecastingservice.forecasting_service.restaurant.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, RestaurantRepository restaurantRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(RegistrationRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);

        Restaurant restaurant = new Restaurant();
        restaurant.setOwner(savedUser);
        restaurant.setName(request.getRestaurantName());
        restaurant.setTimezone(request.getRestaurantTimeZone());
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
    }

}
