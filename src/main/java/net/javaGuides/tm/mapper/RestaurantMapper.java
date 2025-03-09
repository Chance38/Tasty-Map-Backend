package net.javaGuides.tm.mapper;

import net.javaGuides.tm.dto.RestaurantDto;
import net.javaGuides.tm.entity.Restaurant;


public class RestaurantMapper {

    public static RestaurantDto mapToRestaurantDto(Restaurant restaurant) {
        return new RestaurantDto(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getType(),
                restaurant.getPhone()
        );
    }

    public static Restaurant mapToRestaurant(RestaurantDto restaurantDto) {
        return new Restaurant(
                restaurantDto.getId(),
                restaurantDto.getName(),
                restaurantDto.getType(),
                restaurantDto.getPhone()
        );
    }
}
