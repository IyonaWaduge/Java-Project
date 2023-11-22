/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import db.DbHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.arduinoshop.model.CategoryDTO;
import lk.arduinoshop.model.SalesDTO;

/**
 *
 * @author Iyona Chithrasena
 */
public class ReportRepository {

    public static List<SalesDTO> findAllProducts() throws SQLException {
        String query = "select i.itemID, i.itemName, s.CurrentQuantity from item i inner join stock s on i.ItemId = s.Item_itemId;";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        ArrayList<SalesDTO> categoryDTOList = new ArrayList<SalesDTO>();
        while (resultSet.next()) {
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setProductId(resultSet.getString("ItemID"));
            salesDTO.setProductName(resultSet.getString("ItemName"));
            salesDTO.setCurrentQuantity(Integer.parseInt(resultSet.getString("CurrentQuantity")));
            categoryDTOList.add(salesDTO);
        }
        return categoryDTOList;
    }

    public static List<SalesDTO> findAllLowStockProducts() throws SQLException {
        String query = "select i.itemID, i.itemName, s.CurrentQuantity from item i inner join stock s on i.ItemId = s.Item_itemId "
                + "where s.CurrentQuantity<5";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        ArrayList<SalesDTO> categoryDTOList = new ArrayList<SalesDTO>();
        while (resultSet.next()) {
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setProductId(resultSet.getString("ItemID"));
            salesDTO.setProductName(resultSet.getString("ItemName"));
            salesDTO.setCurrentQuantity(Integer.parseInt(resultSet.getString("CurrentQuantity")));
            categoryDTOList.add(salesDTO);
        }
        return categoryDTOList;
    }

    public static List<SalesDTO> findAllMostStockProducts() throws SQLException {
        String query = "select i.itemID, i.itemName, s.CurrentQuantity from item i inner join stock s on i.ItemId = s.Item_itemId"
                + " where (s.CurrentQuantity/s.InitialQuantity)*100 > 90";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        ArrayList<SalesDTO> categoryDTOList = new ArrayList<SalesDTO>();
        while (resultSet.next()) {
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setProductId(resultSet.getString("ItemID"));
            salesDTO.setProductName(resultSet.getString("ItemName"));
            salesDTO.setCurrentQuantity(Integer.parseInt(resultSet.getString("CurrentQuantity")));
            categoryDTOList.add(salesDTO);
        }
        return categoryDTOList;
    }

    public static List<SalesDTO> findAllOutOfStockProducts() throws SQLException {
        String query = "select i.itemID, i.itemName, s.CurrentQuantity from item i inner join stock s on i.ItemId = s.Item_itemId where s.CurrentQuantity=0";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        ArrayList<SalesDTO> categoryDTOList = new ArrayList<SalesDTO>();
        while (resultSet.next()) {
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setProductId(resultSet.getString("ItemID"));
            salesDTO.setProductName(resultSet.getString("ItemName"));
            salesDTO.setCurrentQuantity(Integer.parseInt(resultSet.getString("CurrentQuantity")));
            categoryDTOList.add(salesDTO);
        }
        return categoryDTOList;
    }

    public static List<SalesDTO> findAllOrders() throws SQLException {
        String query = "SELECT o.date,o.orderId, SUM((s.quatity * s.sellingPrice) - s.discount) AS orderTotal"
                + "  FROM cus_order o JOIN order_has_stock s ON o.orderId = s.Order_OrderId GROUP BY o.orderId, o.date, o.User_UId";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        ArrayList<SalesDTO> salesDTOList = new ArrayList<SalesDTO>();
        while (resultSet.next()) {
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setDate(resultSet.getDate("date"));
            salesDTO.setOrderId(resultSet.getInt("OrderId"));
            salesDTO.setSellPrice((resultSet.getDouble("orderTotal")));
            

            salesDTOList.add(salesDTO);
        }
        return salesDTOList;
    }
}
