package test.ids.util.properties;

import static org.junit.Assert.*;

import org.junit.Test;

import main.ids.util.properties.DbPropertiesReader;

public class TestDbPropertiesReader {
	
	DbPropertiesReader dbProp = DbPropertiesReader.getInstance();
	
	@Test
	public void testGetProperty() {
		String[] properties = {"user", null};
		String[] expected = {"root", null};
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, dbProp.getProperty(properties[i]), expected[i]);
		}
	}

}
