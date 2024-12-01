module Ifood2p {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires java.net.http;
	
	opens application to javafx.graphics, javafx.fxml;
}
