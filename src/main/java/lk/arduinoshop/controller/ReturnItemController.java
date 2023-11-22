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
import lk.arduinoshop.model.ReturnDTO;
import lk.arduinoshop.model.SalesDTO;
import repository.OrdersRepository;
import repository.ReturnItemRepository;
import repository.SalesRepository;

/**
 *
 * @author Iyona Chithrasena
 */
public class ReturnItemController {

    public static List<OrderDTO> getOrderIDList() {
        List<OrderDTO> productList = null;
        try {
            productList = ReturnItemRepository.findAllOrderId();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    public static boolean addReturnItemsInOrder(ArrayList<SalesDTO> itemList) {
        boolean result1 = false;
        boolean result2=false;
        result1 = ReturnItemRepository.saveReturnOrderWithItems(itemList);
        result2=ReturnItemRepository.saveReturnWithReason(itemList);
         ArrayList<SalesDTO> updateQuantityList = new ArrayList<>();
        for(SalesDTO salesDTO:itemList){
           String reason=salesDTO.getReturnDTO().getReason();
           if(reason.equals("Change to Another")){
               updateQuantityList.add(salesDTO);
           }
        
        }
        if(!updateQuantityList.isEmpty()){
            boolean result3=OrdersRepository.updateReturnQuantity(itemList);
        }
        
        return result1 && result2;
    }

    public static Integer getTotalQuantity(ReturnDTO returnDTO) {
        Integer totalQuantity = 0;
        try {
            totalQuantity = ReturnItemRepository.findItemQuantity(returnDTO);

        } catch (SQLException ex) {
            Logger.getLogger(ReturnItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalQuantity ;
    }
    
}
