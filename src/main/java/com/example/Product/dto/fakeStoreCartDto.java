package com.example.Product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakeStoreCartDto {
    private int id;
    private int userId;
    private String date;
    private products[] products;

}
