package com.flipkart.automation.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	
	public static void main(String[] args) throws Exception {
		
		//java.io
		File xlFile = new File("C:\\automation\\Eclipse_WS\\PracticeSessions\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(xlFile);		
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
//		//for input or outpu
//		FileOutputStream fiso = new FileOutputStream(xlFile);
//		
//		fileOut = new FileOutputStream(filePath);
//		 wb.write(fileOut);
//		  fileOut.close();
		
	
		
		
////		
////		HSSFWorkbook << MS EXCEL 2003 .xls
////		
////		XSSFWorkbook <<2007 + , .xlsx
//
//		//java.io
//		File xlFile = new File("C:\\automation\\Eclipse_WS\\PracticeSessions\\TestData.xlsx");
//		
//		//for input or outpu
//		FileInputStream fis = new FileInputStream(xlFile);
//		
//		
//		//apache poi
//		XSSFWorkbook workBook = new XSSFWorkbook(fis);
//		
//		 //connect to appropriate sheet by name
//        XSSFSheet sheet = workBook.getSheet("Master");
//        
//        Row row = sheet.getRow(1);
//        
//        Cell cell = row.getCell(1);
//        
//        System.out.println(cell.getStringCellValue());
        
		
	}
	
	//simple excel reading
	public static String getDataFromExcel(String filePath, String sheetName, int rowIndex, int columnIndex){
		
		File xlFile = new File(filePath);
		FileInputStream fis = null;
		String cellValue = "";
		
		try{
			 fis = new FileInputStream(xlFile);
			 
			 // Create an excel workbook from the file system
		        XSSFWorkbook workBook = new XSSFWorkbook(fis);
		        
		        //connect to appropriate sheet by name
		        XSSFSheet sheet = workBook.getSheet(sheetName);
		        
		        //connect to appropriate row
//		        sheet.getLastRowNum();
		        
		        Row row = sheet.getRow(rowIndex-1);
		        
		        //connect to appropriate cell
		        Cell cell =  row.getCell(columnIndex-1);
			 
		        //read the value
		        cellValue=cell.getStringCellValue();
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}catch(Exception e){
				
			}
		}
		
		return cellValue;
		
	}
	
	public static HashMap<String,String> getDataFromExcel(String filePath, String sheetName){
		
		
		File xlFile = new File(filePath);
		FileInputStream fis = null;
		
		//List<String> headers = new ArrayList<String>();
		
		
		HashMap<String,String> tdrow = new HashMap<String,String>();
		
		try{
			 fis = new FileInputStream(xlFile);
			
			 // Create an excel workbook from the file system
	        XSSFWorkbook workBook = new XSSFWorkbook(fis);
	        
	        //connect to appropriate sheet sheet
	        XSSFSheet sheet = workBook.getSheet(sheetName);
	        
	        Row Header = sheet.getRow(1);
	        Row Values = sheet.getRow(2);
	        
	        //read the header first
	        Iterator<Cell> headers = Header.cellIterator();
	        Iterator<Cell> values = Header.cellIterator();
	        
	        while(headers.hasNext()){
	        	XSSFCell cell = (XSSFCell) headers.next();
	        	XSSFCell cell_val = (XSSFCell) values.next();
	        	
	        	tdrow.put(cell.getStringCellValue(), cell_val.getStringCellValue());
	        	
	        }
	        
	            
			 
			
		}
		catch(Exception e){
			
		}
		return tdrow;
	}
	
    public static HashMap<String, LinkedHashMap<Integer, List<String>>>  loadExcelLines(File fileName)
    {
        // Used the LinkedHashMap and LikedList to maintain the order
        HashMap<String, LinkedHashMap<Integer, List<String>>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List<String>>>();

        LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String>>();

        String sheetName = null;
        // Create an ArrayList to store the data read from excel sheet.
        // List sheetData = new ArrayList();
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fileName);
            // Create an excel workbook from the file system
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            // Get the first sheet on the workbook.
            for (int i = 0; i < workBook.getNumberOfSheets(); i++)
            {
                XSSFSheet sheet = workBook.getSheetAt(i);
                // XSSFSheet sheet = workBook.getSheetAt(0);
                sheetName = workBook.getSheetName(i);

                Iterator<Row> rows = sheet.rowIterator();
                while (rows.hasNext())
                {
                    XSSFRow row = (XSSFRow) rows.next();
                    Iterator<Cell> cells = row.cellIterator();

                    List<String> data = new LinkedList<String>();
                    while (cells.hasNext())
                    {
                        XSSFCell cell = (XSSFCell) cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        data.add(cell.getStringCellValue());
                    }
                    hashMap.put(row.getRowNum(), data);

                    // sheetData.add(data);
                }
                outerMap.put(sheetName, hashMap);
                hashMap = new LinkedHashMap<Integer, List<String>>();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return outerMap;

    }

    public static void addRowToXL(String filePath, String sheetName,String[] cols){
    	
    	
    	File xlFile = new File(filePath);
    	
    	
		FileInputStream fis = null;
		
		if (!xlFile.exists()){
			
			
			XSSFWorkbook wb =new XSSFWorkbook();
			
			    FileOutputStream fileOut = null;
				try {
					fileOut = new FileOutputStream(filePath);
					 wb.write(fileOut);
					  fileOut.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
		}
		else{
			//do nothing
		}
		
		
		try{
			    fis = new FileInputStream(xlFile);
			 
			 // Create an excel workbook from the file system
		        XSSFWorkbook workBook = new XSSFWorkbook(fis);
		        XSSFSheet sheet;
		        
		        if (workBook.getSheetIndex(sheetName)==-1){ // new file 
		        	 //connect to appropriate sheet by name
		        	sheet = workBook.createSheet(sheetName);
		        	Row header = sheet.createRow(0);
		        
		        	header.createCell(0).setCellValue("#");
		        	header.createCell(1).setCellValue("Status");
		        	header.createCell(2).setCellValue("Description");
		        	header.createCell(3).setCellValue("Expected");
		        	header.createCell(4).setCellValue("Actual");
		        			
		        }
		        else
		        {
		        	 //connect to appropriate sheet by name
			        sheet = workBook.getSheet(sheetName);
		        }
		        
		        //connect to appropriate row
		        Row row = sheet.createRow(sheet.getLastRowNum()+1);
		        
		        for(int j = 0;j< cols.length;j++){
		        	row.createCell(j).setCellValue(cols[j]);
		        }
		        FileOutputStream fileOut = new FileOutputStream(filePath);
				workBook.write(fileOut);
			    fileOut.close();
    	}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
    }
}
