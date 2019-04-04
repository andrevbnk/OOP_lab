package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    	int size = 10;	//размер массива

	    SportEquipment[] sportEquip = new SportEquipment[size];

	    for (int i = 0; i < size; i++){
	    	//инициализация
	        sportEquip[i] = new SportEquipment();
	        sportEquip[i].setBasketBalls((int)Math.round(Math.random() * 20));
	        sportEquip[i].setDumbbells((int)Math.round(Math.random() * 20));
	        sportEquip[i].setJumpRope((int)Math.round(Math.random() * 20));
	        sportEquip[i].setSoccerBalls((int)Math.round(Math.random() * 20));
	        sportEquip[i].setBasketBalls((int)Math.round(Math.random() * 20));
	        sportEquip[i].setVolleyBalls((int)Math.round(Math.random() * 20));
        }

	    /*
	    * Сортировка массива по переменной basketBalls
	    * из класса SportEquipment
	    * (от большего к меньшему)
	    * */
        Arrays.sort(sportEquip, Comparator.comparingInt(SportEquipment::getBasketBalls).reversed());

	    for (int i = 0; i < size; i++){
	        System.out.print(sportEquip[i].getBasketBalls() + " ");
        }

	    System.out.println();

		/*
		 * Сортировка массива по переменной basketBalls
		 * из класса SportEquipment
		 * (от меньшего к большему)
		 * */
        Arrays.sort(sportEquip, Comparator.comparingInt(SportEquipment::getVolleyBalls));

        for (int i = 0; i < size; i++){
            System.out.print(sportEquip[i].getBasketBalls() + " ");
        }
    }
}
