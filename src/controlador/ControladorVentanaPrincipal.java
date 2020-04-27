package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import model.CarreraAlgoritmos;

public class ControladorVentanaPrincipal {
	
	private CarreraAlgoritmos carrera;
	
	@FXML
    private TextField valorEntrada;

    @FXML
    private RadioButton radioAdd;

    @FXML
    private ToggleGroup algoritmos;

    @FXML
    private RadioButton radioSearch;

    @FXML
    private RadioButton radioDelete;

    @FXML
    private RadioButton radioIterative;

    @FXML
    private ToggleGroup modos;

    @FXML
    private RadioButton radioRecursive;

    @FXML
    private Label tiempo;

    @FXML
    private Label tiempoArrayList;

    @FXML
    private Label tiempoListaEnlazada;

    @FXML
    private Label tiempoABB;

    @FXML
    private ImageView imagenArray;

    @FXML
    private ImageView imagenLista;

    @FXML
    private ImageView imagenABB;
    
    public ControladorVentanaPrincipal( CarreraAlgoritmos carrera ) {
    	this.carrera = carrera;
    }

    @FXML
    protected void iniciarCompetencia(ActionEvent event) {
    	int numero = comprobarEntero();
    }
    
    public int comprobarEntero() {
    	int numero = 0;
    	try {
    		numero = Integer.parseInt(valorEntrada.getText());
    	}catch( NumberFormatException e ) {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Error!!!");
    		alerta.setHeaderText(null);
    		alerta.setContentText("Se ha producido un error: " + e.getMessage());
    		alerta.showAndWait();
    	}catch( Exception e ) {
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Error desconocido.");
    		alerta.setHeaderText(null);
    		alerta.setContentText("Se ha producido un error: " + e.getMessage());
    		alerta.showAndWait();
    	}
    	return numero;
    }

}

