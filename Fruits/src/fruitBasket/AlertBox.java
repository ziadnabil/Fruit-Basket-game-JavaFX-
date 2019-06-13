/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitBasket;

import static java.lang.System.exit;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import javafx.scene.control.Button ;

import javafx.geometry.Pos;;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
/**
 *
 * @author nidao
 */
public class AlertBox {
    
    static DropShadow shadow = new DropShadow();
    static boolean answer ;
    public static boolean display(String title , String message){
        
        Stage window = new Stage();
        window.setTitle("Warning");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setWidth(400);
        VBox layout= new VBox(20);
        Scene scene =new Scene(layout);

        Label label= new Label();
        label.setText(message);
        Button yes = new Button("yes");
        yes.setOnAction(e -> {
        answer=true;
        window.close();
        });
        Button no = new Button("no");
        no.setOnAction(e -> {
            answer=false;
            window.close();
                    });
        
        // setting the styles
        yes.setStyle(Setter.style);
        no.setStyle(Setter.style);
        
        //droping effect
        DroppingEffect effectbuttons= new DroppingEffect();
        effectbuttons.effect(yes);
        effectbuttons.effect(no);
    
        layout.getChildren().addAll(label,yes,no);
        layout.setAlignment(Pos.CENTER);
        
        window.setScene(scene);
        window.showAndWait();
        return answer ;
    }
}
