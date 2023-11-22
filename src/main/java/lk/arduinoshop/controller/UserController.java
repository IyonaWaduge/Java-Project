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
import lk.arduinoshop.model.UserDTO;
import lk.arduinoshop.model.UserPrivilegeDTO;
import repository.UserRepository;

/**
 *
 * @author Iyona Chithrasena
 */
public class UserController {

    public static UserDTO loginUser(UserDTO userDto) throws SQLException {

        UserDTO userDtoReturn = UserRepository.findByUserName(userDto);
        return userDtoReturn;
    }

    public static List<UserDTO> allUsers() {

        List<UserDTO> userDTOs = null;
        try {
            userDTOs = UserRepository.allUsers();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userDTOs;
    }

    public static List<UserPrivilegeDTO> allPrivileges() {
        List<UserPrivilegeDTO> userPrivilegeDTOList = null;
        try {
            userPrivilegeDTOList = UserRepository.allPrivileges();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userPrivilegeDTOList;
    }

    public static boolean addUserWithPrivilege(UserDTO userDTO) {
        boolean userAdded = false;
        boolean PrivilagesAdded = false;

        userAdded = UserRepository.addUser(userDTO);
        
        
        
        PrivilagesAdded = addPrivilagesToUser(userDTO.getUserPrivilage());
        return userAdded && PrivilagesAdded;
    }

    public static boolean addPrivilagesToUser(List<UserPrivilegeDTO> privilageList) {
        boolean result = false;
        result = UserRepository.saveUserPrivilages(privilageList);

        return result;
    }

    public static Integer maxID() {
        Integer maxId = null;
        try { 
            maxId = UserRepository.getMaxUserId() + 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxId;
    }

    public static boolean softDeleteUser(int userId) {
        return UserRepository.softDeleteUser(userId);
        
    }

    public static boolean resetUser(UserDTO userDTO) {
        return UserRepository.resetUser(userDTO);
    
    }
}
