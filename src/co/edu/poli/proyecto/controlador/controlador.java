package co.edu.poli.proyecto.controlador;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


import co.edu.poli.proyecto.modelo.Refugio;
import co.edu.poli.proyecto.servicios.Conexion;
import co.edu.poli.proyecto.servicios.Tarea_dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class controlador implements Initializable{

	   @FXML
	    private RadioButton F;

	    @FXML
	    private RadioButton M;

	    @FXML
	    private ComboBox<String> Raza;

	    @FXML
	    private DatePicker Vacuna;

	    @FXML
	    private Button boton_buscar;

	    @FXML
	    private Button boton_salir;

	    @FXML
	    private TextField buscar;

	    @FXML
	    private ToggleGroup edad;

	    @FXML
	    private Button eliminar;

	    @FXML
	    private RadioButton no;

	    @FXML
	    private TextField nombre_mascota;

	    @FXML
	    private Button boton_registrar;

	    @FXML
	    private ToggleGroup sexo;

	    @FXML
	    private RadioButton si;

	    @FXML
	    private TableView<Refugio> tabla;

	    @FXML
	    private TextField telefono;

	    @FXML
	    private TextField usuario;
	    private Tarea_dao tarea_dao;

	    private ContextMenu cmopciones;

	    private Conexion ideas;

	    private Refugio tareaSelected;
	    @FXML
	    private ContextMenu Menu2;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  String[] items = {"canino", "Felino"};
		    Raza.getItems().addAll(items);
		    Raza.setValue("seleccione");
		    System.out.println("Items added to ComboBox: " + Raza.getItems());

		    // Configurar el ToggleGroup para sexo
		    ToggleGroup sexo = new ToggleGroup();
		    M.setToggleGroup(sexo);
		    F.setToggleGroup(sexo);
		    this.tarea_dao = new Tarea_dao();
		    cargar_prestamos();

		    Menu2=new ContextMenu();
        	MenuItem editar=new MenuItem("editar");
        	Menu2.getItems().addAll(editar);
        	tabla.setContextMenu(Menu2);
        	// Asignar acción para el item "Editar"
            editar.setOnAction(event -> {
                // Obtener el elemento seleccionado en la tabla
                Refugio seleccionado = tabla.getSelectionModel().getSelectedItem();
                if (seleccionado != null) {
                    cargarDatosEnFormulario(seleccionado); // Método para cargar datos al formulario
                } else {
                    Alert alert = new Alert(AlertType.WARNING, "No hay un elemento seleccionado.", ButtonType.OK);
                    alert.showAndWait();
                }
            });


	 }






	public void  cargar_prestamos() {
		tabla.getItems().clear();
		tabla.getColumns().clear();
	    List<Refugio> tareas=this.tarea_dao.listar();
	    ObservableList<Refugio> data2=FXCollections.observableArrayList(tareas);



	    TableColumn idcol=new   TableColumn ("ID");
	    idcol.setCellValueFactory(new PropertyValueFactory<>("ID"));

	    TableColumn razaol=new TableColumn("raza");
	    razaol.setCellValueFactory(new PropertyValueFactory<>("raza"));


	    TableColumn proxima_vacunaCol=new TableColumn("proxima_vacuna");
	    proxima_vacunaCol.setCellValueFactory(new PropertyValueFactory<>("proxima_vacuna"));

	    TableColumn nombre_mascotaCol=new TableColumn("nombre_de_mascota");
	    nombre_mascotaCol.setCellValueFactory(new PropertyValueFactory<>("nombre_de_mascota"));


	    TableColumn sexoCol=new TableColumn("sexo");
	    sexoCol.setCellValueFactory(new PropertyValueFactory<>("sexo"));

	    TableColumn nombre_usuarioCol=new TableColumn("nombre_usuario");
	    nombre_usuarioCol.setCellValueFactory(new PropertyValueFactory<>("nombre_usuario"));


	    TableColumn edadCOL=new TableColumn("mayor_edad");
	    edadCOL.setCellValueFactory(new PropertyValueFactory<>("mayor_edad"));

	    TableColumn telefonoCOL=new TableColumn("telefono");
	      telefonoCOL.setCellValueFactory(new PropertyValueFactory<>("telefono"));



	    tabla.setItems(data2);
	    tabla.getColumns().addAll(idcol,razaol,nombre_mascotaCol,proxima_vacunaCol, sexoCol,nombre_usuarioCol,edadCOL,telefonoCOL);

}

    @FXML
    void  registrar_dato(ActionEvent event) {
    	 try {
			    if (tareaSelected == null) {
			        // Si tareaSelected es null, creamos un nuevo préstamo
			        Refugio prestamo = new Refugio();

			        // Asignación de valores al préstamo
			        prestamo.setRaza(Raza.getSelectionModel().getSelectedItem());
			        prestamo.setProxima_vacuna(Vacuna.getValue().toString());
			        prestamo.setNombre_de_mascota(nombre_mascota.getText());


			        if (M.isSelected()) {
			            prestamo.setSexo("masculino");
			        } else if (F.isSelected()) {
			            prestamo.setSexo("femenino");
			        } else {
			            prestamo.setSexo(" ");
			        }
			        prestamo.setNombre_usuario(usuario.getText());

			        if (si.isSelected()) {
			            prestamo.setMayor_edad("cumple");
			        } else if (no.isSelected()) {
			            prestamo.setMayor_edad("no cumple ");
			        } else {
			            prestamo.setMayor_edad(" ");
			        }

			        prestamo.setTelefono(telefono.getText());

			        // Imprimir los detalles del préstamo para depuración
			        System.out.println(prestamo.toString());
			        System.out.println("ID generado: " + prestamo.getID());

			        // Registrar préstamo en la base de datos
			        boolean rsp = this.tarea_dao.registrar2(prestamo);

			        // Mostrar el resultado de la operación
			        if (rsp) {
			            Alert alert = new Alert(Alert.AlertType.INFORMATION);
			            alert.setTitle("Éxito");
			            alert.setHeaderText(null);
			            alert.setContentText("Se registró correctamente el préstamo.");
			            alert.initStyle(StageStyle.UTILITY);
			            alert.showAndWait();
			            cargar_prestamos(); // Cargar la lista de préstamos
			        } else {
			            Alert alert = new Alert(Alert.AlertType.ERROR);
			            alert.setTitle("Error");
			            alert.setHeaderText(null);
			            alert.setContentText("NO se registró correctamente el préstamo.");
			            alert.initStyle(StageStyle.UTILITY);
			            alert.showAndWait();
			        }

			        // Limpiar el formulario después de la operación
			        limpiarFormulario();
			    } else {
			        // Si tareaSelected no es null, actualizamos el préstamo existente
			        tareaSelected.setRaza(Raza.getSelectionModel().getSelectedItem());
			        tareaSelected.setProxima_vacuna(Vacuna.getValue().toString());
			        tareaSelected.setTelefono(telefono.getText());
			        tareaSelected.setNombre_de_mascota(nombre_mascota.getText());

			        // Lógica para mantenimiento de bicicleta
			        if (M.isSelected()) {
			            tareaSelected.setRaza("Masculino");
			        } else if (F.isSelected()) {
			            tareaSelected.setRaza("femenino");
			        } else {
			            tareaSelected.setRaza(" ");
			        }
			        tareaSelected.setNombre_usuario(usuario.getText());

			        if (si.isSelected()) {
			            tareaSelected.setMayor_edad("mayor de edad");
			        } else if (no.isSelected()) {
			            tareaSelected.setMayor_edad("no cumple ");
			        } else {
			            tareaSelected.setMayor_edad(" ");
			        }
			        tareaSelected.setTelefono(telefono.getText());



			        boolean rsp=this.tarea_dao.editar(tareaSelected);
                  if (rsp) {
			            Alert alert = new Alert(Alert.AlertType.INFORMATION);
			            alert.setTitle("Éxito");
			            alert.setHeaderText(null);
			            alert.setContentText("Se guardo correctamente el préstamo.");
			            alert.initStyle(StageStyle.UTILITY);
			            alert.showAndWait();
			            cargar_prestamos(); // Cargar la lista de préstamos
			        } else {
			            Alert alert = new Alert(Alert.AlertType.ERROR);
			            alert.setTitle("Error");
			            alert.setHeaderText(null);
			            alert.setContentText("NO se registró correctamente el préstamo.");
			            alert.initStyle(StageStyle.UTILITY);
			            alert.showAndWait();

			           limpiarFormulario();
			           cargar_prestamos();


			        }

                  // Aquí puedes agregar la lógica para guardar o actualizar el préstamo en la base de datos
			    }
			} catch (Exception e) {
			    // Manejo de excepciones
			    Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setTitle("Error");
			    alert.setHeaderText("Ingresa todos los datos correspondientes.");
			    alert.setContentText("Detalles del error: " + e.getMessage());
			    alert.initStyle(StageStyle.UTILITY);
			    alert.showAndWait();
			}

	 }
    private void limpiarFormulario() {
		Raza.setValue("seleccione");
		Vacuna.setValue(null);
		nombre_mascota.clear();
		M.setSelected(false);
		F.setSelected(false);
		usuario.clear();
		si.setSelected(false);
		no.setSelected(false);
		telefono.clear();






	 }

    @FXML
    void  salir(ActionEvent event) {
    	 Stage stage = (Stage) boton_salir.getScene().getWindow();
	        stage.close();
    }

    public void editar(Refugio prestamo) {
		try {
			String sql="update prestamo set raza=?,nombres_de_mascota=?,proxima_vacuna=?,sexo=?,nombre_usuario=?,mayor_edad =?,contacto=? WHERE ID=?";
			Connection connection =Conexion.getConnection();
			PreparedStatement sentencia = connection.prepareStatement(sql);

			sentencia.setString(1, prestamo.getRaza());
			sentencia.setString(2, prestamo.getProxima_vacuna());
			sentencia.setString(3, prestamo.getNombre_de_mascota());
			sentencia.setString(4, prestamo.getSexo());
			sentencia.setString(5, prestamo.getNombre_usuario());
			sentencia.setString(6, prestamo.getMayor_edad());
			sentencia.setString(7, prestamo.getTelefono());
			sentencia.setInt(8, prestamo.getID());
			sentencia.close();
			return;

		} catch (Exception e) {
			System.err.println("Ocurrió un error al editar los prestamos");
	        System.err.println("Mensaje del error: " + e.getMessage());
	        System.err.println("Detalle del error:");
	        e.printStackTrace();
	        return;
		}





}
    @FXML
    void menu_ejecutar(ActionEvent event) {
    	 // Validar si se seleccionó una fila
        int index = tabla.getSelectionModel().getSelectedIndex();
        if (index < 0) {
            System.out.println("No se ha seleccionado ninguna fila");
            return;
        }

        // Obtener el elemento seleccionado
        tareaSelected = tabla.getItems().get(index);
        System.out.println("Elemento seleccionado: " + tareaSelected);

        // Cargar los datos en los controles de la interfaz
        Raza.setValue(tareaSelected.getRaza());
        nombre_mascota.setText(tareaSelected.getNombre_de_mascota());


        // Configurar fecha de culminación del préstamo
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Vacuna.setValue(LocalDate.parse(tareaSelected.getProxima_vacuna(), formatter));


        // Configurar los RadioButtons
        if ("masculino".equals(tareaSelected.getSexo())) {
            M.setSelected(true);
        } else if ("femenino".equals(tareaSelected.getSexo())) {
            F.setSelected(true);
        }
        usuario.setText(tareaSelected.getNombre_usuario());

        if ("cumple".equals(tareaSelected.getMayor_edad())) {
            si.setSelected(true);
        } else if ("no cumple con el requisito".equals(tareaSelected.getMayor_edad())) {
            no.setSelected(true);
        }


        // Configurar los TextFields

        telefono.setText(tareaSelected.getTelefono());


        // Habilitar el botón de cancelar


        // Establecer menú contextual si es necesario
        tabla.setContextMenu(Menu2);
    }

    private void cargarDatosEnFormulario(Refugio prestamo) {
        try {

            Raza.getSelectionModel().select(prestamo.getRaza());
            Vacuna.setValue(LocalDate.parse(prestamo.getProxima_vacuna(), DateTimeFormatter.ISO_DATE));


            Vacuna.setValue(LocalDate.parse(prestamo.getProxima_vacuna(), DateTimeFormatter.ISO_DATE));

            if ("masculino".equals(prestamo.getSexo())) {
                M.setSelected(true);
            } else if ("femenino".equals(prestamo.getSexo())) {
                F.setSelected(true);
            } else {
                M.setSelected(false);
                F.setSelected(false);
            }
            usuario.setText(prestamo.getNombre_usuario());

            if ("cumple".equals(prestamo.getMayor_edad())) {
                si.setSelected(true);
            } else if ("no cumple con el requisito".equals(prestamo.getMayor_edad())) {
                no.setSelected(true);
            } else {
                si.setSelected(false);
                no.setSelected(false);
            }

               telefono.setText(prestamo.getTelefono());


            // Guardar el préstamo seleccionado para futura edición
            tareaSelected = prestamo;

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Error al cargar datos en el formulario: " + e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }
    @FXML
    void buscar_ID(ActionEvent event) {
    	try {
    	    String nombre_usuario = buscar.getText();

    	    // Verificar que el campo de búsqueda no esté vacío
    	    if (nombre_usuario == null || nombre_usuario.trim().isEmpty()) {
    	        System.out.println("Por favor, ingresa un nombre válido.");
    	        return;
    	    }

    	    // Realizar la búsqueda en la base de datos
    	    Refugio r = Tarea_dao.buscar_regur(nombre_usuario);

    	    // Verificar si se encontró el préstamo
    	    if (r == null) {
    	        System.out.println("Préstamo no encontrado.");
    	        // Aquí podrías mostrar un mensaje en la interfaz
    	    } else {
    	        mostrar(r);
    	    }
    	} catch (Exception e) {
    	    // Manejo de excepciones
    	    System.out.println("Se produjo un error durante la búsqueda: " + e.getMessage());
    	    // También podrías mostrar un mensaje de error en la interfaz
    	}
    }


	private void mostrar(Refugio r) {
		try {
		    if (r != null) {
		        buscar.setText("Prestamo con ID: " + String.valueOf(r.getID()));



		        // Continuar con otros campos si es necesario
		    } else {
		        System.out.println("No se encontró el préstamo.");
		        // Aquí puedes agregar un mensaje visual en la interfaz para indicar que no se encontró el préstamo
		    }
		} catch (Exception e) {
		    // Manejo de excepciones
		    System.out.println("Se produjo un error al mostrar los detalles del préstamo: " + e.getMessage());
		    // También podrías mostrar un mensaje de error en la interfaz
		}
	}
	@FXML
	  void eliminar_dato(ActionEvent event) {
	    	// Obtener el préstamo seleccionado en la tabla
	        Refugio prestamoSeleccionado = tabla.getSelectionModel().getSelectedItem();
	        if (prestamoSeleccionado != null) {
	            // Confirmar eliminación
	            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de que deseas eliminar este préstamo?", ButtonType.YES, ButtonType.NO);
	            alert.setHeaderText(null);
	            alert.setTitle("Confirmación de eliminación");

	            // Verificar respuesta del usuario
	            Optional<ButtonType> result = alert.showAndWait();
	            if (result.isPresent() && result.get() == ButtonType.YES) {
	                // Llamar al método eliminar_dato usando el id del préstamo seleccionado
	                boolean eliminado = tarea_dao.eliminar_dato(prestamoSeleccionado.getID());
	                if (eliminado) {
	                    // Actualizar la tabla después de la eliminación
	                    tabla.getItems().remove(prestamoSeleccionado);
	                } else {
	                    Alert errorAlert = new Alert(Alert.AlertType.ERROR, "No se pudo eliminar el préstamo.");
	                    errorAlert.showAndWait();
	                }
	            }
	        } else {
	            // Mostrar alerta si no hay selección
	            Alert alert = new Alert(Alert.AlertType.WARNING, "Selecciona un préstamo para eliminar.");
	            alert.setHeaderText(null);
	            alert.setTitle("Advertencia");
	            alert.showAndWait();
	        }
	    }

}

