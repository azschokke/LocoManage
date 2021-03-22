package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CSVImport 
{
	public static void main(String[] args) throws IOException
	{
		File csv = new File("./LocomotivesTest.csv");
		File sql = new File("./seedLocomotives.sql");
		FileReader csvReader = null;
		FileWriter sqlWriter = null;
		BufferedReader bufferStream = null;
		PrintWriter printStream = null; 
		
		try
		{
			csvReader = new FileReader(csv);
			sqlWriter = new FileWriter(sql);
			bufferStream = new BufferedReader(csvReader);
			printStream = new PrintWriter(sqlWriter);
			String line; 
			
			printStream.write("INSERT INTO train_cars (`trainCarLength`, `railroad`, `class`, `notes`, `manufacturer`, `sku`, `trainCarStatus`, `category`, `trainCarNumber`) values ");
			bufferStream.readLine(); 
			while((line = bufferStream.readLine()) != null)
			{
				System.out.println(line);
				String[] data = line.split(",");
//				System.out.println(Arrays.toString(data));
				printStream.println(String.format("(%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'),", (data[1].length() == 0) ? "NULL" : data[1], data[2], data[4],  data[5],  data[6],  data[7],  data[8],  data[9], data[3]));
			}//end while
		}//end try
		finally
		{
			if(csvReader != null)
			{
				csvReader.close();
			}//end if
			if(sqlWriter != null)
			{
				sqlWriter.close(); 
			}//end if
			if(bufferStream != null)
			{
				bufferStream.close();
			}//end if
			if(printStream != null)
			{
				printStream.close(); 
			}//end if
		}//end finally
	}//end main
}//end class CSVImport
