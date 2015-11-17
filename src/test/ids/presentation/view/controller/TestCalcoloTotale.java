package test.ids.presentation.view.controller;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.ids.presentation.view.controller.CalcoloTotale;

public class TestCalcoloTotale {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetTotale() {
		LocalDate[] inizio = {LocalDate.now(), null, LocalDate.now(), LocalDate.now()};
		LocalDate[] fine = {LocalDate.now(), LocalDate.now(), null, LocalDate.now()};
		String[] kmNoleggio = {"limitato", "illimitato", "illimitato", "super"};
		double[] expected = {300, 0, 0, 0};
		
		for(int i = 0; i < expected.length; i++){
			assertTrue("Failed at " + i, CalcoloTotale.setTotale(inizio[i], fine[i], 10, 30, kmNoleggio[i]) == expected[i]);
		}
		
		
	}

}
