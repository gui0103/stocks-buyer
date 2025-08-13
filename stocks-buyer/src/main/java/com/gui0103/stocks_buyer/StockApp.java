package com.gui0103.stocks_buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class StockApp implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(StockApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("✅ URL usada: " + dataSource.getConnection().getMetaData().getURL());
	}
}
