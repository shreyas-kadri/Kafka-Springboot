package com.example.Consumer.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String name;

    private String email;

    private List<OrderItemDTO> items;
}