package co.edu.poli.proyecto.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("/co/edu/poli/proyecto/vista/mmm.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
/* 		@Override
		public void start(Stage primaryStage) {
			try {
				ScrollPane root = (ScrollPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/actividad10/vista/aplicacion.fxml"));
				Scene scene = new Scene(root);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setTitle("MENU");
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			launch(args);
		}
*/