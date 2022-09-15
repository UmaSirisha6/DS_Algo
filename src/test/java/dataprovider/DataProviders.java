package dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import utility.NewExcelLibrary;

public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Credentials");
			// Total Columns
			int column = obj.getColumnCount("Credentials");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Credentials", j, i + 2);
				}
			}
			return data;
		}

		@DataProvider(name = "SignIn")
		public Object[][] getSignIn() {
			// Totals rows count
			int rows = obj.getRowCount("SignIn");
			// Total Columns
			int column = obj.getColumnCount("SignIn");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("SignIn", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "PyCode")
		public Object[][] getPyCode() {
			// Totals rows count
			int rows = obj.getRowCount("PyCode");
			// Total Columns
			int column = obj.getColumnCount("PyCode");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("PyCode", j, i + 2);
				}
			}
			return data;
		}
	
		@DataProvider(name = "withoutPassword2")
		public Object[][] getwithoutPassword2() {
			// Totals rows count
			int rows = obj.getRowCount("withoutPWD2");
			// Total Columns
			int column = obj.getColumnCount("withoutPWD2");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("withoutPWD2", j, i + 2);
				}
			}
			return data;
		}


		@DataProvider(name = "passwordsInNumberFormat")
		public Object[][] getPasswordAsNumbers() {
			// Totals rows count
			int rows = obj.getRowCount("PasswordAsNumbers");
			// Total Columns
			int column = obj.getColumnCount("PasswordAsNumbers");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("PasswordAsNumbers", j, i + 2);
				}
			}
			return data;
		}

		@DataProvider(name = "userNAmeNACharacters")
		public Object[][] getuserNameNA() {
			// Totals rows count
			int rows = obj.getRowCount("userNameNAChar");
			// Total Columns
			int column = obj.getColumnCount("userNameNAChar");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("userNameNAChar", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "passwordsMisMatch")
		public Object[][] getpassmismatch() {
			// Totals rows count
			int rows = obj.getRowCount("pwdMisMatch");
			// Total Columns
			int column = obj.getColumnCount("pwdMisMatch");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("pwdMisMatch", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "ValidUNamePWDForAccCreation")
		public Object[][] getvalidregistration() {
			// Totals rows count
			int rows = obj.getRowCount("ValidUNamePWDForAccCreation");
			// Total Columns
			int column = obj.getColumnCount("ValidUNamePWDForAccCreation");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("ValidUNamePWDForAccCreation", j, i + 2);
				}
			}
			return data;
		}
		
		//passwordsLT8characters
		@DataProvider(name = "passwordsLT8characters")
		public Object[][] getpassLthan2chars() {
			// Totals rows count
			int rows = obj.getRowCount("pwdLT8Char");
			// Total Columns
			int column = obj.getColumnCount("pwdLT8Char");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("pwdLT8Char", j, i + 2);
				}
			}
			return data;
		}
		
		
		@DataProvider(name = "newAcountDetailsData")
		public Object[][] accountCreation() {

			// Totals rows count
			int rows = obj.getRowCount("AccountCreationData");
			// Total Columns
			int column = obj.getColumnCount("AccountCreationData");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<>();
				for (int j = 0; j < column; j++) {
					hashMap.put(obj.getCellData("AccountCreationData", j, 1),
							obj.getCellData("AccountCreationData", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}
}
