/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import db.DbHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.arduinoshop.model.OrderDTO;
import lk.arduinoshop.model.ReturnDTO;
import lk.arduinoshop.model.SalesDTO;

/**
 *
 * @author Iyona Chithrasena
 */
public class ReturnItemRepository {

    public static List<OrderDTO> findAllOrderId() throws SQLException {
        String query = "SELECT orderID FROM cus_order";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        List<OrderDTO> orderDTOList = new ArrayList<>();
        while (resultSet.next()) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderID(resultSet.getInt("OrderId"));

            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }

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

    public static boolean saveReturnOrderWithItems(ArrayList<SalesDTO> itemList) {
        boolean status = false;
        String query = "INSERT INTO mydb.order_has_stock "
                + "(id, Order_OrderId, Order_User_UId, Stock_StockId, Stock_Item_ItemId, quatity, sellingPrice, Discount) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?)";

        DbHandler dbHandler = DbHandler.getDbHandler();
        Connection conn = dbHandler.getConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);
            for (SalesDTO salesDTO : itemList) {
                pst.setInt(1, salesDTO.getReturnDTO().getOrderHasStockId());
                pst.setInt(2, salesDTO.getOrderId());
                pst.setString(3, salesDTO.getUserID());
                pst.setString(4, salesDTO.getStockId());
                pst.setString(5, salesDTO.getProductId());
                pst.setInt(6, salesDTO.getQuantity());
                pst.setDouble(7, salesDTO.getSellPrice());
                pst.setDouble(8, salesDTO.getDiscount());

                pst.addBatch();
            }
            int result[] = pst.executeBatch();

            for (int i : result) {
                if (i < 0) {
                    status = false;
                    break;
                } else {
                    status = true;
                }

            }
            conn.commit();

        } catch (SQLException ex) {
            try {
                conn.rollback();
                Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }

    public static int findItemQuantity(ReturnDTO returnDTO) throws SQLException {
        String query = "select sum(quatity) as totalQuantity  from order_has_stock where Stock_Item_ItemId='" + returnDTO.getProductID() + "'"
                + " AND Stock_StockId='" + returnDTO.getStockID() + "';";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        List<OrderDTO> orderDTOList = new ArrayList<>();
        int totalQuantity = 0;
        if (resultSet.next()) {

            totalQuantity = resultSet.getInt("totalQuantity");

        }
        return totalQuantity;
    }

    public static boolean saveReturnWithReason(ArrayList<SalesDTO> itemList) {
        boolean status = false;
        String query = "INSERT INTO mydb.return ( Order_has_stock_id, `Date`, Reason) VALUES ( ?, ?, ?);";

        DbHandler dbHandler = DbHandler.getDbHandler();
        Connection conn = dbHandler.getConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);
            for (SalesDTO salesDTO : itemList) {
                pst.setInt(1, salesDTO.getReturnDTO().getOrderHasStockId());
                pst.setDate(2, salesDTO.getReturnDTO().getDate());
                pst.setString(3, salesDTO.getReturnDTO().getReason());
                pst.addBatch();
            }
            int result[] = pst.executeBatch();

            for (int i : result) {
                if (i < 0) {
                    status = false;
                    break;
                } else {
                    status = true;
                }

            }
            conn.commit();

        } catch (SQLException ex) {
            try {
                conn.rollback();
                Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }

}
