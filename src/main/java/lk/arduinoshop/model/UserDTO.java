/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.arduinoshop.model;

import java.util.List;

/**
 *
 * @author Iyona Chithrasena
 */
public class UserDTO {
    private int userId;
    private String userName;
    private  String password;
    private String userStatus;
    private List<UserPrivilegeDTO> userPrivilage;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public List<UserPrivilegeDTO> getUserPrivilage() {
        return userPrivilage;
    }

    public void setUserPrivilage(List<UserPrivilegeDTO> userPrivilage) {
        this.userPrivilage = userPrivilage;
    }
    
    
    
}
