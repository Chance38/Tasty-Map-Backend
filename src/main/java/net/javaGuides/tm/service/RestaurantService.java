package net.javaGuides.tm.service;

import net.javaGuides.tm.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    RestaurantDto createRestaurant(RestaurantDto restaurantDto);

    RestaurantDto getRestaurantById(Long restaurantId);

    List<RestaurantDto> getAllRestaurants();

    RestaurantDto updateRestaurant(Long restaurantId, RestaurantDto updatedRestaurant);

    void deleteRestaurant(Long restaurantId);
}
