package com.stockexchange.joedonedata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stockexchange.joedonedata.Exception.DataException;
import com.stockexchange.joedonedata.controller.service.DataService;

@SpringBootTest
class JoedonedataApplicationTests {

	@Autowired
	DataService dataService;

	// Case1: test case for search API
	// For Quarter 2, and Stock AA, checking count
	// From DB select count(*) from stockdata where quarter = 2 and stock = "AA";
	// count is 13

	@Test
	public void case1() {
		System.out.println("dataService" + dataService);
		assertEquals(13, dataService.searchData("2", "AA").size());

	}

	// Case2: test case for search API
	// For Quarter 5, and Stock AA,  Invalid data for Quarter

	@Test
	public void case2() {
		Exception exception = assertThrows(DataException.class, () -> {
			dataService.searchData("5", "AA");
		});

		String expectedMessage = "Invalid value for quarter [ valid values : 1, 2, 3, 4]";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
}
