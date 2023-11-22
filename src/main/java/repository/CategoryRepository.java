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

/**
 *
 * @author Iyona Chithrasena
 */
public class CategoryRepository {

    public static Integer getMaxId(String categoryName) throws SQLException {
        String query = "SELECT MAX(CategoryId) AS maxId FROM category";
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        Integer maxId = null;
        if (resultSet.next()) {
            maxId = resultSet.getInt("MAXID");
        }

        return maxId;
    }

    public static Integer addCategory(String categoryName, String categoryId) {
        String query = "INSERT INTO Category VALUES ('" + categoryId + "','" + categoryName + "')";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer result = dbHandler.upadteQuery(query);
        return result;
    }

    public static List<CategoryDTO> findAllcategory() throws SQLException {
        String query = "SELECT * FROM CATEGORY";
        DbHandler dbHandler = new DbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        //Get all result into categoryDTO list
        ArrayList<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
        while (resultSet.next()) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryName(resultSet.getString("categoryName"));
            categoryDTO.setCategoryId(resultSet.getString("categoryId"));
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    public static Integer removeSelectedItem(String categoryID) {
        String query = "DELETE FROM CATEGORY WHERE CategoryId='" + categoryID + "'";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer result = dbHandler.upadteQuery(query);
        return result;
    }

    public static Integer updateSelectedRow(CategoryDTO categoryDTO) {
        String query = "UPDATE Category SET CategoryName = '" + categoryDTO.getCategoryName() + "' WHERE CATEGORYiD='" + categoryDTO.getCategoryId() + "'";
        DbHandler dbHandler = DbHandler.getDbHandler();
        Integer result = dbHandler.upadteQuery(query);
        return result;
    }
    public static Integer itemCount(String idValue ) throws SQLException {
        String query = "SELECT COUNT(*) AS TotalItemCount FROM category_has_item WHERE Category_CategoryId = '"+idValue+"';";
        System.out.println(query);
        DbHandler dbHandler = DbHandler.getDbHandler();
        ResultSet resultSet = dbHandler.executeQuery(query);
        Integer itemCountTotal = null;
        if (resultSet.next()) {
            itemCountTotal = resultSet.getInt("TotalItemCount");
        }

        return itemCountTotal;
    }
}
