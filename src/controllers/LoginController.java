package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    public void handleLogin() {
        String user = username.getText().trim();
        String pass = password.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            showAlert("Gabim", "Ploteso username dhe password.");
            return;
        }

        if (isValidLogin(user, pass)) {
            openMainPage();
        } else {
            showAlert("Login failed", "Username ose password gabim.");
        }
    }

    private boolean isValidLogin(String user, String pass) {
        return user.equals("admin") && pass.equals("1234");
    }

    private void openMainPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/main.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) username.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Main Page");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Nuk u hap faqja kryesore.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
