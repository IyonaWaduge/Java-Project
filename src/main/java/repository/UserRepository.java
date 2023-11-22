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
import lk.arduinoshop.model.UserDTO;
import lk.arduinoshop.model.UserPrivilegeDTO;

/**
 *
 * @author Iyona Chithrasena
 */
public class UserRepository {

    public static UserDTO findByUserName(UserDTO userDto) throws SQLException {
        String query = "SELECT * FROM USER WHERE UserName='" + userDto.getUserName() + "' AND Password ='" + userDto.getPassword() + "'";

        // System.out.println(query);
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        UserDTO userDTOReturn = new UserDTO();
        List<UserPrivilegeDTO> userPrivilage = new ArrayList<>();
        userDTOReturn.setUserPrivilage(userPrivilage);

        if (resultSet.next()) {
            userDTOReturn.setUserId(resultSet.getInt("UId"));
            userDTOReturn.setUserName(resultSet.getString("UserName"));
            userDTOReturn.setUserStatus(resultSet.getString("UserStatus"));
        }

        int userId = userDTOReturn.getUserId();
        query = "SELECT * FROM mydb.userprivilage AS up JOIN mydb.user_has_userprivilage AS uhp ON up.id=uhp.UserPrivilage_id WHERE uhp.User_UId=" + userId;
        resultSet = dbHandler.executeQuery(query);

        while (resultSet.next()) {
            UserPrivilegeDTO userPrivilegeDTO = new UserPrivilegeDTO();
            userPrivilegeDTO.setId(resultSet.getInt("id"));
            userPrivilegeDTO.setPrivilege(resultSet.getString("privilage"));
            userPrivilage.add(userPrivilegeDTO);
        }

        return userDTOReturn;
    }

    public static List<UserDTO> allUsers() throws SQLException {
        String query = "SELECT * FROM mydb.user";

        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        List<UserDTO> userDTOReturnList = new ArrayList<>();

        while (resultSet.next()) {
            UserDTO userDTOReturn = new UserDTO();

            userDTOReturn.setUserId(resultSet.getInt("UId"));
            userDTOReturn.setPassword(resultSet.getString("Password"));
            userDTOReturn.setUserName(resultSet.getString("UserName"));
            userDTOReturn.setUserStatus(resultSet.getString("UserStatus"));
            userDTOReturnList.add(userDTOReturn);
        }

        for (UserDTO userDTO : userDTOReturnList) {

            List<UserPrivilegeDTO> userPrivilage = new ArrayList<>();

            int userId = userDTO.getUserId();
            query = "SELECT * FROM mydb.userprivilage AS up JOIN mydb.user_has_userprivilage AS uhp ON up.id=uhp.UserPrivilage_id WHERE uhp.User_UId=" + userId;
            resultSet = dbHandler.executeQuery(query);

            while (resultSet.next()) {
                UserPrivilegeDTO userPrivilegeDTO = new UserPrivilegeDTO();
                userPrivilegeDTO.setId(resultSet.getInt("id"));
                userPrivilegeDTO.setPrivilege(resultSet.getString("privilage"));
                userPrivilage.add(userPrivilegeDTO);
            }
            userDTO.setUserPrivilage(userPrivilage);
        }

        return userDTOReturnList;
    }

    // SELECT * FROM mydb.userprivilage;
    public static List<UserPrivilegeDTO> allPrivileges() throws SQLException {
        String query = "SELECT * FROM mydb.userprivilage";

        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        List<UserPrivilegeDTO> userPrivilege = new ArrayList<>();

        while (resultSet.next()) {
            UserPrivilegeDTO userPrivilegeDTO = new UserPrivilegeDTO();
            userPrivilegeDTO.setId(resultSet.getInt("id"));
            userPrivilegeDTO.setPrivilege(resultSet.getString("privilage"));
            userPrivilege.add(userPrivilegeDTO);
        }

        return userPrivilege;
    }

    public static boolean addUser(UserDTO userDTO) {
        String query = "INSERT INTO user (UserName, Password, UserStatus) VALUES "
                + "('" + userDTO.getUserName() + "', '" + userDTO.getPassword() + "', '" + userDTO.getUserStatus() + "')";

        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer upadteQuery = dbHandler.upadteQuery(query);

        return upadteQuery > 0 ? true : false;

    }

    public static Integer getMaxUserId() throws SQLException {
        String query = "select MAX(UId) as MAX from user;";
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        Integer maxId = null;
        if (resultSet.next()) {
            maxId = resultSet.getInt("MAX");
        }

        return maxId;
    }

    public static boolean saveUserPrivilages(List<UserPrivilegeDTO> privilageList) {
        boolean status = false;
        String query = "INSERT INTO mydb.user_has_userprivilage (User_uId, userPrivilage_id) "
                + "VALUES (?, (SELECT id FROM userprivilage WHERE privilage = ?));";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Connection conn = dbHandler.getConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(query);
            for (UserPrivilegeDTO userPrivilegeDTO : privilageList) {

                pst.setInt(1, userPrivilegeDTO.getId());
                pst.setString(2, userPrivilegeDTO.getPrivilege());

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

    public static boolean softDeleteUser(int userId) {
        String query = "UPDATE mydb.user SET UserStatus='DELETED' WHERE uid=" + userId;

        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer upadteQuery = dbHandler.upadteQuery(query);

        return upadteQuery > 0 ? true : false;
    }

    public static boolean updateUserAllFields(UserDTO userDto) {

        String query = "UPDATE mydb.user SET UserName = '"+userDto.getUserName()+"', Password = '"+userDto.getPassword()+"', UserStatus = '"+userDto.getUserStatus()+"' "
                + "WHERE UId = "+userDto.getUserId();
        
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer upadteQuery = dbHandler.upadteQuery(query);

        return upadteQuery > 0 ? true : false;

    }

    public static boolean resetUser(UserDTO userDTO) {
        String query = "UPDATE mydb.user SET Password = '"+userDTO.getPassword()+"', UserStatus = '"+userDTO.getUserStatus()+"' "
                + "WHERE UId = "+userDTO.getUserId();
        
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer upadteQuery = dbHandler.upadteQuery(query);

        return upadteQuery > 0 ? true : false;
    }

}
