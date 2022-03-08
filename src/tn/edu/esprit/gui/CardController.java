/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import tn.edu.esprit.model.User;
import tn.edu.esprit.services.ServiceMatching;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author dedpy
 */
public class CardController implements Initializable {

    private ImageView photo;
    @FXML
    private Label nom;
    private Label age;
    private Label adresse;
    private Label description;

    FrontController mainControll;
    @FXML
    private Label tel;
    @FXML
    private Label dda;
    @FXML
    private Label ddf;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void setMainController(FrontController controller) {
        this.mainControll = controller;
    }

    public void setAffichage(User u) {
        ServiceMatching match = new ServiceMatching();
        File file = new File("src/tn/edu/esprit/images/" + u.getPhoto_user());
        Image image = new Image(file.toURI().toString());
        photo.setImage(image);
        nom.setText(u.getNom_user());
        age.setText(String.valueOf(match.calculateAge(u)));
        adresse.setText(u.getAdresse_user());
        description.setText(u.getDescription_user());
    }

}
