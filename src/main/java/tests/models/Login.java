package tests.models;

import com.opencsv.bean.CsvBindByName;

public class Login {
	
	@CsvBindByName(column = "Username", required = true)
	public String username;
	
	@CsvBindByName(column = "Password", required = true)
	public String password;
	

	
	

}
