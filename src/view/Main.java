package view;

import controlador.ControladorVentanaPrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CarreraAlgoritmos;

public class Main extends Application{
	
	private CarreraAlgoritmos carrera;
	private ControladorVentanaPrincipal controlador;
	
	public Main() {
		carrera = new CarreraAlgoritmos();
		controlador = new ControladorVentanaPrincipal(carrera);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Basic Algorithms Race");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("VentanaPrincipal.fxml"));
		loader.setController(controlador);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
