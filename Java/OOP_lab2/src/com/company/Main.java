package com.company;
/***
 *
 * @autor Ekros
 */
public class Main {
    //С5 = 2; - C = A + B;
    //C7 = 3; - int;
    //C11 = 7; - 7	Обчислити суму найбільших елементів
    // в стовпцях матриці з непарними номерами та найменших
    // елементів в стовпцях матриці з парними номерами
    public static void main(String[] args) {
        int limit = 100;
        int m = 5, n = 5;
        int A[][] = new int[m][n]; //матрица А
        int B[][] = new int[m][n]; //матрица Б
        int C[][] = new int[m][n]; //матрица С

        //Заполняем матрицы А и Б рандомными значениями от 0 до 100
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                A[i][j] = (int)Math.round(Math.random() * limit);
                B[i][j] = (int)Math.round(Math.random() * limit);

                C[i][j] = A[i][j] + B[i][j]; //Сумируем элементы А и Б, записываем в С
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        int big = 0;
        int small = 0;
        boolean isx2 = true;
        /*Короче находим найбольшие и найменьшие элементы
         *в непарных и парныэ столбиках матрицы соотвецтвенно.
         *
         *Там же сумируем найбольшие и найменьшие элементы,
         *потом выводим на экран.
        */
        for(int i = 0; i < n; i++){
            int b = 0, c = limit*2;
            for(int j = 0; j < m; j++){
                if(isx2){
                    if(C[j][i] < c){
                        c = C[j][i];
                    }
                }else{
                    if(C[j][i] > b){
                        b = C[j][i];
                    }
                }
            }
            if(isx2) {
                small += c;
                isx2 = false;
            }else {
                big += b;
                isx2 = true;
            }

        }

        System.out.println("Big: " + big);
        System.out.println("Small: " + small);
    }
}
