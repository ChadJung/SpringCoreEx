package com.springcorex.core.order;

public interface OrderService {
    Order createOrder(Long memberID, String itemName, int itemPrice);
}
