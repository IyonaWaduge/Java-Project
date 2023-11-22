/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import db.DbHandler;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.model.SalesDTO;
import lk.arduinoshop.model.Stock;

/**
 *
 * @author Iyona Chithrasena
 */
public class ProductRepository {

    public static boolean saveItem(ProductDTO productDTO) {
        boolean status = false;

        String query = "INSERT INTO item VALUES(?,?,?)";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Connection conn = dbHandler.getConnection();
        try {

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, productDTO.getProductId());
            pst.setString(2, productDTO.getProductName());
            pst.setBlob(3, productDTO.getImageStream());

             pst.execute();
             status =true;

        } catch (SQLException ex) {
            Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;

    }

    public static Integer getMaxItemId(String itemName) throws SQLException {
        String query = "select Max(right(ItemId, char_length(ItemId)-locate('" + itemName.charAt(0) + "',itemId)) + 0) "
                + "AS MAXID from mydb.Item  where itemId like '" + itemName.charAt(0) + "%';";
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        Integer maxId = null;
        if (resultSet.next()) {
            maxId = resultSet.getInt("MAXID");
        }

        return maxId;
    }

    public static String getStockID(String itemId) throws SQLException {
        String query = "Select max(StockId) as maxID from stock where Item_ItemId='" + itemId + "'";

        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        String maxStockId = null;
        if (resultSet.next()) {
            maxStockId = resultSet.getString("MAXID");
        }
        return maxStockId;
    }

    public static Integer addProduct(ProductDTO productDTO) {
        String query = "INSERT INTO stock VALUES ('" + productDTO.getStockId() + "','" + productDTO.getInitialQuantity() + "','" + productDTO.getCurrentQuantity() + "','" + productDTO.getOrderPrice()
                + "','" + productDTO.getSellPrice() + "','" + productDTO.getProductId() + "','" + productDTO.getDate() + "')";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer result = dbHandler.upadteQuery(query);
        return result;
    }

    public static Integer saveItemInCategory(String productId, String categoryName) {
        //String selectIdQuery= "SELECT CategoryID from category WHERE CategoryName= '"+categoryName+"'";
        // System.out.println(selectIdQuery);
        String query = "INSERT INTO category_has_Item VALUES((SELECT CategoryID FROM category WHERE CategoryName = '" + categoryName + "'), '" + productId + "');";
        System.out.println(query);
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer result = dbHandler.upadteQuery(query);
        return result;

    }

    public static List<ProductDTO> findAllProduct() throws SQLException {
        String query = "SELECT * FROM Item";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        List<ProductDTO> productDTOList = new ArrayList<>();
        while (resultSet.next()) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(resultSet.getString("ItemID"));
            productDTO.setProductName(resultSet.getString("ItemName"));
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    public static boolean updateSelectedRow(ProductDTO productDTO) {
        boolean status = false;

        String query = "UPDATE Item SET ItemName = ?, ItemImage = ? WHERE ItemId= ? ";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Connection conn = dbHandler.getConnection();
        try {

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, productDTO.getProductName());
            pst.setBlob(2, productDTO.getImageStream());
            pst.setString(3, productDTO.getProductId());

            pst.execute();
            status = true;

        } catch (SQLException ex) {
            Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;

    }

    public static Integer removeItem(String productID) {
        String query = "DELETE FROM Item WHERE ItemId='" + productID + "'";
        //System.out.println(query);
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer result = dbHandler.upadteQuery(query);
        return result;
    }

    public static Integer removeStock(SalesDTO salesDTO) {
        String query = "DELETE FROM Stock WHERE stockId='" + salesDTO.getStockId() + "' AND Item_ItemId='" + salesDTO.getProductId() + "'";
        //System.out.println(query);
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer result = dbHandler.upadteQuery(query);
        return result;
    }

    public static List<SalesDTO> addDataToTable() throws SQLException {
        String query = "SELECT item.itemId, item.itemName,  category.categoryName, stock.currentQuantity, stock.sellingPrice FROM item "
                + "INNER JOIN stock ON item.itemId = stock.Item_ItemId INNER JOIN category_has_item ON item.itemId = category_has_item.Item_ItemId "
                + "INNER JOIN category ON category_has_item.Category_CategoryId = category.categoryId;";

        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        List<SalesDTO> salesDTOList = new ArrayList<>();
        while (resultSet.next()) {
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setProductId(resultSet.getString("ItemID"));
            salesDTO.setProductName(resultSet.getString("ItemName"));
            salesDTO.setCategory(resultSet.getString("CategoryName"));
            salesDTO.setCurrentQuantity(resultSet.getInt("CurrentQuantity"));
            salesDTO.setSellPrice(resultSet.getInt("SellingPrice"));
            salesDTOList.add(salesDTO);
        }
        return salesDTOList;
    }

}
