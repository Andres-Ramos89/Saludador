import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Optional;

public class SistemaSaludador extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema Saludador");

        // Botón principal dirigido al estudiante
        Button btnSolicitarSaludo = new Button("Solicitar saludo");
        btnSolicitarSaludo.setStyle("-fx-font-size: 16px; -fx-padding: 10px 25px; -fx-cursor: hand;");
        btnSolicitarSaludo.setOnAction(e -> recolectarDatosYSaludar());

        // Contenedor principal
        StackPane root = new StackPane();
        root.getChildren().add(btnSolicitarSaludo);

        // Configuración de la escena
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void recolectarDatosYSaludar() {
        // Creación del cuadro de diálogo interactivo
        Dialog<DatosEstudiante> dialog = new Dialog<>();
        dialog.setTitle("Datos del Estudiante");
        dialog.setHeaderText("Por favor, ingresa los siguientes datos:");

        // Tipos de botones para el diálogo
        ButtonType btnAceptar = new ButtonType("Aceptar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btnAceptar, ButtonType.CANCEL);

        // Formulario (GridPane)
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        // Entradas de texto y controles
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Tu nombre");

        Spinner<Integer> spinEdad = new Spinner<>(1, 120, 20); // Rango de 1 a 120, valor por defecto 20
        spinEdad.setEditable(true);

        ComboBox<String> cbHora = new ComboBox<>();
        cbHora.getItems().addAll("AM", "PM");
        cbHora.setValue("AM"); // Valor por defecto

        // Añadir elementos al formulario
        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(txtNombre, 1, 0);
        grid.add(new Label("Edad:"), 0, 1);
        grid.add(spinEdad, 1, 1);
        grid.add(new Label("Hora:"), 0, 2);
        grid.add(cbHora, 1, 2);

        dialog.getDialogPane().setContent(grid);

        // Solicitar el foco en el campo del nombre por defecto
        Platform.runLater(txtNombre::requestFocus);

        // Convertir el resultado al hacer clic en Aceptar
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == btnAceptar && !txtNombre.getText().trim().isEmpty()) {
                return new DatosEstudiante(
                        txtNombre.getText().trim(),
                        spinEdad.getValue(),
                        cbHora.getValue()
                );
            }
            return null;
        });

        // Mostrar el diálogo y procesar los datos si el usuario acepta
        Optional<DatosEstudiante> resultado = dialog.showAndWait();
        resultado.ifPresent(this::mostrarAlertaSaludo);
    }

    private void mostrarAlertaSaludo(DatosEstudiante datos) {
        // Lógica estricta del saludo basada en la hora (AM/PM)
        String prefijoSaludo = "AM".equals(datos.getHora()) ? "Buenos días" : "Buenas tardes";
        
        // Formateo natural del mensaje
        String mensajeFinal = String.format("%s %s, me entero que tienes %d años.", 
                prefijoSaludo, datos.getNombre(), datos.getEdad());

        // Mostrar el mensaje en pantalla
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Saludo del Sistema");
        alert.setHeaderText(null);
        alert.setContentText(mensajeFinal);
        alert.showAndWait();
    }

    // Clase interna para manejar los datos del formulario limpiamente
    private static class DatosEstudiante {
        private final String nombre;
        private final int edad;
        private final String hora;

        public DatosEstudiante(String nombre, int edad, String hora) {
            this.nombre = nombre;
            this.edad = edad;
            this.hora = hora;
        }

        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }
        public String getHora() { return hora; }
    }
}
