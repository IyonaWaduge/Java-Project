/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.arduinoshop.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.arduinoshop.model.OrderDTO;
import lk.arduinoshop.model.SalesDTO;
import repository.OrdersRepository;

/**
 *
 * @author Iyona Chithrasena
 */
public class OrderController {

    public static Integer autoOrderID() throws SQLException {

        Integer maxId = OrdersRepository.getOrderID();
        String orderID;
        if (maxId == null) {
            maxId = 1;

        } else {
            maxId = maxId + 1;

        }
        return maxId;
    }

    public static boolean addOrder(SalesDTO salesDTO) {
        boolean result = false;
        int itemResult = OrdersRepository.saveOrder(salesDTO);
        if (itemResult > 0) {
            result = true;

        }
        return result;
    }

    public static boolean addItemsInOrder(ArrayList<SalesDTO> itemList) {
        boolean result = false;
        result = OrdersRepository.saveOrderWithItems(itemList);

        return result;
    }

    public static boolean updateCurrentQuantity(ArrayList<SalesDTO> itemList) {
        boolean result = false;
        result = OrdersRepository.updateCurrentQuantity(itemList);

        return result;
    }

    public static ArrayList<OrderDTO> getAllOrders() {
        List<OrderDTO> orderList = null;
        try {
            orderList = OrdersRepository.getAllOrders();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<OrderDTO>) orderList;
    }

    public static ArrayList<SalesDTO> getOrderDetail(OrderDTO orderDTO) {
        List<SalesDTO> orderDetailList = null;
        try {
            orderDetailList = OrdersRepository.getOrderDetails(orderDTO);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<SalesDTO>) orderDetailList;
    }

    public static Integer maxID() {
        Integer maxId = null;
        try {
            maxId = OrdersRepository.getMaxId();

            if (maxId == null) {
                maxId = 1;

            } else {
                maxId = maxId + 1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxId;
    }

}
