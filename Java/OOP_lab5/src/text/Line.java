package text;

import java.util.Vector;

/**
 * Класс Line - хранит строку,
 * разбивая её на слова и символы.
 * @see     text.Word
 * @see     Letter
 *
 * @version 1.0 17 Фев 2019
 * @author Ekros
 * */
public class Line extends Type {
    public Line(String line){
        words = new Vector<>();
        changeLine(line);
    }

    private String sumb = " .,?!-+=_)(*&:^%;$#@~`:\\|\"'";
    private Vector<Type> words;        //массив слов и символов

    /*
    * Метод changeLine разбивает предложение
    * на слова и символы, записывая их в массивы.
    * */
    public void changeLine(String newLine){
        String word = "";
        String sumbol = "";
        boolean isSumb = false;
        for (int i = 0; i < newLine.length(); i++){

            for (int j = 0; j < sumb.length(); j++){

                if(newLine.charAt(i) == sumb.charAt(j)){
                    if(!sumbol.isEmpty()){
                        if(sumbol.charAt(sumbol.length()-1) == newLine.charAt(i)){
                            sumbol+=newLine.charAt(i);
                        }else{
                            words.add(new Word(word));
                            words.add(new Sumbol(sumbol));
                            word = "";
                            sumbol = "";
                            sumbol+=newLine.charAt(i);
                        }
                    }else {
                        sumbol += newLine.charAt(i);
                    }
                    isSumb = true;
                    break;
                }

            }
            if(!isSumb) {
                word += newLine.charAt(i);
                if(!sumbol.isEmpty()){
                    words.add(new Sumbol(sumbol));
                    sumbol = "";
                }
            }else {
                if(!word.isEmpty()) {
                    words.add(new Word(word));
                    word = "";
                }
                isSumb = false;
            }


        }
        words.add(new Word(word));
        words.add(new Sumbol(sumbol));
    }

    /*
    * Собирает и возвращает предложение(строку).
    * */
    @Override
    public String get(){
        String str = "";

        for(Type t: words){
            str += t.get();
        }
        return str;
    }
    /**
     * @see Type (getType)
     * */
    @Override
    public int getType() {
        return LINE;
    }

    /*
    * Возвращает массив слов
    * */
    public Vector<Type> getWords(){
        return words;
    }

}

