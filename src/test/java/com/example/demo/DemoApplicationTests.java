package com.example.demo;

import com.example.demo.Service.DatabaseHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestDatabase {
	@Autowired
	private DatabaseHandler executer;

	@BeforeEach
	void createDatabase() {
		String query = "CREATE TABLE User"+
				"(Uid INTEGER, Name CHAR(50), Email CHAR(200)," +
				"PRIMARY KEY(Uid))";
		executer.ExecuteCreateQuery(query);

		query = "INSERT INTO User (Uid, Name, Email) VALUES" +
				"(1 ,'Alice',  'Alice@yahoo.com')," +
				"(2 , 'Bob', 'bob@gmail.com')," +
				"(3 , 'Charlie', 'charlie@gmail.com')";
		executer.ExecuteCreateQuery(query);

	}

	@AfterEach
	void closeConnection()
	{
		executer.closeSession();
	}

	@Test
	void testQuery()
	{
		executer.ExecuteSelectQuery("SELECT Uid FROM User U WHERE U.Name = 'Alice' or U.Name = 'Bob'");
		executer.printResultTable();
		closeConnection();
	}
}
