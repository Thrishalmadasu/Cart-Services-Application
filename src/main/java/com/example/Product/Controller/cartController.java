package com.example.Product.Controller;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.Product.dto.fakeStoreCartDto;
import com.example.Product.services.cartService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class cartController {

    cartService cs;

    cartController(cartService cs){
        this.cs = cs;
    }

    @GetMapping("/carts")
    public fakeStoreCartDto[] getMethodName() {
        return cs.getAll();
    }

    @GetMapping("/carts/{id}")
    public fakeStoreCartDto getCartById(@PathVariable Long id){
        return cs.getCartById(id);
    }

    @PostMapping("/carts")
    public fakeStoreCartDto addNewCart(@RequestBody fakeStoreCartDto cart) {
        return cs.addNewCart(cart);
    }
    
    @PutMapping("/carts/{id}")
    public fakeStoreCartDto updateCart(@PathVariable Long id, @RequestBody fakeStoreCartDto cart){
        return cs.updateCart(id,cart);
    }

    @DeleteMapping("/carts/{id}")
    public fakeStoreCartDto deleteCart(@PathVariable Long id){
        return cs.deleteCart(id);
    }

    @GetMapping("/carts/user/{id}")
    public ArrayList<fakeStoreCartDto> getUserCart(@PathVariable Long id) {
        return cs.getUserCart(id);
    }

    @GetMapping("/carts/date/")
    public fakeStoreCartDto[] getMethodName(@RequestParam(required = false) String startdate,@RequestParam(required = false) String enddate) {
        return cs.inDateRange(startdate,enddate);
    }
    
    
}
