/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import db.DbHandler;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.model.SalesDTO;

/**
 *
 * @author Iyona Chithrasena
 */
public class SalesRepository {

    public static String findItemId(ProductDTO productDTO) throws SQLException {
        String query = "Select itemId from item where itemName='" + productDTO.getProductName() + "'";
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        String itemId = null;
        if (resultSet.next()) {
            itemId = resultSet.getString("ItemId");
        }
        return itemId;
    }

    public static String findItemName(ProductDTO productDTO) throws SQLException {
        String query = "Select itemName from item where itemId='" + productDTO.getProductId() + "'";
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        String itemName = null;
        if (resultSet.next()) {
            itemName = resultSet.getString("ItemName");
        }

        return itemName;
    }

    //SELECT item.itemId,item.ItemName,stock.StockId,stock.SellingPrice from item inner join stock on item.ItemId=stock.Item_ItemId where stock.Item_ItemId='A001' and stock.StockId='#001';
    public static SalesDTO getProductDetail(SalesDTO salesDTO) throws SQLException {
        String query = "SELECT item.itemId, item.ItemName, stock.StockId, stock.currentQuantity, stock.SellingPrice, stock.orderPrice, stock.initialQuantity, stock.date,"
                + "category.categoryName FROM item INNER JOIN stock ON item.ItemId = stock.Item_ItemId INNER JOIN category_has_item ON item.ItemId = category_has_item.Item_itemId\n"
                + "INNER JOIN category ON category.categoryID = category_has_item.category_categoryId WHERE stock.Item_ItemId = '" + salesDTO.getProductId()
                + "'AND stock.stockId = (SELECT MAX(stockId) FROM stock WHERE Item_ItemId = '" + salesDTO.getProductId() + "');";
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);

        while (resultSet.next()) {
            salesDTO.setProductId(resultSet.getString("ItemID"));
            salesDTO.setProductName(resultSet.getString("ItemName"));
            salesDTO.setStockId(resultSet.getString("StockID"));
            salesDTO.setSellPrice(resultSet.getDouble("SellingPrice"));
            salesDTO.setCurrentQuantity(resultSet.getInt("currentQuantity"));
            salesDTO.setInitialQuantity(resultSet.getInt("InitialQuantity"));
            salesDTO.setDate(resultSet.getDate("Date"));
            salesDTO.setOrderPrice(resultSet.getDouble("OrderPrice"));
            salesDTO.setCategory(resultSet.getString("CategoryName"));

        }

        return salesDTO;
    }

    public static ArrayList<SalesDTO> searchProductName(SalesDTO salesDTO) throws SQLException {
        String query = "SELECT * from item WHERE ItemName like '%" + salesDTO.getProductName() + "%'";

        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);

        ArrayList<SalesDTO> salesDTOList = new ArrayList<SalesDTO>();

        while (resultSet.next()) {
            SalesDTO salesDTOResult = new SalesDTO();
            ProductDTO productDTO = new ProductDTO();
            
            salesDTOResult.setProductId(resultSet.getString("ItemID"));
            salesDTOResult.setProductName(resultSet.getString("ItemName"));
            Blob imageStream = resultSet.getBlob("ItemImage");
            
            productDTO.setImageStream(imageStream==null?null:imageStream.getBinaryStream());
            salesDTOResult.setProductDTO(productDTO);
            salesDTOList.add(salesDTOResult);

        }

        return salesDTOList;

    }

    public static Integer numberOfStock(SalesDTO salesDTO) throws SQLException {
        String query = "SELECT COUNT(Item_ItemId) as count FROM Stock WHERE Item_ItemId = '" + salesDTO.getProductId() + "' ";

        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        Integer count = null;
        if (resultSet.next()) {
            count = resultSet.getInt("Count");
        }
        return count;

    }

    public static SalesDTO findQuantity(SalesDTO salesDTO) throws SQLException {
        String query = "Select initialQuantity,CurrentQuantity from stock where item_itemId='" + salesDTO.getProductId() + "' and  StockId=  (SELECT MAX(StockId) FROM stock)";
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        while (resultSet.next()) {
            salesDTO.setCurrentQuantity(resultSet.getInt("currentQuantity"));
            salesDTO.setInitialQuantity(resultSet.getInt("InitialQuantity"));
        }
        return salesDTO;
    }

}
