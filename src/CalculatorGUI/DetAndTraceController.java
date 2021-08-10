package CalculatorGUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import MatrixMethods.Methods;

import java.util.HashMap;
import java.util.Map;

/*DONE!!!!*/

public class DetAndTraceController {

    // Matrix Text Areas
    @FXML
    public TextField mmA1;
    @FXML
    public TextField mmA2;
    @FXML
    public TextField mmA3;
    @FXML
    public TextField mmA4;
    @FXML
    public TextField mmA5;
    @FXML
    public TextField mmA6;
    @FXML
    public TextField mmA7;
    @FXML
    public TextField mmA8;
    @FXML
    public TextField mmA9;

    //Operation Sign
    @FXML
    public Text mmEquate;

    @FXML
    public TextField mmR;

    @FXML
    public Button calculate;

    @FXML
    public Button close;

    private final Map<String, String> variables = new HashMap<>();

    private double[][] array1;

    private String choice;

    @FXML
    protected void initialize() {
        array1 = new double[3][3];

        close.setOnMouseClicked(v -> {
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        });
    }

    protected void setChoice(String choice) {
        this.choice = choice;
    }

    public void onLastValueEntered() {
        calculate.setOnMouseClicked(v -> methodChoice(choice));
    }

    private void fillMap() {
        variables.put("mmA1", mmA1.getText());
        variables.put("mmA2", mmA2.getText());
        variables.put("mmA3", mmA3.getText());
        variables.put("mmA4", mmA4.getText());
        variables.put("mmA5", mmA5.getText());
        variables.put("mmA6", mmA6.getText());
        variables.put("mmA7", mmA7.getText());
        variables.put("mmA8", mmA8.getText());
        variables.put("mmA9", mmA9.getText());
    }

    public void methodChoice(String selection) {
        fillMap();
        switch (selection) {
            case "Determinant": {
                determinant();
                break;
            }
            case "Trace": {
                trace();
                break;
            }
        }
    }

    private void fillMatrix() {
        String textAreaForm = "mmA";
        int textAreaCount = 1;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                array1[i][j] = Double.parseDouble(variables.get(textAreaForm + String.valueOf(textAreaCount++)));
            }
        }
    }

    private void determinant() {
        fillMatrix();
        mmR.setText(String.valueOf(Methods.determinant(array1)));
    }

    private void trace() {
        fillMatrix();
        mmR.setText(String.valueOf(Methods.trace(array1)));
    }
}
