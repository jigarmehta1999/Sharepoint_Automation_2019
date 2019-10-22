package com.sharepoint.qa.util;

import java.util.Hashtable;

public class dataProvider_easy {
	public static void main(String[] args) {
		Object[][] data = null;
		System.out.println("Beginnning of dataProvider_easy...");
		String testDataSheetPath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\sharepoint\\qa\\testdata\\SharepointTestData.xlsx";
		XLS_POI xlsx = new XLS_POI(testDataSheetPath);
		int totalRowCount = xlsx.getRowCount("LoginTestUnSuccessFull");
		int totalcolCount = xlsx.getColumnCount("LoginTestUnSuccessFull", 1);

		data = new Object[totalRowCount - 1][1];

		System.out.println("totalRowCount = " + totalRowCount);
		System.out.println("totalcolCount = " + totalcolCount);

		Hashtable<String, String> hash_datatable = null;
		int dataRow = 0;

		for (int i = 2; i <= totalRowCount; i++) {
			hash_datatable = new Hashtable<String, String>();
			for (int j = 1; j <= totalcolCount; j++) {
//				System.out.print(xlsx.getCellData("LoginTestUnSuccessFull", i, j));
				String key = xlsx.getCellData("LoginTestUnSuccessFull", 1, j);
				String value = xlsx.getCellData("LoginTestUnSuccessFull", i, j);

				hash_datatable.put(key, value);

			}
			data[dataRow][0] = hash_datatable;
			dataRow++;
//			System.out.println();
		}
	
		
		for (int i = 0; i < data.length; i++) {
			Hashtable<String, String> tempHashTableData = (Hashtable<String, String>) data[i][0];
//			System.out.println(tempHashTableData.get("InputUsername") + tempHashTableData.get("InputPassword") + tempHashTableData.get("ExpectedErrorMessage"));
		}
		
		System.out.println("End of dataProvider_easy...");
	}

}
