package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import model.CarreraAlgoritmos;

public class ControladorVentanaPrincipal {
	
	private CarreraAlgoritmos carrera;

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

    }

}

