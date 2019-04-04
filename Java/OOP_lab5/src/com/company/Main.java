package com.company;

import text.Line;
import text.Text;
import text.Word;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 * Ну... Это класс Main.
 *
 * @version 1.0 17 Фев 2019
 * @author Ekros
 * */
public class Main {

    public static void main(String[] args) {
        try {
            //получаем файл
            File file = new File(System.getProperty("user.dir") + "/src/files/text.txt");
            //открываем входной поток
            Scanner dis = new Scanner(new FileInputStream(file));
            String str = "";
            for (;dis.hasNext();){
                //считываем данные
                str += dis.nextLine() + "\n";
            }
            dis.close();

            Text text = new Text(str);
            System.out.println(text.get());
            text.removeAllExLast();
            System.out.println(text.get());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
