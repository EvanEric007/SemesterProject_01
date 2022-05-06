package com.example.myapplication.listener;


import com.example.cart.model.CartModel;
import com.example.cart.model.DrinkModel;

import java.util.List;

public interface ICartLoadListener {
    void onCartLoadSuccess(List<CartModel> cartModelList);
    void onCartLoadFailed(String message);
}