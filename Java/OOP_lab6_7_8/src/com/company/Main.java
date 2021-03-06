package com.company;

import JUnitTests.TestArr;
import JUnitTests.TestNecklace;
import collection.Arr;
import gems.precious.Diamond;
import gems.precious.Emerald;
import gems.precious.Ruby;
import gems.semiprecious.Chrysolite;
import gems.semiprecious.Garnet;
import gems.semiprecious.Topaz;

/**
 * Очередной класс Main.
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public class Main {

    public static void main(String[] args) {

        Arr<Necklace> test = new Arr<>();
        Arr<Necklace> arr = new Arr<>();

        //добавляем в ожерелье n камней
        int j = 0;
        for (int i = 0; i < 10; i++){
            Necklace necklace = new Necklace();
            switch (j){
                case 0:
                    necklace.add(new Diamond(rand(0.2, 2)));
                    break;
                case 1:
                    necklace.add(new Emerald(rand(0.2, 2)));
                    break;
                case 2:
                    necklace.add(new Ruby(rand(0.2, 2)));
                    break;
                case 3:
                    necklace.add(new Chrysolite(rand(0.2, 2)));
                    break;
                case 4:
                    necklace.add(new Garnet(rand(0.2, 2)));
                    break;
                case 5:
                    necklace.add(new Topaz(rand(0.2, 2)));
                    break;

            }
            j = (int)Math.round(rand(0, 5));
            arr.add(necklace);
            test.add(necklace);
        }

//        TestNecklace tn = new TestNecklace();
//        tn.testGetAllCarat();
//        tn.testGetNecklase();
//        tn.testGetAllCost();

        TestArr t = new TestArr();
        Arr<String> str = new Arr<>();
        String s = null;
            t.testIsEmptyAndSize();
            t.testAddAll();
            t.testContains();
            t.testContainsAll();
            t.testGet();
            t.testSet();
            t.testRemove();
            t.testRemoveAll();
            t.testRetainAll();
            t.testIterator();
            t.testListIterator();

    }
    /*
    * Возвращает рандомное число от min до max
    * */
    private static double rand(double min, double max){
        return Math.random() * (max - min) + min;
    }
}
