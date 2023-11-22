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
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.model.SalesDTO;

/**
 *
 * @author Iyona Chithrasena
 */
public class OrdersRepository {

    public static Integer getOrderID() throws SQLException {
        String query = "Select max(OrderId) as maxID from cus_order";
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        Integer maxId = null;
        if (resultSet.next()) {
            maxId = resultSet.getInt("MAXID");
        }

        return maxId;
    }

    public static Integer saveOrder(SalesDTO salesDTO) {
        String query = "INSERT INTO mydb.cus_order VALUES('" + salesDTO.getOrderId() + "','" + salesDTO.getDate() + "','" + salesDTO.getUserID() + "')";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer result = dbHandler.upadteQuery(query);
        return result;

    }

    public static boolean saveOrderWithItems(ArrayList<SalesDTO> itemList) {
        boolean status = false;
        String query = "INSERT INTO mydb.order_has_stock "
                + "( Order_OrderId, Order_User_UId, Stock_StockId, Stock_Item_ItemId, quatity, sellingPrice, Discount) VALUES "
                + "( ?, ?, ?, ?, ?, ?, ?)";

        DbHandler dbHandler = DbHandler.getDbHandler();
        Connection conn = dbHandler.getConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);
            for (SalesDTO salesDTO : itemList) {

                pst.setInt(1, salesDTO.getOrderId());
                pst.setString(2, salesDTO.getUserID());
                pst.setString(3, salesDTO.getStockId());
                pst.setString(4, salesDTO.getProductId());
                pst.setInt(5, salesDTO.getQuantity());
                pst.setDouble(6, salesDTO.getSellPrice());
                pst.setDouble(7, salesDTO.getDiscount());

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

    public static boolean updateCurrentQuantity(ArrayList<SalesDTO> itemList) {
        boolean status = false;
        String query = "UPDATE stock SET currentQuantity =? WHERE item_itemId=? and stockId=?";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Connection conn = dbHandler.getConnection();

        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);

            for (SalesDTO salesDTO : itemList) {
                try {
                    pst.setInt(1, salesDTO.getCurrentQuantity());
                    pst.setString(2, salesDTO.getProductId());
                    pst.setString(3, salesDTO.getStockId());

                    pst.addBatch();

                } catch (SQLException ex) {

                    Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex);

                }

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

    public static List<OrderDTO> getAllOrders() throws SQLException {
        String query = "SELECT o.orderId, SUM((s.quatity * s.sellingPrice) - s.discount) AS orderTotal, o.date, o.User_UId FROM cus_order o JOIN order_has_stock s "
                + "ON o.orderId = s.Order_OrderId GROUP BY o.orderId, o.date, o.User_UId";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into orderDTOList list
        List<OrderDTO> orderDTOList = new ArrayList<>();
        while (resultSet.next()) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderID(resultSet.getInt("OrderId"));
            orderDTO.setOrderAmount(resultSet.getDouble("orderTotal"));
            orderDTO.setDate(resultSet.getDate("date"));
            orderDTO.setUserID(resultSet.getString("User_UId"));
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }

    public static List<SalesDTO> getOrderDetails(OrderDTO orderDTO) throws SQLException {
        String query = "SELECT i.itemId, i.ItemName, s.Stock_StockId,s.quatity,s.sellingPrice,s.Discount FROM item i JOIN "
                + "order_has_stock s ON i.ItemId = s.Stock_Item_itemId where s.Order_OrderId='" + orderDTO.getOrderID() + "';";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into orderDTOList list
        List<SalesDTO> salesDTOList = new ArrayList<>();
        while (resultSet.next()) {
            SalesDTO salesDTO = new SalesDTO();
            salesDTO.setProductId(resultSet.getString("itemId"));
            salesDTO.setProductName(resultSet.getString("ItemName"));
            salesDTO.setStockId(resultSet.getString("Stock_StockId"));
            salesDTO.setQuantity(resultSet.getInt("quatity"));
            salesDTO.setSellPrice(resultSet.getDouble("sellingPrice"));
            salesDTO.setDiscount(resultSet.getDouble("Discount"));

            salesDTOList.add(salesDTO);
        }
        return salesDTOList;
    }

    public static Integer getMaxId() throws SQLException {
        String query = "SELECT MAX(Id) AS maxId FROM order_has_stock";
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        Integer maxId = null;
        if (resultSet.next()) {
            maxId = resultSet.getInt("MAXID");
        }

        return maxId;
    }

    public static boolean updateReturnQuantity(ArrayList<SalesDTO> itemList) {
        boolean status = false;
        String query = "UPDATE stock AS s1 JOIN (SELECT currentQuantity FROM stock WHERE item_itemId = ? AND stockId = ?)"
                + " AS s2 SET s1.currentQuantity = s2.currentQuantity + ? WHERE s1.item_itemId = ? AND s1.stockId = ?";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Connection conn = dbHandler.getConnection();

        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);

            for (SalesDTO salesDTO : itemList) {
                try {
                    pst.setString(1, salesDTO.getProductId());
                    pst.setString(2, salesDTO.getStockId());
                    pst.setInt(3, salesDTO.getQuantity()*-1);
                    pst.setString(4, salesDTO.getProductId());
                    pst.setString(5, salesDTO.getStockId());

                    pst.addBatch();

                } catch (SQLException ex) {

                    Logger.getLogger(OrdersRepository.class.getName()).log(Level.SEVERE, null, ex);

                }

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
