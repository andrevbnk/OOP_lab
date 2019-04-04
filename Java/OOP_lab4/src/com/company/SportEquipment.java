package com.company;
/**
 *  Класс SportEquipment описывает
 *  спортивный инвентарь.
 *
 * @version 1.0 17 Фев 2019
 * @author Ekros
 *
 * */


public class SportEquipment {
    private int soccerBalls;
    private int basketBalls;
    private int volleyBalls;
    private int dumbbells;
    private int jumpRope;

    public int getSoccer_balls() {
        return soccerBalls;
    }

    public void setSoccerBalls(int soccer_balls) {
        this.soccerBalls = soccer_balls;
    }

    public int getBasketBalls() {
        return basketBalls;
    }

    public void setBasketBalls(int basket_balls) {
        this.basketBalls = basket_balls;
    }

    public int getVolleyBalls() {
        return volleyBalls;
    }

    public void setVolleyBalls(int volley_balls) {
        this.volleyBalls = volley_balls;
    }

    public int getDumbbells() {
        return dumbbells;
    }

    public void setDumbbells(int dumbbells) {
        this.dumbbells = dumbbells;
    }

    public int getJumpRope() {
        return jumpRope;
    }

    public void setJumpRope(int jump_rope) {
        this.jumpRope = jump_rope;
    }

}
