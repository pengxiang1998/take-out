package PoiExcel;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class POITest {
    public static void write() throws IOException {
        //在内存中创建一个Excel文件
        XSSFWorkbook excel = new XSSFWorkbook();
        //创建sheet
        XSSFSheet sheet = excel.createSheet("info");
        //是从0开始计数的
        XSSFRow row = sheet.createRow(1);
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("年龄");

        row = sheet.createRow(2);
        row.createCell(1).setCellValue("鹏翔");
        row.createCell(2).setCellValue("18");
        //利用文件输出流将内存中的Excel写入磁盘
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:/results.xlsx"));
        excel.write(fileOutputStream);
        //关闭资源
        fileOutputStream.close();
        excel.close();


    }

    public static void read() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("D:/results.xlsx"));
        //通过输入流传入读取的excel文件
        XSSFWorkbook excel= new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = excel.getSheet("info");

        int lastRowNum = sheet.getLastRowNum();
        for (int  i= 1;  i<= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            String cellValue1 = row.getCell(2).getStringCellValue();
            String cellValue2 = row.getCell(1).getStringCellValue();
            System.out.println(cellValue2 + cellValue1);

        }
        fileInputStream.close();
        excel.close();


    }
    public static void main(String[] args) throws IOException {

        read();
    }
}
