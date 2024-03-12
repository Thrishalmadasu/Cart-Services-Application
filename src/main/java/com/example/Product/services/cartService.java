package com.example.Product.services;


import java.util.ArrayList;


import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.example.Product.dto.fakeStoreCartDto;

@Service
public class cartService {
    RestTemplate rt = new RestTemplate();
    String url = "https://fakestoreapi.com";
    

    public fakeStoreCartDto[] getAll(){
        fakeStoreCartDto[] response = rt.getForObject(url+"/carts",fakeStoreCartDto[].class);
        return response; 
    }

    public fakeStoreCartDto getCartById(Long id){
        fakeStoreCartDto response = rt.getForObject(url+"/carts/"+id,fakeStoreCartDto.class);
        return response;
    }

    public fakeStoreCartDto addNewCart(fakeStoreCartDto cart){
        var response = rt.postForObject(url+"/carts",cart,fakeStoreCartDto.class);
        return response;
    }

    public fakeStoreCartDto updateCart(Long id, fakeStoreCartDto cart){
        rt.put(url+"/products/"+id,cart);
        return cart;
    }


    public fakeStoreCartDto deleteCart(Long id){
        fakeStoreCartDto response = rt.getForObject(url+"/carts/"+id,fakeStoreCartDto.class);
        rt.delete(url+"/carts/"+id);
        return response;
    }

    public ArrayList<fakeStoreCartDto> getUserCart(Long id){
        fakeStoreCartDto[] response = rt.getForObject(url+"/carts",fakeStoreCartDto[].class);
        ArrayList<fakeStoreCartDto> arr=new ArrayList<>();
        for(int i=0;i<response.length;i++){
            if(response[i].getUserId()==id){
                arr.add(response[i]);
            }
        }
        return arr;
    }
    
    public fakeStoreCartDto[] inDateRange(String startDate,String endDate){
        fakeStoreCartDto[] response = rt.getForObject(url+"/carts?startdate="+startDate+"&enddate="+endDate,fakeStoreCartDto[].class);
        return response;
    }
}
