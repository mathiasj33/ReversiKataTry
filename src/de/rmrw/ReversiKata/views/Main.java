package de.rmrw.ReversiKata.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.mockito.Mockito;

import de.rmrw.ReversiKata.code.IFSpielModel;

public class Main extends Application {
	
	private IFSpielModel model;
	private static final Color ANGEDEUTETEFARBESPIELER2 = Color.LIGHTCORAL;
	private static final Color ANGEDEUTETEFARBESPIELER1 = Color.LIGHTBLUE;
	private static final Color FARBESPIELER2 = Color.RED;
	private static final Color FARBESPIELER1 = Color.BLUE;
	private static final Color GRUNDFARBE = Color.BEIGE;

	@Override
	public void start(Stage primaryStage) {
		IFSpielModel mockModel = Mockito.mock(IFSpielModel.class);
		JavaFXSpielfeldFeldProperties spielfeldFeldProperties = new JavaFXSpielfeldFeldProperties(
				50,            // Groesse
				GRUNDFARBE,   // Grundfarbe
				FARBESPIELER1,    // Farbe Spieler1
				FARBESPIELER2,     // Farbe Spieler2
				ANGEDEUTETEFARBESPIELER1, // Angedeutete Farbe Sp1
				ANGEDEUTETEFARBESPIELER2  // Angedeutete Farbe Sp2
				);

		JavaFXSpiel sV = new JavaFXSpiel(
				mockModel,
				spielfeldFeldProperties
				);
		Scene s = new Scene(sV,500,500);
		s.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
