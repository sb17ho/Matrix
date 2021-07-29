package CalculatorGUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import MatrixMethods.Methods;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MultiplyConstController {

    // Matrix Text Areas
    @FXML
    public TextField mmA0;
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

    //Result Matrix
    @FXML
    public TextField mmR1;
    @FXML
    public TextField mmR2;
    @FXML
    public TextField mmR3;
    @FXML
    public TextField mmR4;
    @FXML
    public TextField mmR5;
    @FXML
    public TextField mmR6;
    @FXML
    public TextField mmR7;
    @FXML
    public TextField mmR8;
    @FXML
    public TextField mmR9;

    @FXML
    public Button calculate;

    @FXML
    public Button close;

    private final Map<String, String> variables = new HashMap<>();

    private double[][] array1;
    private double constant;

    @FXML
    protected void initialize() {
        array1 = new double[3][3];

        close.setOnMouseClicked(v -> {
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        });
    }

    public void onLastValueEntered() {
        calculate.setOnMouseClicked(v -> methodChoice());
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

        this.constant = Double.parseDouble(mmA0.getText().toString());
    }

    public void methodChoice() {
        fillMap();
        mmByConstant();
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

    private void mmByConstant() {
        fillMatrix();
        int index = 1;

        double[][] result = Methods.multiplyByConstant(array1, constant);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                fillResultArray(index++, String.valueOf(result[i][j]));
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private void fillResultArray(int textArea, String value) {
        switch (textArea) {
            case 1:
                mmR1.setText(value);
                break;
            case 2:
                mmR2.setText(value);
                break;
            case 3:
                mmR3.setText(value);
                break;
            case 4:
                mmR4.setText(value);
                break;
            case 5:
                mmR5.setText(value);
                break;
            case 6:
                mmR6.setText(value);
                break;
            case 7:
                mmR7.setText(value);
                break;
            case 8:
                mmR8.setText(value);
                break;
            case 9:
                mmR9.setText(value);
                break;
        }
    }
}
