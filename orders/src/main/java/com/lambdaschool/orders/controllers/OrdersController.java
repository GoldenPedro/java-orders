package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The entry point for clients to access Orders data
 */
@RestController
@RequestMapping("/orders")
public class OrdersController
{
    /**
     * The entry point for orders to access Order data
     */
    @Autowired
    OrdersService ordersService;

    /**
     * Returns all orders with their customers that have an advanceamount greater than 0.
     * <br> Example: <a href="http://localhost:2019/orders/advanceamount">http://localhost:2019/orders/advanceamount</a>.
     *
     * @return JSON List of all orders with their customers that have an advanceamount greater than 0.
     */
    @GetMapping(value = "/advanceamount")
    public ResponseEntity<?> getOrdersWithAdvanceAmount()
    {
        List<Order> myOrderList = ordersService.findOrdersWithAdvanceAmount();
        return new ResponseEntity<>(myOrderList,
                HttpStatus.OK);
    }

    /**
     * Returns a single order based off of an ordernum.
     * <br>Example: <a href="http://localhost:2019/orders/order/50">http://localhost:2019/orders/order/50</a>.
     *
     * @param ordernum The ordernum for the order you seek.
     * @return JSON of the order you seek with a status of OK.
     */
    @GetMapping(value = "/order/{ordernum}",
            produces = {"application/json"})
    public ResponseEntity<?> getOrderByNumber(
            @PathVariable
                    long ordernum)
    {
        Order o = ordersService.findOrdersById(ordernum);
        return new ResponseEntity<>(o,
                HttpStatus.OK);
    }
}
