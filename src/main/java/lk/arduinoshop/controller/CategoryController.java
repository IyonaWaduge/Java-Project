/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.arduinoshop.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.arduinoshop.model.CategoryDTO;
import repository.CategoryRepository;

/**
 *
 * @author Iyona Chithrasena
 */
public class CategoryController {

    //Check the categoty result is null or not
    public static boolean addNewCategory(CategoryDTO categoryDTO) {
        boolean result = false;
        int categoryResult = CategoryRepository.addCategory(categoryDTO.getCategoryName(), categoryDTO.getCategoryId());
        if (categoryResult > 0) {
            result = true;
        }
        return result;
    }

    //Get maxId from database and generate new categoryId
    public static String autoID(CategoryDTO categoryDTO) throws SQLException {

        Integer maxId = CategoryRepository.getMaxId(categoryDTO.getCategoryName());
        String categoryId;
        if (maxId == 0) {
            categoryId = "001";
        } else {
            maxId = maxId + 1;
            categoryId = String.format("%03d", maxId);
        }

        return categoryId;
    }

    public static List<CategoryDTO> getCategoryDTOList() {
        List<CategoryDTO> categoryList = null;
        try {
            categoryList = CategoryRepository.findAllcategory();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoryList;
    }

    public static boolean deleteSelectedRow(CategoryDTO categoryDTO) {
        boolean result = false;
        int categoryDeleteResult = CategoryRepository.removeSelectedItem(categoryDTO.getCategoryId());
        if (categoryDeleteResult > 0) {
            result = true;
        }
        return result;
    }

    public static boolean updateSelectedRow(CategoryDTO categoryDTO) {
        boolean result = false;
        int updateRowresult = CategoryRepository.updateSelectedRow(categoryDTO);
        if (updateRowresult > 0) {
            result = true;
        }
        return result;
    }

    public static Integer itemCount( String idValue) throws SQLException {

        Integer itemCountTotal = CategoryRepository.itemCount(idValue);
        return itemCountTotal;
    }
}
