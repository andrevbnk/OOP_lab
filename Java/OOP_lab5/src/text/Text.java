package text;

import java.util.Vector;

/**
 * Класс Text - класс для хранения текста.
 * Текст разбивается на предложения, которые
 * записываются в класс-коллекцию Vector.
 * Предложения разбиваются на слова,
 * а слова на символы.
 * @see     text.Line
 * @see     text.Word
 * @see     Letter
 *
 * @version 1.0 17 Фев 2019
 * @author Ekros
 * */
public class Text extends Type{
    public Text(String text){
        lines = new Vector<>();
        changeText(text);
    }

    private Vector<Line> lines;
    private String sumb = ".?!;";
    private boolean isAdd = false;

    /*
    * Раскладывает передаваемый текст на предложения,
    * которые записываются в класс-колекцию - Vector,
    * или проще говоря в динамический массив.
    * */
    public void changeText(String text){
        String line = "";
        for (int i = 0; i < text.length(); i++){
            for (int j = 0; j < sumb.length(); j++){
                if(text.charAt(i) == sumb.charAt(j)){
                    line += text.charAt(i);
                    lines.add(new Line(line));
                    line = "";
                    isAdd = true;
                    break;
                }
            }

            if(!isAdd){
                line += text.charAt(i);
            }else{
                isAdd = false;
            }
        }
    }

    /*
    * Метод get возвращает текс.
    * Довольно просто)
    * */
    @Override
    public String get(){
        String text = "";
        for (Line line : lines) {
            text += line.get();
        }
        return text;
    }

    /*
    * Возвращает массив предложений
    * */
    public Vector<Line> getLines(){
        return lines;
    }
    /**
     * Удаляет все буквы из каждого слова(кроме последней) которые == последней.
     * */
    public void removeAllExLast(){
        for(Line l: lines){
            for(Type t: l.getWords()){
                if(t.getType() == WORD){
                    Word w = (Word) t;
                    Vector<Letter> remove = new Vector<>();
                    for(Letter letter: w.getLetters()){
                        if(letter.ch == w.getLetters().get(w.getLetters().size() - 1).ch){
                            remove.add(letter);
                        }
                    }
                    for(int i = 0; i < remove.size() - 1; i++){
                        w.getLetters().remove(remove.get(i));
                    }
                }
            }
        }
    }
    /**
     * @see Type (getType)
     * */
    @Override
    protected int getType() {
        return TEXT;
    }
}
