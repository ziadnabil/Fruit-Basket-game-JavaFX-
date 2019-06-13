/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitBasket;

/**
 *
 * @author nidao
 */
/**
 *
 * @author nidao
 */
import static fruitBasket.AlertBox.shadow;
import java.io.File;
import java.io.FileInputStream;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JFrame;


public class Setter {
    
    private boolean flag;
    double speed=10,count=0 , fruits_time = 200;
    static String style="-fx-background-color: \n" +
            "        #090a0c,\n" +
            "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
            "        linear-gradient(#20262b, #191d22)" +
            "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
            "    -fx-background-radius: 50,50,20,30;\n" +
            "    -fx-background-insets: 0,1,1;\n" +
            "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n";
    
    //buttons
    Image play1 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\play.png"));
    Image setting1 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\gear.png"));
    Image exit1 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\undo.png"));
    Image back1 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\x-mark.png"));
    Button play = new Button("Play", new ImageView(play1));
    Button setting = new Button("Setting",new ImageView(setting1));
    Button exit = new Button("Exit",new ImageView(exit1));
    Button back=new Button("back",new ImageView(back1));
    
    
      
      
    //Setting the image view 
    Image background1 = new Image(new FileInputStream("C:\\\\Users\\\\nidao\\\\Desktop\\\\wall.jpg"));
    ImageView background = new ImageView(background1);
    //imageviews 
    Image wall1 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\wall1.jpg"));
    ImageView wall = new ImageView(wall1);
    Image basket1 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\basket.png"));
    ImageView basket = new ImageView(basket1);
    // for leafs
    Image leaf1 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\leaf1.png"));
    Image leaf2 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\leaf1.png"));
    
    

    //screen bound
    private Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    private double HEIGH=screenBounds.getHeight();
    private double WIDTH=screenBounds.getWidth();

    //panes
    Pane game_pane = new Pane();
    Pane primary_pane=new Pane();
    Pane basket_pane=new Pane();
    Pane fruits_leafs;
    ImageView fruit;
    VBox info=new VBox();

    
    //scenes
    Scene scene1 = new Scene(primary_pane, WIDTH, HEIGH);
    Scene scene2 = new Scene(game_pane, WIDTH, HEIGH);
    
    
    Controller controller=new Controller();
    Ruits fruits=new Ruits();
  
    Timeline playTime=new Timeline();
    Label level=new Label();
    Label live=new Label();
    Label score=new Label();
    
   
    

    public Setter() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    }


    public void setter1() {


        play.setMaxSize(WIDTH / 5, HEIGH / 7);
        play.setWrapText(true);
        play.setLayoutX(WIDTH * .75);
        play.setLayoutY(HEIGH / 2);
        play.setStyle(style+"-fx-font-size: 2em; " );
        setting.setMaxSize(WIDTH / 7, HEIGH / 7);
        setting.setLayoutX(WIDTH / 4);
        setting.setLayoutY(HEIGH / 4);
        setting.setStyle(style);
        exit.setMaxSize(WIDTH / 7, HEIGH / 7);
        exit.setLayoutX(WIDTH / 4);
        exit.setLayoutY(HEIGH * .75);
        exit.setStyle(style);
        
        
        background.setFitHeight(HEIGH);
        background.setFitWidth(WIDTH);
        level.setFont(Font.font(100));
        level.setTextFill(new Color(1, .2, .2, .8));
        score.setFont(Font.font(40));
        score.setTextFill(new Color(.1, .8, 1, .8));
        live.setFont(Font.font(40));
        live.setTextFill(new Color(.1, .9, 1, .8));
        

        
        //droping effect for buttons 
        DroppingEffect effectbuttons= new DroppingEffect();
        effectbuttons.effect(setting);
        effectbuttons.effect(play);
        effectbuttons.effect(exit);
        effectbuttons.effect(back);
       
            
        //setter for scene 2
        back.setLayoutX(WIDTH - 200);
        back.setLayoutY(100);
        back.setStyle(style);
        wall.setFitWidth(WIDTH);
        wall.setFitHeight(HEIGH);
        basket_pane.setMaxHeight(HEIGH / 5);
        basket_pane.setMaxWidth(WIDTH / 5);
        basket_pane.setLayoutX((WIDTH / 2));
        basket_pane.setLayoutY(HEIGH * .8);
        basket.setFitHeight(HEIGH / 5);
        basket.setFitWidth(WIDTH / 5);
        basket_pane.getChildren().add(basket);
        
        info.getChildren().addAll(level,live,score);
        primary_pane.getChildren().addAll(wall,play, setting, exit);
    }

    public Stage setting() {

        Stage stage2 = new Stage();
        stage2.setTitle("Setting");
        
        
        stage2.setTitle("ChoiceBox Demo");
        Button button = new Button("Sound");
        button.setStyle(style);
        
        //droping effect
        DroppingEffect effectbutton= new DroppingEffect();
        effectbutton.effect(button);
        
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems returns the ObservableList object which you can add items to
        choiceBox.setStyle("-fx-background-color: \n" +
                      "        #090a0c,\n" +
                      "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                      "        linear-gradient(white, #6b0e0e)"+
                      "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                      "    -fx-background-radius: 30;\n" +
                      "    -fx-background-insets: 0,1,1;\n" +
                      "    -fx-text-fill: linear-gradient(blue);\n");
        //droping effect
        choiceBox.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
            choiceBox.setEffect(shadow);
          }
        });
        choiceBox.addEventHandler(MouseEvent.MOUSE_EXITED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
            choiceBox.setEffect(null);
          }
        });
        
        choiceBox.getItems().addAll("1", "2", "3","4");

        //Set a default value
        choiceBox.setValue("1");

        button.setOnAction(e -> getChoice(choiceBox));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, button);

        Scene setting = new Scene(layout, 300, 250);
        stage2.setScene(setting);
        
        stage2.setTitle("Playing Audio");  
        stage2.show(); 


        return stage2;

    }

    public void start()
    {   
        playTime.stop();
        controller.reset();
        level.setText("Level : " + controller.getLevel());
        live.setText("live : " + controller.getLive());
        score.setText("Score : " + controller.getScore());
        game_pane.getChildren().removeAll(fruits_leafs);
        basket_pane.getChildren().removeAll(fruit);
        Pane fruits_leafs = new Pane();
        game_pane.setStyle(
                "-fx-border-color: red;");
        game_pane.getChildren().addAll(background, basket_pane, back, fruits_leafs, info);

       
        
        
        // moving the basket
        scene2.setOnKeyPressed(e ->{
            switch (e.getCode()){
                case RIGHT:
                    if (basket_pane.getLayoutX() < WIDTH - basket_pane.getWidth()) {
                        basket_pane.setLayoutX(basket_pane.getLayoutX() + 50);
                        System.out.println("right");
                    }
                    break;
                case LEFT:
                    if (basket_pane.getLayoutX() > 0) {
                        basket_pane.setLayoutX(basket_pane.getLayoutX() - 50);
                        System.out.println("left");
                    }
                    break;


            }
        });
        // switching between leaf1 and leaf2
        playTime.getKeyFrames().addAll(new KeyFrame(Duration.millis(400), e ->
        {
            if(flag) {
                this.fill_leafs(this.leaf1,fruits_leafs);
                flag=false;
            }
            else {
                this.fill_leafs(this.leaf2,fruits_leafs);
                flag=true;
            }

        }));
        
        // checking the score 
        playTime.getKeyFrames().addAll(new KeyFrame(Duration.seconds(2),e ->
        {
            if(controller.IsAlive()) {
                this.play(fruits.getFruit(),fruits_leafs);
                
                //increase level and speed of fruits when score increase by 20
                if (controller.getScore() == count + 20) {
                    level.setText("Level : " + controller.increaseLevel());
                    count = controller.getScore();
                    speed += 5;
                }
            }

            else {
                // GAME OVER
                Label label1 = new Label("GAME OVER");
                Label label2= new Label("Score : "+controller.getScore());
                label1.setLayoutX(WIDTH / 2.5);
                label1.setLayoutY(HEIGH / 2.2);
                label2.setLayoutX(WIDTH / 2.5);
                label2.setLayoutY(HEIGH / 1.8);
                label1.setFont(Font.font(100));
                label2.setFont(Font.font(50));
                label1.setTextFill(new Color(1,0,0,.8));
                label2.setTextFill(new Color(1,0,0,.8));
                   
                game_pane.getChildren().removeAll(fruits_leafs, info);
                game_pane.getChildren().addAll(label1, label2);
                
                
                return;
            }
            

        }));
        // time of the game
        playTime.setCycleCount(Timeline.INDEFINITE);
        playTime.play();
    }

    
    
    
    public void play(ImageView fruit,Pane fruits_leafs)
    {   
        Media media5 = new Media(new File("C:\\Users\\nidao\\Desktop\\tn.wav").toURI().toString());
        MediaPlayer mediaPlayer5 = new MediaPlayer(media5);
        
        Timeline animation1 = new Timeline();
        fruits_leafs.getChildren().removeAll(fruit);
        fruits_leafs.getChildren().add(fruit);

     
        animation1.getKeyFrames().addAll(new KeyFrame(Duration.millis(20), e -> {

            fruit.setY(fruit.getY() +speed);
            
            // fruit out of the boundary + decreasing your live
            if (fruit.getY()>HEIGH) {

                fruits_leafs.getChildren().removeAll(fruit);
                animation1.stop();
                live.setText("Live : "+controller.decreaseLive());
                return;
            }
            // fruit inside the basket + increasing the score
            if (fruit.getY()>HEIGH-basket.getFitHeight()+10 && fruit.getX()>basket_pane.getLayoutX()-10 && fruit.getX()<basket_pane.getLayoutX()+basket.getFitWidth()-10)
            {

                fruits_leafs.getChildren().removeAll(fruit);
                animation1.stop();
                //basket_fruits(root3);
                score.setText("Score : "+controller.increaseScore());
                mediaPlayer5.setAutoPlay(true);
                return ;
            }
            
        }));
        


        animation1.setCycleCount(200);
        animation1.play();


    }
    
    public void fill_leafs(Image temp1 ,Pane fruits_leafs)
    {   
        Timeline animation2 = new Timeline();
        ImageView temp=new ImageView(temp1);
        temp.setX((new Random().nextInt((int)WIDTH-120))+20);
        temp.setY(-50);

        fruits_leafs.getChildren().add(temp);

        animation2.getKeyFrames().addAll(new KeyFrame(Duration.millis(60),e ->
        {

            temp.setY(temp.getY()+10);
            temp.setX(temp.getX()+new Random().nextInt(20)-10);
            if (temp.getY()>HEIGH)
            {
                animation2.stop();
                fruits_leafs.getChildren().removeAll(temp);
                return;
            }

        }));

        animation2.setCycleCount(200);
        animation2.play();

    }

    public void stop_game()
    {
        playTime.stop();
        
        game_pane.getChildren().removeAll(background, basket_pane, back, fruits_leafs, info);
        // game over 
    }
    
    
    
    //  Audioplayer settings
    Media media1 = new Media(new File("C:\\Users\\nidao\\Desktop\\01.mp3").toURI().toString());
    MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        Media media2 = new Media(new File("C:\\Users\\nidao\\Desktop\\02.mp3").toURI().toString());
    MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        Media media3 = new Media(new File("C:\\Users\\nidao\\Desktop\\03.mp3").toURI().toString());
    MediaPlayer mediaPlayer3 = new MediaPlayer(media3);
        Media media4 = new Media(new File("C:\\Users\\nidao\\Desktop\\04.mp3").toURI().toString());
    MediaPlayer mediaPlayer4 = new MediaPlayer(media4);
    
   //  choicebox for songs 
   private void getChoice(ChoiceBox<String> choiceBox){
        
      
        mediaPlayer1.stop();
        mediaPlayer2.stop();
        mediaPlayer3.stop();
        mediaPlayer4.stop();
        
        switch(choiceBox.getValue()){
            case "1" :
                mediaPlayer1.setAutoPlay(true);
                return ;
            case "2" :
                mediaPlayer2.setAutoPlay(true);
                return ;
            case "3" :
                mediaPlayer3.setAutoPlay(true);
                return ;
            case "4" :
                mediaPlayer4.setAutoPlay(true);
                return ;
                
        }
      
    }
  

}
