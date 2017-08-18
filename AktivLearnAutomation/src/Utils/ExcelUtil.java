package Utils;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFAutoFilter;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.AutoFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtil
{
	private static final String Interger = null;
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row   = null;
	public XSSFCell cell = null;
	
	Properties Pathproperties;
	
	public static final String filePath="src\\DataRepository\\path.properties";
	
	Workbook oWorkbook;
	Sheet oSheet;
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: CreateXLSLibrary
	 Purpose: To create an XLS library in order to perform operations
	 Parameters: Path of the excel sheet
	 Returned Value: NA
	---------------------------------------------------------------------------------------------------------------*/
	public void CreateXLSLibrary(String path) 
	{
			this.path=path;
			try 
			{
				fis = new FileInputStream(path);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
				fis.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
	
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: readDataFromOverall()
	 Purpose: Get the Data from the Overall excel
	 Parameters: TestScenario,Module Name,ColumnIndex,ColumnNAme
	 Returned Value: Returns the Value of the cell
	---------------------------------------------------------------------------------------------------------------*/
	public String readDataFromOverall(String TestScenario,String ModuleName,String ColumnName)
	{
		
		if(!isSheetExist("Overall"))
			 return "Sheet Doesnt exist";
			
			sheet = workbook.getSheet("Overall");
			int ColIndex=getColumnNumber("Overall", ColumnName);
			//row = sheet.getRow(0);
			for(int i=0;i<=sheet.getLastRowNum();i++)
			{
				 row=sheet.getRow(i);
				 if((row.getCell(0).getRichStringCellValue().getString().equals(TestScenario))&&(row.getCell(6).getRichStringCellValue().getString().equals(ModuleName)))
                                  {
                                         return row.getCell(ColIndex).toString();
                                  }
              }
			      
			  
		return"returning nothing";
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: getRowCount()
	 Purpose: To return the row count in a sheet
	 Parameters: Sheet Name
	 Returned Value: Returns number of rows in a worksheet
	---------------------------------------------------------------------------------------------------------------*/
	public int getRowCount(String sheetName)
	{
		int index = workbook.getSheetIndex(sheetName);
		System.out.println("Index of sheet"+index);
		if(index==-1)
			return 0;
		else{
		sheet = workbook.getSheetAt(index);
		int number=sheet.getLastRowNum()+1;
		return number;
		}
		
	}
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: getColumnCount()
	 Purpose: Returns column count
	 Parameters: Sheet Name
	 Returned Value: Returns the Column count 
	---------------------------------------------------------------------------------------------------------------*/
	public int getColumnCount(String sheetName)
	{
		// check if sheet exists
		if(!isSheetExist(sheetName))
		 return -1;
		
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		
		if(row==null)
			return -1;
		
		return row.getLastCellNum();
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: getRowCountForTestScenario()
	 Purpose: To return the row count in a sheet
	 Parameters: Sheet Name
	 Returned Value: Returns number of rows in a worksheet
	---------------------------------------------------------------------------------------------------------------*/
	public int getRowCountForTestScenario(String sheetName,String TextValue)
	{
		int number=0;
		int index = workbook.getSheetIndex(sheetName);
		
		if(index==-1)
			return 0;
		else{
		sheet = workbook.getSheetAt(index);
		 for (Row row : sheet)
		  { 

		      Cell cell = row.getCell(0); 
		      
		      if(cell.getRichStringCellValue().toString().equals(TextValue))
		      {
		    	  
		    	  number++;
		      }
		      
		  }
		return number;
		}
		
	}
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: ReadDatafromExcel()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	public String ReadDatafromExcel(String SheetName,int ColumnNumber,int RowNumber)
	{
		String value;
		 DataFormatter formatter = new DataFormatter();
		sheet = workbook.getSheet(SheetName);  
	    row = sheet.getRow(RowNumber);
	    Cell cell=row.getCell(ColumnNumber);
       //value=row.getCell(ColumnNumber).getStringCellValue().toString();
       value = formatter.formatCellValue(cell);
 		return value;
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: readCourseData()
	 Purpose: To return the data present in the entire course 
	 Parameters: Sheet Name, Column Number, Row Number
	 Returned Value: Returns 2d array of course data
	---------------------------------------------------------------------------------------------------------------*/
	
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: getCellData()
	 Purpose: To return the data present in a cell
	 Parameters: Sheet Name, Column Number, Row Number
	 Returned Value: Returns the text present in the cell
	---------------------------------------------------------------------------------------------------------------*/
	
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			if(rowNum <=0)
				return "";
		
		int index = workbook.getSheetIndex(sheetName);

		if(index==-1)
			return "";
		
	
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(colNum);
		if(cell==null)
			return "";
		
	  if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		  return cell.getStringCellValue();
	  else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
		  
		  String cellText  = String.valueOf(cell.getNumericCellValue());
		  if (HSSFDateUtil.isCellDateFormatted(cell)) {
	           // format in form of M/D/YY
			  double d = cell.getNumericCellValue();

			  Calendar cal =Calendar.getInstance();
			  cal.setTime(HSSFDateUtil.getJavaDate(d));
	            cellText =
	             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
	           cellText = cal.get(Calendar.MONTH)+1 + "/" +
	                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
	                      cellText;
	           
	          // System.out.println(cellText);

	         }

		  
		  
		  return cellText;
	  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
	      return "";
	  else 
		  return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}	
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: setCellData()
	 Purpose: To set the data present into a cell
	 Parameters: Sheet Name, Column Number, Row Number, Data to be set
	 Returned Value: Returns true if data has been set else false
	---------------------------------------------------------------------------------------------------------------*/
	public boolean setCellData(String sheetName,String colName,int rowNum, String data){
		try{
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);

		if(rowNum<=0)
			return false;
		
		int index = workbook.getSheetIndex(sheetName);
		int colNum=-1;
		if(index==-1)
			return false;
		
		
		sheet = workbook.getSheetAt(index);
		

		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName))
				colNum=i;
		}
		if(colNum==-1)
			return false;

		sheet.autoSizeColumn(colNum); 
		row = sheet.getRow(rowNum-1);
		if (row == null)
			row = sheet.createRow(rowNum-1);
		
		cell = row.getCell(colNum);	
		if (cell == null)
	        cell = row.createCell(colNum); 

	    // cell style
	    //CellStyle cs = workbook.createCellStyle();
	    //cs.setWrapText(true);
	    //cell.setCellStyle(cs);
	    cell.setCellValue(data);

	    fileOut = new FileOutputStream(path);

		workbook.write(fileOut);

	    fileOut.close();	

		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int getRowNum(String SheetName,int ColumnNo,String ColumnData)
	{
		int index = workbook.getSheetIndex(SheetName);
		 Sheet sheet  = workbook.getSheetAt(index); 

		  for (Row row : sheet)
		  { 

		      Cell cell = row.getCell(ColumnNo); 
		      
		      if(cell.getRichStringCellValue().toString().equals(ColumnData))
		      {
		    	  
		    	  return cell.getRowIndex()+1;
		      }
		      
		  }
		  return 0;
	}
	
	

	
	public Integer getColNumber(Sheet trgSheet,String strColName)
	{
		Row headerRow=trgSheet.getRow(0);
		for(int j = 0; j < headerRow.getLastCellNum(); j++)
		{
			Cell cell = headerRow.createCell(j);
			if (cell.getStringCellValue().equalsIgnoreCase(strColName))
			{
				return j;
			}
		}
		System.out.println("Column with column name '"+strColName+"' not found");
		return null;
	}
	

	
	public String getItemValue(String SheetName,int ColumnIndexOfID, int ColumnIndexOfValue,String ID)
	{
		String ItemValueName="";
		int ItemRowNum=getRowNum(SheetName,ColumnIndexOfID, ID);
		//System.out.println("ItemRowNUm ="+ItemRowNum);
		ItemValueName=getCellData(SheetName, ColumnIndexOfValue, ItemRowNum);
		//System.out.println("ItemValueName= "+ ItemValueName);
		return ItemValueName;
	}
	
	//LatestOne
	
	public String getItemValueOtherSheet(String SheetName,int ColumnIndexOfID, String ColumnName,String ID)
	{
		String ItemValueName="";
		int ColumnIndexOfValue;
		ColumnIndexOfValue=getColumnNumber(SheetName, ColumnName);
		int ItemRowNum=getRowNum(SheetName,ColumnIndexOfID, ID);
		//System.out.println("ItemRowNUm ="+ItemRowNum);
		ItemValueName=getCellData(SheetName, ColumnIndexOfValue, ItemRowNum);
		//System.out.println("ItemValueName= "+ ItemValueName);
		return ItemValueName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: getPath
	 Purpose: Used to fetch path from path.properties file
	 Parameters: Path name
	 Returned Value: String value of path
	---------------------------------------------------------------------------------------------------------------*/
	public String getPath(String strPathName) {		
		Pathproperties = new Properties();
	      try {
	      FileInputStream Master = new FileInputStream(filePath);
	      Pathproperties.load(Master);
	      Master.close();
	          }catch (IOException e) {
	           System.out.println(e.getMessage());
	         }
	      return Pathproperties.getProperty(strPathName);
	}
	
	//New

	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: addSheet()
	 Purpose: Add a sheet to an existing workbook
	 Parameters: Sheet Name
	 Returned Value: Returns true if sheet has been added else false
	---------------------------------------------------------------------------------------------------------------*/
	
	public boolean addSheet(String  sheetname)
	{		
		FileOutputStream fileOut;
		try 
		{
			 workbook.createSheet(sheetname);	
			 fileOut = new FileOutputStream(path);
			 workbook.write(fileOut);
		     fileOut.close();		    
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: removeSheet()
	 Purpose: Remove a sheet from an existing workbook
	 Parameters: Sheet Name
	 Returned Value: Returns true if sheet has been removed else false
	---------------------------------------------------------------------------------------------------------------*/
	public boolean removeSheet(String sheetName){		
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return false;
		
		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: addColumn()
	 Purpose: Add a column to a sheet
	 Parameters: Sheet Name, Column to be added
	 Returned Value: Returns True if column is added else false
	---------------------------------------------------------------------------------------------------------------*/
	public boolean addColumn(String sheetName,String colName){
		//System.out.println("**************addColumn*********************");
		
		try{				
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;
			
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		sheet=workbook.getSheetAt(index);
		
		row = sheet.getRow(0);
		if (row == null)
			row = sheet.createRow(0);
		
		//cell = row.getCell();	
		//if (cell == null)
		//System.out.println(row.getLastCellNum());
		if(row.getLastCellNum() == -1)
			cell = row.createCell(0);
		else
			cell = row.createCell(row.getLastCellNum());
	        
	        cell.setCellValue(colName);
	        cell.setCellStyle(style);
	        
	        fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();		    

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
			
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: removeColumn()
	 Purpose: Remove a column to a sheet
	 Parameters: Sheet Name, Column to be removed
	 Returned Value: Returns True if column is added else false
	---------------------------------------------------------------------------------------------------------------*/
	public boolean removeColumn(String sheetName, int colNum) {
		try{
		if(!isSheetExist(sheetName))
			return false;
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		XSSFCreationHelper createHelper = workbook.getCreationHelper();
		style.setFillPattern(HSSFCellStyle.NO_FILL);
		
		for(int i =0;i<getRowCount(sheetName);i++){
			row=sheet.getRow(i);	
			if(row!=null){
				cell=row.getCell(colNum);
				if(cell!=null){
					cell.setCellStyle(style);
					row.removeCell(cell);
				}
			}
		}
		fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
	    fileOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: isSheetExist()
	 Purpose: Verify whether a sheet exists
	 Parameters: Sheet Name
	 Returned Value: Returns True if sheet exists else false
	---------------------------------------------------------------------------------------------------------------*/
	public boolean isSheetExist(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1){
			index=workbook.getSheetIndex(sheetName.toUpperCase());
				if(index==-1)
					return false;
				else
					return true;
		}
		else
			return true;
	}
	

	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: getColumnNumber()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	---------------------------------------------------------------------------------------------------------------*/
	public int getColumnNumber(String sheetName, String Columnname)
	{
		// check if sheet exists
		if(!isSheetExist(sheetName))
		 return -1;
		
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		
		if(row==null)
			return -1;
		int i;
		for(i=0;i < row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().toString().equals(Columnname))
				break;
		}
		if (i==row.getLastCellNum())
			return -1;
		else
		return i;		
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: addHyperLink()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	/*public boolean addHyperLink(String sheetName,String screenShotColName,String testCaseName,int index,String url,String message)
	{
		//System.out.println("ADDING addHyperLink******************");
		
		url=url.replace('\\', '/');
		if(!isSheetExist(sheetName))
			 return false;
		
	    sheet = workbook.getSheet(sheetName);
	    
	    for(int i=2;i<=getRowCount(sheetName);i++){
	    	if(getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName))
	    	{
	    		//System.out.println("**caught "+(i+index));
	    		setCellData(sheetName, screenShotColName, i+index, message,url);
	    		break;
	    	}
	    }


		return true; 
	}*/
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: getCellRowNum()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	public int getCellRowNum(String sheetName,int colmnNum,String cellValue){
		
		sheet = workbook.getSheet(sheetName);
		int i;
		DataFormatter formatter = new DataFormatter(Locale.US);

		
		row = sheet.getRow(0);
		for (i=0;i < sheet.getLastRowNum();i++)
		{
				Cell cell=row.getCell(colmnNum);
				CellReference ref = new CellReference(cell);
			  if(formatter.formatCellValue(cell).equals(cellValue))
				  break;
		
		row = sheet.getRow(i);
		}
		if ( i==row.getLastCellNum())
			return -1;
		else
			return i;		
					
	}
	

	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: SetFilter()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	public String SetFilter(String SheetName)
	{
		sheet = workbook.getSheet("RPE");
		
		//Creating AutoFilter by giving the cells range
		/*
		CellRangeAddress car=new CellRangeAddress(1,3000,1,26);
		XSSFAutoFilter autoFilter = sheet.setAutoFilter(car);*/
		sheet.setAutoFilter(CellRangeAddress.valueOf("A1:Z3000"));
		return null;
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: ApplyFilter()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	public File ApplyFilter(String SheetName)
	{
		sheet = workbook.getSheet("RPE");
		
		//Creating AutoFilter by giving the cells range
		/*
		CellRangeAddress car=new CellRangeAddress(1,3000,1,26);
		XSSFAutoFilter autoFilter = sheet.setAutoFilter(car);*/
		sheet.setAutoFilter(CellRangeAddress.valueOf("A1:Z3000"));
		return null;
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: GetRowdata()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	public List<String> GetRowdata(String SheetName,List<String> Rowlist, int ColumnNumber,String value)
	{
		List<String> strlist = new ArrayList<String>();
		
		//System.out.println(" StateCode "+ SheetName + " PRIC_ZN " +Rowlist.size()+" FuelType " +ColumnNumber + " PlanType "+ value);
						
		sheet = workbook.getSheet(SheetName);
		int i=0;
		if (Rowlist!= null)
		{
			for(i=0; i < Rowlist.size();i++ )
			{
			 	row = sheet.getRow(Integer.parseInt(Rowlist.get(i).toString()));
				if( row.getCell(ColumnNumber).getStringCellValue().toString().contains(value))
					strlist.add(Rowlist.get(i).toString());	
			}
			return strlist;
			
		}
		else
		{
			for(i=0; i < sheet.getLastRowNum();i++ )
			{
				row = sheet.getRow(i);
				if( row.getCell(ColumnNumber).getStringCellValue().toString().contains(value))
					strlist.add(String.valueOf(i));	
			}
			
			return strlist;
			
		}
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: CreateConnection()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	public PreparedStatement CreateConnection(String FilePath,String Query)
	{
		
		try {
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        Connection conn = DriverManager.getConnection(
	                "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};" + 
                "Dbq="+FilePath);
	        PreparedStatement s = conn.prepareStatement(Query);
	        return s;
	    } catch( Exception e ) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: ExecuteQuery()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	
	public ResultSet ExecuteQuery(PreparedStatement PS)
	{
		
		try {
	        
	        PS.execute();
	        ResultSet rs = PS.getResultSet();
	      return rs;
	    } catch( Exception e ) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: ExecuteQuery()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	public ResultSet ExecuteQuery(PreparedStatement PS,String Attribute,String Value)
	{
		
		try {
	        
			ResultSet r=null;
			
			return r;
	    } catch( Exception e ) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: WriteDataToExcel()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	public void WriteDataToExcel(String SheetName,int RowNumber,int ColumnNumber,String Value)
	{	 
		Date dNow = new Date( );
		SimpleDateFormat ft =new SimpleDateFormat ("MMddYYYY");
		
		  try
		  {
			  FileInputStream fstream = new FileInputStream(System.getProperty("user.dir")+"//TestResult_"+ft.format(dNow)+".xls");
			  org.apache.poi.ss.usermodel.Workbook wb = (org.apache.poi.ss.usermodel.Workbook)WorkbookFactory.create(fstream); 
			  Sheet sheet =(Sheet)wb.getSheetAt(0); 
			  Row row = (Row)((org.apache.poi.ss.usermodel.Sheet)sheet).getRow(RowNumber); 
			  Cell cell=row.createCell(ColumnNumber);
			  cell.setCellValue(Value);
			  FileOutputStream fileout=new FileOutputStream(System.getProperty("user.dir")+"//PG HealthCheck List_"+ft.format(dNow)+".xls");
			  wb.write(fileout);
			  fileout.close();
		  }
		  catch (Exception e){//Catch exception if any
			  assertTrue(false);
		  }		
	}
	
	/*--------------------------------------------------------------------------------------------------------------
	 Test Method Name: CreateTestResultFile()
	 Purpose: Get the column Number
	 Parameters: Sheet Name and Column Name
	 Returned Value: Returns the Column Number
	 ---------------------------------------------------------------------------------------------------------------*/
	
	public void CreateTestResultFile()
	{ 
		Date dNow = new Date( );
		SimpleDateFormat ft =new SimpleDateFormat ("MMddYYYY");
		
		try 
		{
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"//PG HealthCheck List_"+ft.format(dNow)+".xls");
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet worksheet = workbook.createSheet("PG Functionality - Country");
	        HSSFRow row1 = worksheet.createRow(0);
	        row1.createCell(0).setCellValue("Availability of Data");
	        HSSFRow row = worksheet.createRow(1);
	        row.createCell(0).setCellValue("Testcase");
	        row.createCell(1).setCellValue("TestRunStatus");
	        row.createCell(2).setCellValue("Remarks");
	           workbook.write(fos);
	        fos.close();
	       	        
	    } 
		catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
			
		
	}
}