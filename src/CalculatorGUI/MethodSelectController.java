package CalculatorGUI;

//TODO: Make use of visible probably when only one matrix is needed

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MethodSelectController {

    private AddSubMMController addSubMMController;
    private DetAndTraceController detAndTraceController;
    private MultiplyConstController multiplyConstController;
    private TransposeController transposeController;

    @FXML
    public ComboBox choiceBox;

    @FXML
    public Button inputMatrix;

    @FXML
    public Button quit;

    @FXML
    protected String choice() {
        return choiceBox.getValue().toString();
    }

    @FXML
    protected void fillMatrix() {
        System.out.println(choice());
        fxmlLoad(choice());
    }

    protected void fxmlLoad(String choice) {
        switch (choice) {
            case "Addition":
            case "Subtract":
            case "Matrix Multiply":
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddSubMM.fxml"));
                    Parent root = loader.load();
                    addSubMMController = loader.getController();
                    addSubMMController.setChoice(choice);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("ABC");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Determinant":
            case "Trace":
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DetAndTrace.fxml"));
                    Parent root = loader.load();
                    detAndTraceController = loader.getController();
                    detAndTraceController.setChoice(choice);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("ABC");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Transpose":
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Transpose.fxml"));
                    Parent root = loader.load();
                    transposeController = loader.getController();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("ABC");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Multiply by Constant":
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("MultiByCons.fxml"));
                    Parent root = loader.load();
                    multiplyConstController = loader.getController();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("ABC");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @FXML
    protected void onKeyPressedCheck() {
        //TODO: Just let user type shit and when clicking on calculate throw error "Wrong Input"
    }

    @FXML
    protected void closeDialog() {
        System.exit(0);
    }
}
