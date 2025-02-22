package com.springboot.controller;

import lombok.Data;

@Data
public class ApplyOfferRequest {
    public int cart_value;
    public int restaurant_id;
    public int user_id;
}
