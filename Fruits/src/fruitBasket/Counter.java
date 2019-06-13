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
public class Counter {
    private int lives=3 ,score=0;

    public boolean is_alive() {
        return lives>0;
    }

    public int add_score() {
        return score+1;
    }
    public int sub_lives(){
        return lives-1;
    }
}
