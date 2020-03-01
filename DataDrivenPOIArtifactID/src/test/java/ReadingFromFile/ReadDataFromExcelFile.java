package ReadingFromFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelFile {
	public String[][] readEcel(String filePath, String sheetName) throws IOException {
		// Create an object of FileInpute stream
		FileInputStream inputStream = new FileInputStream(filePath);
		// reading from excel file
		// use AppachePOI
		Workbook workBook = new XSSFWorkbook(inputStream);

		Sheet workSheet = workBook.getSheet(sheetName);
		int rowCount = workSheet.getLastRowNum() - workSheet.getFirstRowNum();
		String[][] dataFromExcel = new String[rowCount][2];
		for (int i = 1; i < rowCount; i++) {
			Row row = workSheet.getRow(i);
			dataFromExcel[i][0] = row.getCell(0).getStringCellValue();
			dataFromExcel[i][1] = row.getCell(1).getStringCellValue();

		}
		return dataFromExcel;

	}

	public static void main(String[] args) throws IOException {
		ReadDataFromExcelFile readExcelObject = new ReadDataFromExcelFile();
		// String filePath =
		// "C:\\Users\\eshet\\eclipse-workspace\\DataDrivenPOIArtifactID\\src\\test\\java\\TestData\\Data.xlsx";
		String filePath = "C:\\Users\\eshet\\git\\DataDriven\\DataDrivenPOIArtifactID\\src\\test\\java\\TestData\\Data.xlsx";
		String[][] data = readExcelObject.readEcel(filePath, "Sheet1");
		for (int j = 0; j < data.length; j++) {
			System.out.println(data[j][0] + "....." + data[j][1]);
			// opne the broeser
			// open newtorus login paage
			// type user name and password
			// press loing and assert

		}
	}

}
