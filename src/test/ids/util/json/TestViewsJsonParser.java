package test.ids.util.json;

import static org.junit.Assert.*;

import org.junit.Test;

import main.ids.util.json.ViewsJsonParser;

public class TestViewsJsonParser {
	
	ViewsJsonParser views = ViewsJsonParser.getInstance();

	@Test
	public void testGetViewPath() {
		String[] id = {"bootstrap", "test"};
		String[] expected = {"/main/ids/presentation/view/Bootstrap.fxml", null};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, views.getViewPath(id[i]), expected[i]);
		}
	}

}
