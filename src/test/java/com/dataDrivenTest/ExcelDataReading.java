package com.dataDrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataReading {
	XSSFWorkbook wb;
	
	@DataProvider(name="dataRead")
	public Object [][] excelData (){
		
		 File f1=new File(System.getProperty("user.dir")+"//testData//testData.xlsx");
		  FileInputStream fs;
		  Object arr [][]=null;
		  
		  
		 try {
			fs =new FileInputStream(f1);
			
			  wb=new XSSFWorkbook(fs);
			  
			  int rows=wb.getSheet("loginData").getPhysicalNumberOfRows();
			  System.out.println("Number of rows: "+rows);
			  
			 
			  int cells=wb.getSheet("loginData").getRow(0).getPhysicalNumberOfCells();
			  System.out.println("Number of columns: "+cells);
			  
			
			  arr =new Object[rows-1][cells];
			  
			  for(int i=1;i<rows;i++)
			  {
				  for(int j=0;j<cells;j++)
				  {
					  arr[i-1][j]=wb.getSheet("loginData").getRow(i).getCell(j).getStringCellValue();
					  System.out.println(arr[i-1][j]);
				  }
				
			  }
			  
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return arr;	
		
	}
	

}
