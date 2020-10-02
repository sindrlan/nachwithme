module nachwithme {
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.controls;
	
	exports nachwithme.ui;
	exports nachwithme.core;
	exports nachwithme.json;

//	exports nachwithme.core to com.google.gson;
//	opens nachwithme.core to com.google.gson;

	opens nachwithme.ui to javafx.fxml;
}