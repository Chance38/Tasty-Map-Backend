package net.javaGuides.tm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    @Getter@Setter
    private Long id;
    private String name;
    private String type;
    private String phone;
}
