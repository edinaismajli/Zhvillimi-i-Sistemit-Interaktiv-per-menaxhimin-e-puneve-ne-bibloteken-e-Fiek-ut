package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import services.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MainController {

    @FXML private TextField title;
    @FXML private TextField author;
    @FXML private TextField deleteId;

    // INSERT
    @FXML
    public void addBook() {
        try {
            Connection conn = DatabaseService.getConnection();
            String sql = "INSERT INTO books(title, author) VALUES(?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title.getText());
            ps.setString(2, author.getText());

            ps.executeUpdate();
            System.out.println("Book added");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    @FXML
    public void deleteBook() {
        try {
            Connection conn = DatabaseService.getConnection();
            String sql = "DELETE FROM books WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(deleteId.getText()));

            ps.executeUpdate();
            System.out.println("Book deleted");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }