package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.persistence.criteria.Root;
import java.awt.event.ActionEvent;




public class Controller{
    @FXML
     GridPane main;
    @FXML
    Label labels;
    @FXML
    Label something;
    @FXML
    CheckBox createstudent;
    @FXML
    CheckBox updatestudent;
    @FXML
    CheckBox removestudent;
    @FXML
    Button show;

    Label label;
    TextField textField;
    TextField textField1;
    TextField idField;

    @FXML
    public void showArea(){
        if(textField == null && textField1== null && label == null){
            createTextField();
        }
        hideArea();

            if(createstudent.isSelected()){
                label.setText("Create Students");
            }else if(updatestudent.isSelected()){
                label.setText("Update Students");
            }else if(removestudent.isSelected()){
                label.setText("Remove Students");
            }
                if(createstudent.isSelected() && updatestudent.isSelected() || createstudent.isSelected() &&  removestudent.isSelected() || updatestudent.isSelected() && removestudent.isSelected()){
                      popUp();
                  }else{
                    setVisible();
                }
    }

    public  void popUp() {
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification!!!");
            alert.setHeaderText("Please Look ");
            alert.setContentText("You can choose only 1 checkbox !!!");
            alert.showAndWait();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void setVisible(){
        something.setVisible(false);
        label.setVisible(true);
        if(!removestudent.isSelected()) {
            textField.setVisible(true);
            textField1.setVisible(true);
        }
           if(createstudent.isSelected())idField.setVisible(false);
           else idField.setVisible(true);

    }

    public void hideArea(){
                if(idField != null) idField.setVisible(false);
                textField1.setVisible(false);
                textField.setVisible(false);
                label.setVisible(false);
                something.setVisible(true);
    }

    @FXML
    public void applyData(){
     if(textField != null && textField1 != null && !textField.equals("") && !textField1.equals("") && createstudent.isSelected() && !updatestudent.isSelected() & !removestudent.isSelected()){
         String firstname = textField.getText();
         String lastname = textField1.getText();
        EntityManagers.createStudent(firstname,lastname);
     }
     if(textField != null && textField1 != null && !textField.equals("") && !textField1.equals("") && updatestudent.isSelected() && !createstudent.isSelected() && !removestudent.isSelected()){
            String firstname = textField.getText();
            String lastname = textField1.getText();
            Integer id = Integer.parseInt(idField.getText());
            EntityManagers.updateStudent(firstname,lastname,id);
        }
        if(textField != null && textField1 != null && !textField.equals("") && !textField1.equals("") && removestudent.isSelected() && !createstudent.isSelected() && !updatestudent.isSelected()){
            String firstname = textField.getText();
            String lastname = textField1.getText();
            Integer id = Integer.parseInt(idField.getText());
            EntityManagers.remove(id);
        }
    }

    @FXML
    public void createTextField(){
         label = new Label();
         textField = new TextField();
         textField1 = new TextField();
        idField = new TextField();
         main.add(label,0,1);
        label.setTextFill(Color.RED);
        main.setMargin(label,new Insets(100,0,0,0));
        main.setMargin(textField, new Insets(60,0,0,0));
        main.setMargin(idField, new Insets(-60,0,0,0));
        textField.setStyle("-fx-background-color: #666633;");
        textField1.setStyle("-fx-background-color: #f4d341");
        idField.setStyle("-fx-background-color: #f4d341");
        idField.setPromptText("Type id here!!!");
        textField.setPromptText("Type firstname here!!!");
        textField1.setPromptText("Type lastname here!!!");
        main.add(textField,0,1);
        main.add(textField1,0,1);
        main.add(idField,0,1);

    }



}
