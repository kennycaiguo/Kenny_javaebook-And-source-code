package kenny.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.junit.Test;
import org.apache.poi.ss.usermodel.Sheet;

public class PoiDemo {
	@Test
	public  void writeXlsx() throws Exception {
		
		Workbook wb=new HSSFWorkbook();
		Sheet sheet=wb.createSheet("员工列表");
		
		wb.setActiveSheet(0);
		for(int i=0;i<10;i++) {
			Row row;
			row= wb.getSheetAt(0).createRow(i);
			for (int j=0;j<5;j++) {
			    Cell cell;
			    cell=row.createCell(j);
			    cell.setCellValue("Person"+i+"#"+j);
			}
		}
		 FileOutputStream out=new FileOutputStream(new File("e:/test4.xlsx"));
		 wb.write(out);
		 out.close();
		 wb.close();
	}
	@Test
	public void readElsx() throws FileNotFoundException, IOException {
		Workbook wb=new HSSFWorkbook(new FileInputStream(new File("e:/test4.xlsx")));
		Iterator<Sheet> sheets = wb.sheetIterator();
		while(sheets.hasNext()) {
			      Sheet sheet = sheets.next();
			      Iterator<Row> rows = sheet.rowIterator();
			      while(rows.hasNext()) {
			    	 Row r=rows.next();
			    	    Iterator<Cell> cells= r.cellIterator();
			    	    while(cells.hasNext()) {
			    	    	Cell c=cells.next();
			    	    	System.out.print(c.getStringCellValue()+"\t");
			    	    }
			    	    System.out.println("\r\n");
			      }
			    
		}
		 
	}
	
	 
}
