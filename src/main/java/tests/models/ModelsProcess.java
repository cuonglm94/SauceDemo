package tests.models;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.opencsv.bean.CsvToBeanBuilder;

import common.Utils;

public class ModelsProcess {
	public Login convertLoginFromCsv(String fileName) {
		Login login= new Login();
		//Utils utils = new Utils();
		String loginDataPath = System.getProperty("user.dir") + "\\testdata\\"+ fileName;
		try {
			List<Login> logins = new CsvToBeanBuilder<Login>(new FileReader(loginDataPath)).withType(Login.class).build().parse();
			login =logins.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return login;
	}

}
