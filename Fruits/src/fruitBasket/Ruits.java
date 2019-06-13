/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitBasket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

/**
 *
 * @author nidao
 */
public class Ruits {
    private ArrayList<ImageView> fruits=new ArrayList<>();
    private Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

    public Ruits() throws FileNotFoundException
    {
        
        Image f11 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\1.png"));
        ImageView f1 = new ImageView(f11);
        Image f22 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\2.png"));
        ImageView f2 = new ImageView(f22);
        Image f33 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\3.png"));
        ImageView f3 = new ImageView(f33);
        Image f44 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\4.png"));
        ImageView f4 = new ImageView(f44);
        Image f55 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\5.png"));
        ImageView f5 = new ImageView(f55);
        Image f66 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\6.png"));
        ImageView f6 = new ImageView(f66);
        Image f77 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\7.png"));
        ImageView f7 = new ImageView(f77);
        Image f88 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\8.png"));
        ImageView f8 = new ImageView(f88);
        Image f99 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\9.png"));
        ImageView f9 = new ImageView(f99);
        Image f101 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\10.png"));
        ImageView f10 = new ImageView(f101);
        Image f1111 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\11.png"));
        ImageView f111 = new ImageView(f1111);
        Image f121 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\12.png"));
        ImageView f12 = new ImageView(f121);
        Image f131 = new Image(new FileInputStream("C:\\Users\\nidao\\Desktop\\13.png"));
        ImageView f13 = new ImageView(f131);
        fruits.add(f1);
        fruits.add(f2);
        fruits.add(f3);
        fruits.add(f4);
        fruits.add(f5);
        fruits.add(f6);
        fruits.add(f7);
        fruits.add(f8);
        fruits.add(f9);
        fruits.add(f10);
        fruits.add(f111);
        fruits.add(f12);
        fruits.add(f13);

    }
    public ImageView getFruit()
    {
        ImageView image=fruits.get((new Random().nextInt(12))+1);
        image.setY(-50);
        image.setX((new Random().nextInt((int)screenBounds.getWidth()-120))+20);


        return image;
    }
}

