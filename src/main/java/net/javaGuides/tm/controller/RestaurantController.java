package net.javaGuides.tm.controller;

import lombok.AllArgsConstructor;
import net.javaGuides.tm.dto.RestaurantDto;
import net.javaGuides.tm.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Build Add Restaurant RESTful API
    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto savedRestaurant = restaurantService.createRestaurant(restaurantDto);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    // Build Get Restaurant RESTful API
    @GetMapping("{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable("id") Long restaurantId) {
        RestaurantDto restaurantDto = restaurantService.getRestaurantById(restaurantId);
        return ResponseEntity.ok(restaurantDto);
    }

    // Build Get ALL Restaurant RESTful API
    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<RestaurantDto> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    // Build Update Restaurant RESTful API
    @PutMapping("{id}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable("id") Long restaurantId,
                                                          @RequestBody RestaurantDto updatedRestaurant) {
        RestaurantDto restaurantDto = restaurantService.updateRestaurant(restaurantId, updatedRestaurant);
        return ResponseEntity.ok(restaurantDto);
    }

    // Build Delete Restaurant RESTful API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRestautant(@PathVariable("id") Long restautantId) {
        restaurantService.deleteRestaurant(restautantId);
        return ResponseEntity.ok("Restaurant deleted successfully!");
    }
}
