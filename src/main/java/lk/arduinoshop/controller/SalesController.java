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
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.arduinoshop.model.BillDTO;
import lk.arduinoshop.model.ProductDTO;
import lk.arduinoshop.model.SalesDTO;
import repository.SalesRepository;

/**
 *
 * @author Iyona Chithrasena
 */
public class SalesController {

    public static String setItemId(ProductDTO productDTO) throws SQLException {

        String itemId = SalesRepository.findItemId(productDTO);
        String productId = null;
        if (itemId != null) {
            productId = itemId;
        }
        return productId;
    }

    public static String setItemName(ProductDTO productDTO) throws SQLException {

        String itemName = SalesRepository.findItemName(productDTO);
        String productName = null;
        if (itemName != null) {
            productName = itemName;
        }
        return productName;
    }

    public static SalesDTO getSalesDTOList(SalesDTO salesDTO) {
        SalesDTO salesDTOReturn = null;
        try {
            salesDTOReturn = SalesRepository.getProductDetail(salesDTO);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salesDTOReturn;
    }

    public static ArrayList<SalesDTO> searchProductName(SalesDTO salesDTO) {
        ArrayList<SalesDTO> salesDTOReturnList = null;
        try {
            salesDTOReturnList = SalesRepository.searchProductName(salesDTO);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salesDTOReturnList;
    }

    public static Integer findCount(SalesDTO salesDTO) throws SQLException {
        Integer count = 0;
        count = SalesRepository.numberOfStock(salesDTO);
        return count;
    }

    public static SalesDTO findQuantity(SalesDTO salesDTO) throws SQLException {
        SalesDTO salesDTOReturn = null;
        salesDTOReturn = SalesRepository.findQuantity(salesDTO);
        return salesDTOReturn;

    }

    public static void generatePDF(BillDTO billDTO) throws FileNotFoundException, IOException {

        ArrayList<SalesDTO> itemList = billDTO.getItemList();
        
        String path = "C:\\ArduinoShopReport\\Bill\\"+billDTO.getInvoiceNUmber()+".pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        float size = itemList.size() *20;
        PageSize pageSize = new PageSize(200f, 350 + size);
        //PdfPage padfPage=
        pdfDocument.addNewPage(pageSize);

        Document document = new Document(pdfDocument);
        document.setMargins(5f, 5f, 5f, 5f);

        //------get System date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //------- create titles
        String para1 = "259/A, Koggala kade Junction, Wakwella Rd, Galle 80000, Sri Lanka \n Phone: +94 71 885 3466 \n Email: admin@arduinoshoplk.com "
                + "\n -----------------------------------------------------------------------\n Recipt No: " + billDTO.getInvoiceNUmber() + "\n" + dtf.format(now)
                + "\n-----------------------------------------------------------------------";
        String para2 = "-----------------------------------------------------------------------\n Item Change can do within two days only \n Terms and conditions applied \n Thank you for Visiting ArduinoshopLK";
        String para3 = "ArduinoShopLK";
        String para4 = "-----------------------------------------------------------------------";

        Paragraph paragraph1 = new Paragraph(para1).setFontSize(8);
        Paragraph paragraph2 = new Paragraph(para2).setFontSize(8);
        Paragraph paragraph3 = new Paragraph(para3).setFontSize(8);
        Paragraph paragraph4 = new Paragraph(para4).setFontSize(8);
        paragraph3.setTextAlignment(TextAlignment.CENTER).setBold();

        // ---- Create table
        float columnWidth[] = {10f, 80f, 10f, 10f, 20f, 20f, 50f};
        Table table = new Table(columnWidth);

        Cell cell_H1 = new Cell().add("PID").setFontSize(8).setBorder(Border.NO_BORDER);
        Cell cell_H2 = new Cell().add("PName").setFontSize(8).setBorder(Border.NO_BORDER);
        Cell cell_H3 = new Cell().add("SID").setFontSize(8).setBorder(Border.NO_BORDER);
        Cell cell_H4 = new Cell().add("Qty").setFontSize(8).setBorder(Border.NO_BORDER);
        Cell cell_H5 = new Cell().add("UPrice").setFontSize(8).setBorder(Border.NO_BORDER);
        Cell cell_H6 = new Cell().add("Dis").setFontSize(8).setBorder(Border.NO_BORDER);
        Cell cell_H7 = new Cell().add("Total").setFontSize(8).setBorder(Border.NO_BORDER);

        table.addHeaderCell(cell_H1);
        table.addHeaderCell(cell_H2);
        table.addHeaderCell(cell_H3);
        table.addHeaderCell(cell_H4);
        table.addHeaderCell(cell_H5);
        table.addHeaderCell(cell_H6);
        table.addHeaderCell(cell_H7);
        
        

        for (SalesDTO salesDTO : itemList) {
            String productName=salesDTO.getProductName();
            productName=productName.length()>11?productName.substring(0, 10):productName;
            table.addCell(new Cell().add(String.valueOf(salesDTO.getProductId())).setBorder(Border.NO_BORDER).setFontSize(8));
            table.addCell(new Cell().add(productName).setBorder(Border.NO_BORDER).setFontSize(8));
            table.addCell(new Cell().add(String.valueOf(salesDTO.getStockId())).setBorder(Border.NO_BORDER).setFontSize(8));
            table.addCell(new Cell().add(String.valueOf(salesDTO.getQuantity())).setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.RIGHT));
            table.addCell(new Cell().add(String.valueOf(salesDTO.getSellPrice())).setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.RIGHT));
            table.addCell(new Cell().add(String.valueOf(salesDTO.getDiscount())).setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.RIGHT));
            double total = (salesDTO.getQuantity() * salesDTO.getSellPrice()) - salesDTO.getDiscount();
            table.addCell(new Cell().add(String.valueOf(total)).setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.RIGHT));

        }

        float columnWidth1[] = {50, 50, 80, 20};
        Table totalTable = new Table(columnWidth1);
        addBlankCell(2, totalTable);
        totalTable.addCell(new Cell().add("Total").setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.LEFT));
        totalTable.addCell(new Cell().add(String.valueOf(billDTO.getTotal())).setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.RIGHT));

        addBlankCell(2, totalTable);
        totalTable.addCell(new Cell().add("Total Discount").setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.LEFT));
        totalTable.addCell(new Cell().add(String.valueOf(billDTO.getTotalDiscount())).setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.RIGHT));

        addBlankCell(2, totalTable);
        totalTable.addCell(new Cell().add("Grand Total").setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.LEFT));
        totalTable.addCell(new Cell().add(String.valueOf(billDTO.getGrandTotal())).setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.RIGHT));

        addBlankCell(2, totalTable);
        totalTable.addCell(new Cell().add("Cash Tendered").setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.LEFT));
        totalTable.addCell(new Cell().add(String.valueOf(billDTO.getChasTendered())).setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.RIGHT));

        addBlankCell(2, totalTable);
        totalTable.addCell(new Cell().add("Amount Due").setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.LEFT));
        totalTable.addCell(new Cell().add(String.valueOf(billDTO.getAmountDue())).setBorder(Border.NO_BORDER).setFontSize(8).setTextAlignment(TextAlignment.RIGHT));

        document.add(paragraph3);
        document.add(paragraph1);

        document.add(table);
        document.add(paragraph4);
        document.add(totalTable);

        document.add(paragraph2);

        document.close();

        File file = new File(path);
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }

    private static void addBlankCell(int cellCount, Table table) {
        for (int i = 0; i < cellCount; i++) {
            table.addCell(new Cell().setBorder(Border.NO_BORDER));

        }

    }
}
