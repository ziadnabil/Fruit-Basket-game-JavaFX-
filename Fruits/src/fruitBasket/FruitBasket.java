/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitBasket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author nidao
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author nidao
 */
public class FruitBasket extends Application {
    
    private static final int SPLASH_WIDTH = 676;
    private static final int SPLASH_HEIGHT = 227;
    
    Stage window ;
    

    @Override

    public void start(Stage primaryStage) throws Exception {
        
        
        
        showSplash(primaryStage);
        Timeline time = new Timeline();
        time.getKeyFrames().addAll(new KeyFrame(Duration.millis(20), e -> {
        }));
        time.setCycleCount(150);
        time.play();
        time.setOnFinished(
                e ->{
            System.out.println("splash screen");
            
            primaryStage.close();
            
            Stage game_stage=new Stage();
            
          
            try {
                showMainStage(game_stage);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(FruitBasket.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FruitBasket.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(FruitBasket.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                });   
    }

    private void showMainStage(Stage primaryStage) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
                
        window = primaryStage ;
        
        Setter setgame=new Setter();

        primaryStage.setTitle("Fruit Basket");
        
        setgame.setter1();
        primaryStage.setScene(setgame.scene1);



        setgame.play.setOnAction(e -> {
            
            setgame.start() ;
            primaryStage.setScene(setgame.scene2);


        });


        setgame.setting.setOnAction((ActionEvent event)->{
            setgame.setting().show();

        });
        setgame.exit.setOnAction((ActionEvent event)->{
            closeProgram();
    
        
        });
        setgame.back.setOnAction(e ->
        {   
            setgame.stop_game();
            primaryStage.setScene(setgame.scene1);
        });
        
        //closing the window from the x mark 
        primaryStage.setOnCloseRequest(e -> {
        
        e.consume();
        closeProgram();
            });
        
        
        primaryStage.show();
        
        
    }

    private void showSplash(Stage initStage) throws InterruptedException, FileNotFoundException {
        Image s = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\start.jpg"));
        ImageView splashImage = new ImageView(s);
        splashImage.setFitWidth(1000);
        ProgressBar loadProgress = new ProgressBar();
        VBox splashLayout = new VBox();
        Scene splashScene = new Scene(splashLayout);
        splashLayout.getChildren().addAll( splashImage,loadProgress);
        initStage.initStyle(StageStyle.UNDECORATED);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        loadProgress.setPrefWidth(1000);
        initStage.setScene(splashScene);
        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH /1.2);
        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT);
        initStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
    
        
    public void closeProgram(){
         boolean result = AlertBox.display("alert box","are you sure ?");
         
         if(result){
             System.out.println("record is saved");
             window.close();
         }
}
    
}
    
