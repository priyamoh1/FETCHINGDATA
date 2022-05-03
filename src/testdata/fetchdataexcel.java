package testdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class fetchdataexcel 
{
	@Test
	public void fetchdatafexcel() throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/demodata.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		System.out.println(wb);
		Sheet s=wb.getSheet("pintu");
		Sheet y=wb.getSheet("mohanty");
		Row r1=y.getRow(0);
		Cell c1=r1.getCell(0);
		System.out.println(c1);
		//System.out.println(c1.toString());
		System.out.println(c1.getStringCellValue());
		Row r=s.getRow(7);
		Cell c=r.getCell(5);
		System.out.println(c);
		System.out.println(c.getStringCellValue());
		
		System.out.println(wb.getSheet("pintu").getRow(7).getCell(5).getStringCellValue());
		
	
	}


}
