/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.arduinoshop.controller;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.arduinoshop.model.BillDTO;
import lk.arduinoshop.model.CategoryDTO;
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.model.SalesDTO;
import repository.CategoryRepository;
import repository.ProductRepository;
import repository.ReportRepository;

/**
 *
 * @author Iyona Chithrasena
 */
public class ReportController {

    public static List<SalesDTO> getProdcutDTOList() {
        List<SalesDTO> salesDTOList = null;
        try {
            salesDTOList = ReportRepository.findAllProducts();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salesDTOList;
    }

    public static List<SalesDTO> getLowStockProductList() {
        List<SalesDTO> salesDTOList = null;
        try {
            salesDTOList = ReportRepository.findAllLowStockProducts();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salesDTOList;
    }

    public static List<SalesDTO> getOutOfStockProductList() {
        List<SalesDTO> salesDTOList = null;
        try {
            salesDTOList = ReportRepository.findAllOutOfStockProducts();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salesDTOList;
    }

    public static List<SalesDTO> getMostStockProductList() {
        List<SalesDTO> salesDTOList = null;
        try {
            salesDTOList = ReportRepository.findAllMostStockProducts();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salesDTOList;
    }

    //----Generate Report
    public static void generatePDF(ArrayList<SalesDTO> itemList, String header) throws FileNotFoundException, IOException {
        //------get System date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm");
        LocalDateTime now = LocalDateTime.now();
        
        String path = "C:\\ArduinoShopReport\\"+header+" Report"+dtf.format(now)+".pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        document.setMargins(50f, 50f, 50f, 50f);

        

        //------- create titles
        String para1 = "ArduinoShopLK";
        String para2 = "259/A, Koggala kade Junction, Wakwella Rd, Galle 80000, Sri Lanka \n Phone: +94 71 885 3466 \n Email: admin@arduinoshoplk.com \n " + dtf.format(now);
        String para3="_________________________________________________________________________________________\n\n";
                      
        Paragraph paragraph1 = new Paragraph(para1).setFontSize(14);
        paragraph1.setBold();
        Paragraph paragraph2 = new Paragraph(para2).setFontSize(12);
        
        Paragraph paragraph3 = new Paragraph(para3).setFontSize(10);
    
        Paragraph paragraph4 = new Paragraph(header+ " Report").setFontSize(14);
        paragraph4.setTextAlignment(TextAlignment.CENTER).setUnderline();
        

        // ---- Create table
        float columnWidth[] = {40f, 80f, 300f, 80f};
        Table table = new Table(columnWidth);

        Cell cell_H1 = new Cell().add("No").setFontSize(12);
        Cell cell_H2 = new Cell().add("Product ID").setFontSize(12);
        Cell cell_H3 = new Cell().add("Product Name").setFontSize(12);
        Cell cell_H4 = new Cell().add("Available Quantity").setFontSize(12);

        table.addHeaderCell(cell_H1);
        table.addHeaderCell(cell_H2);
        table.addHeaderCell(cell_H3);
        table.addHeaderCell(cell_H4);
        int no = 0;
        for (SalesDTO salesDTO : itemList) {
            no++;
            String productName = salesDTO.getProductName();

            table.addCell(new Cell().add(String.valueOf(no)).setFontSize(11));

            table.addCell(new Cell().add(String.valueOf(salesDTO.getProductId())).setFontSize(11));
            table.addCell(new Cell().add(productName).setFontSize(11));
            table.addCell(new Cell().add(String.valueOf(salesDTO.getCurrentQuantity())).setFontSize(11).setTextAlignment(TextAlignment.RIGHT));

        }

        document.add(paragraph1);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);

        document.add(table);
        

        document.close();

        File file = new File(path);
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }
    public static ArrayList<SalesDTO> getAllOrders() {
        List<SalesDTO> orderList = null;
        try {
            orderList = ReportRepository.findAllOrders();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<SalesDTO>) orderList;
    }
}
