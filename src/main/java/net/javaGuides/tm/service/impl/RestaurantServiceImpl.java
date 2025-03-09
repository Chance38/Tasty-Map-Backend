package net.javaGuides.tm.service.impl;

import lombok.AllArgsConstructor;
import net.javaGuides.tm.dto.RestaurantDto;
import net.javaGuides.tm.entity.Restaurant;
import net.javaGuides.tm.exception.ResourceNotFoundException;
import net.javaGuides.tm.mapper.RestaurantMapper;
import net.javaGuides.tm.repository.RestaurantRepository;
import net.javaGuides.tm.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {

        Restaurant restaurant = RestaurantMapper.mapToRestaurant(restaurantDto);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantMapper.mapToRestaurantDto(savedRestaurant);
    }

    @Override
    public RestaurantDto getRestaurantById(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant is not exists with given id : " + restaurantId));

        return RestaurantMapper.mapToRestaurantDto(restaurant);
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map((restaurant) -> RestaurantMapper.mapToRestaurantDto(restaurant))
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto updateRestaurant(Long restaurantId, RestaurantDto updatedRestaurant) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant is not exists with given id : " + restaurantId));

        restaurant.setName(updatedRestaurant.getName());
        restaurant.setPhone(updatedRestaurant.getPhone());
        restaurant.setType(updatedRestaurant.getType());

        Restaurant updatedRestaurantObj = restaurantRepository.save(restaurant);

        return RestaurantMapper.mapToRestaurantDto(updatedRestaurantObj);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant is not exists with given id : " + restaurantId));

        restaurantRepository.deleteById(restaurantId);
    }
}
