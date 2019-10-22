package com.sharepoint.qa.util;

import java.util.Hashtable;

public class dataprovider_new {
	
	public static Object[][] getData(XLS_POI testExcelSheet, String testDataTab) {
	
		Object[][] data = null;

		int totalRowCount = testExcelSheet.getRowCount(testDataTab);
		int totalcolCount = testExcelSheet.getColumnCount(testDataTab, 1);

		data = new Object[totalRowCount - 1][1];

//		System.out.println("totalRowCount = " + totalRowCount);
//		System.out.println("totalcolCount = " + totalcolCount);

		Hashtable<String, String> hash_datatable = null;
		int dataRow = 0;

		for (int i = 2; i <= totalRowCount; i++) {
			hash_datatable = new Hashtable<String, String>();
			for (int j = 1; j <= totalcolCount; j++) {
				String key = testExcelSheet.getCellData(testDataTab, 1, j);
				String value = testExcelSheet.getCellData(testDataTab, i, j);

				hash_datatable.put(key, value);

			}
			data[dataRow][0] = hash_datatable;
			dataRow++;
		}
		
/*		for (int i = 0; i < data.length; i++) {
			Hashtable<String, String> tempHashTableData = (Hashtable<String, String>) data[i][0];
			System.out.println(tempHashTableData.get("InputUsername") + tempHashTableData.get("InputPassword") + tempHashTableData.get("ExpectedErrorMessage"));
		}*/
		
		return data;

	}
	
}
