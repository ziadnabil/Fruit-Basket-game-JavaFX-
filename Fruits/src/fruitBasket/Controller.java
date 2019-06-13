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
public class Controller {
    private int level=1,score=0,live=3;


    public int increaseLevel() {
        return ++level;
    }

    public int increaseScore() {
        return ++score;
    }

    public int decreaseLive() {
        return --live;
    }
    public boolean IsAlive(){
        return live>0;
    }
    public void reset()
    {
        this.live=3;
        this.level=1;
        this.score=0;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getLive() {
        return live;
    }
}
