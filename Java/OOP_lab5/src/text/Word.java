package text;

import java.util.Vector;

/**
 * Класс Word - класс описывает слово
 * Полученное слово раскладывается на символы
 * и записывается в массив.
 * @see     Letter
 *
 * @version 1.0 17 Фев 2019
 * @author Ekros
 *
 * */
public class Word extends Type{
    public Word(String word){
        changeWord(word);
    }

    private Vector<Letter> letters; //массив символов

    /*
    * Возвращает слово.
    *
    * */
    public String get(){
        String str = "";

        for (Letter letter : letters) {
            str += letter.ch;
        }

        return str;
    }
    /**
     * @see Type (getType)
     * */
    @Override
    public int getType() {
        return WORD;
    }

    /*
    * Метод раскладывает полученное слово на символы,
    * и записывает в массив letters.
    * */
    public void changeWord(String newWord){
        String w = "";

        for (int i = 0; i < newWord.length(); i++){
            if(String.valueOf(newWord.charAt(i)).equals(" ")){
                break;
            }else{
                w += newWord.charAt(i);
            }
        }

        letters = new Vector<>();

        for (int i = 0; i < w.length(); i++){
            letters.add(new Letter(w.charAt(i)));
        }
    }
    public Vector<Letter> getLetters(){
        return letters;
    }


}
