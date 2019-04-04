package com.company;

import gems.Stone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Класс Necklace - описывает ожерелье
 * из драгоценных и полудрагоценных
 * камней. Так-же предоставляет методы
 * сортировки.
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 *
 * */
public class Necklace {
    public Necklace(){
        necklase = new ArrayList<>();
    }
    /**
     * Массив камней из которых состоит ожерелье.
     * @see Stone
     * */
    private ArrayList<Stone> necklase;
    private int max_carat = 2;

    /*Добавляет выбраный камень в ожерелье*/
    public void add(Stone stone){
        if(stone.getCarat() > 3.5){
            throw new NecklaceCaratException("Invalid number of carats: " + stone.getCarat(), stone.getCarat());
        }
        necklase.add(stone);
    }

    /*Удаление камня по индексу*/
    public void remove(int index){
        if(index < necklase.size()) {
            necklase.remove(index);
        }
    }

    /*Удаление камня по типу*/
    public void remove(Stone stone){
        if(necklase.contains(stone)){
            necklase.remove(stone);
        }
    }

    /*Сортировка камней по прозрачности*/
    public void sortForTransparency(boolean ascending){
        if(ascending){
            Collections.sort(necklase, Comparator.comparingInt(Stone::getTransparency));
        }else{
            Collections.sort(necklase, Comparator.comparingInt(Stone::getTransparency).reversed());
        }
    }

    /*Сортировка камней по стоимости*/
    public void sortForCost(boolean ascending){
        if(ascending){
            Collections.sort(necklase, Comparator.comparingDouble(Stone::getCost));
        }else{
            Collections.sort(necklase, Comparator.comparingDouble(Stone::getCost).reversed());
        }
    }

    /*Сортировка камней по весу*/
    public void sortForCarat(boolean ascending){
        if(ascending){
            Collections.sort(necklase, Comparator.comparingDouble(Stone::getCarat));
        }else{
            Collections.sort(necklase, Comparator.comparingDouble(Stone::getCarat).reversed());
        }

    }

    /*Возвращает сумарную стоимость камней*/
    public int getAllCost(){
        int cost = 0;
        for(Stone stone: necklase){
            cost += stone.getCost();
        }
        return cost;
    }
    public double getAllCarat(){
        double carat = 0;
        for(Stone stone: necklase){
            carat += stone.getCarat();

        }
        return carat;
    }
    /*Возвращает массив камней*/
    public ArrayList<Stone> getNecklase(){
        return necklase;
    }

    /*Вывод в консоль названия,
    * веса и стоимости каждого камня
    * */
    public void consoleOut(){
        for (Stone s: necklase){
            System.out.println(s.getName() + ": " + "Carat - " + String.valueOf(s.getCarat()).substring(0, 4)
                                                  + " Cost - " + Math.round(s.getCost()) + "$");
        }
    }

}

/**
 * Исключение выскакивает если пользователь
 * ввел количество карат > разрешонного.
 * */
class NecklaceCaratException extends RuntimeException {
    public NecklaceCaratException(String message, double carat){
        super(message);
        this.carat = carat;
    }
    private double carat;
    public double getCarat(){
        return carat;
    }
}