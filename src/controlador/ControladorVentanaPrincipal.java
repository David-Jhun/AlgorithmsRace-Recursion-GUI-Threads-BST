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
    	if( radioAdd.isSelected() ) {
    		if( radioIterative.isSelected() ) {
    			
    		}else if( radioRecursive.isSelected() ) {
    			
    		}else if( comprobarBotonesIR() == false ) {
    			limpiarRadioButtons();
    			Alert alerta = new Alert(AlertType.INFORMATION);
        		alerta.setTitle("Precaucion.");
        		alerta.setHeaderText(null);
        		alerta.setContentText("Por favor seleccione un algoritmo y un modo de carrera.");
        		alerta.show();
    		}
    	}else if( radioSearch.isSelected() ) {
    		if( radioIterative.isSelected() ) {
    			
    		}else if( radioRecursive.isSelected() ) {
    			
    		}else if( comprobarBotonesIR() == false ) {
    			limpiarRadioButtons();
    			Alert alerta = new Alert(AlertType.INFORMATION);
        		alerta.setTitle("Precaucion.");
        		alerta.setHeaderText(null);
        		alerta.setContentText("Por favor seleccione un algoritmo y un modo de carrera.");
        		alerta.show();
    		}
    	}else if( radioDelete.isSelected() ) {
    		if( radioIterative.isSelected() ) {
    			
    		}else if( radioRecursive.isSelected() ) {
    			
    		}else if( comprobarBotonesIR() == false ) {
    			limpiarRadioButtons();
    			Alert alerta = new Alert(AlertType.INFORMATION);
        		alerta.setTitle("Precaucion.");
        		alerta.setHeaderText(null);
        		alerta.setContentText("Por favor seleccione un algoritmo y un modo de carrera.");
        		alerta.show();
    		}
    	}else if( comprobarBotonesASD() == false && comprobarBotonesIR() == false ) {
    		limpiarRadioButtons();
    		Alert alerta = new Alert(AlertType.INFORMATION);
    		alerta.setTitle("Precaucion.");
    		alerta.setHeaderText(null);
    		alerta.setContentText("Por favor seleccione un algoritmo y un modo de carrera.");
    		alerta.show();
    	}
    	limpiarRadioButtons();
    }
    
    public int comprobarEntero() {
    	int numero = 0;
    	try {
    		numero = Integer.parseInt(valorEntrada.getText());
    		valorEntrada.clear();
    	}catch( NumberFormatException e ) {
    		limpiarRadioButtons();
    		valorEntrada.clear();
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Error!!!");
    		alerta.setHeaderText(null);
    		alerta.setContentText("Se ha producido un error: " + "\n" + e.getMessage());
    		alerta.showAndWait();
    	}catch( Exception e ) {
    		limpiarRadioButtons();
    		valorEntrada.clear();
    		Alert alerta = new Alert(AlertType.ERROR);
    		alerta.setTitle("Error desconocido.");
    		alerta.setHeaderText(null);
    		alerta.setContentText("Se ha producido un error: " + "\n" + e.getMessage());
    		alerta.showAndWait();
    	}
    	return numero;
    }
    
    public boolean comprobarBotonesASD() {
    	boolean seleccionado = false;
    	if( radioAdd.isSelected() != false && radioSearch.isSelected() != false && radioDelete.isSelected() != false ) {
    		seleccionado = true;
    	}
    	return seleccionado;
    }
    
    public boolean comprobarBotonesIR() {
    	boolean seleccionado = false;
    	if( radioIterative.isSelected() != false && radioRecursive.isSelected() != false ) {
    		seleccionado = true;
    	}
    	return seleccionado;
    }
    
    public void limpiarRadioButtons() {
    	radioAdd.setSelected(false);
		radioSearch.setSelected(false);
		radioDelete.setSelected(false);
		radioIterative.setSelected(false);
		radioRecursive.setSelected(false);
    }

}

