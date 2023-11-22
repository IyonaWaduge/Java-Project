/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.arduinoshop.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.model.SalesDTO;
import repository.ProductRepository;

/**
 *
 * @author Iyona Chithrasena
 */
public class ProductController {

    public static boolean addNewProduct(ProductDTO productDTO) {

        boolean itemResult = ProductRepository.saveItem(productDTO);
        return itemResult;
        
    }

    public static String autoID(ProductDTO productDTO) throws SQLException {

        Integer maxId = ProductRepository.getMaxItemId(productDTO.getProductName());
        String productId;
        if (maxId == 0) {
            productId = productDTO.getProductName().charAt(0) + "001";
        } else {
            maxId = maxId + 1;
            productId = productDTO.getProductName().toUpperCase().charAt(0) + String.format("%03d", maxId);
        }

        return productId;
    }

    public static String autoStockID(ProductDTO productDTO) throws SQLException {

        String maxIdStr = ProductRepository.getStockID(productDTO.getProductId());

        String stockId = "0";
        if (maxIdStr == null) {
            stockId = "#" + "001";
        } else {
            String id = maxIdStr.substring(1, maxIdStr.length());
            int maxId = Integer.parseInt(id);
            maxId = maxId + 1;
            stockId = "#" + String.format("%03d", maxId);
        }
        return stockId;
    }

    public static boolean addStock(ProductDTO productDTO) {
        boolean result = false;
        int stockResult = ProductRepository.addProduct(productDTO);
        if (stockResult > 0) {
            result = true;
        }
        return result;
    }

    public static boolean addItemInCategory(ProductDTO productDTO) {
        boolean result = false;
        int itemResult = ProductRepository.saveItemInCategory(productDTO.getProductId(), productDTO.getCategory());
        if (itemResult > 0) {
            result = true;

        }
        return result;
    }

    public static List<ProductDTO> getProductDTOList() {
        List<ProductDTO> productList = null;
        try {
            productList = ProductRepository.findAllProduct();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    public static boolean updateSelectedRow(ProductDTO productDTO) {
        boolean result =  ProductRepository.updateSelectedRow(productDTO);
        return result;
    }

    public static boolean deleteItem(ProductDTO productDTO) {
        boolean result = false;
        int itemDeleteResult = ProductRepository.removeItem(productDTO.getProductId());
        if (itemDeleteResult > 0) {
            result = true;
        }
        return result;
    }

    public static boolean deleteStock(SalesDTO salesDTO) {
        boolean result = false;
        int itemDeleteResult = ProductRepository.removeStock(salesDTO);
        if (itemDeleteResult > 0) {
            result = true;
        }
        return result;
    }

    public static List<SalesDTO> addDataTotableController() {
        List<SalesDTO> salesDTOList = null;
        try {
            salesDTOList = ProductRepository.addDataToTable();

        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salesDTOList;
    }
}
