package text;
/**
 * Sumbol - класс для хранения символа.
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public class Sumbol extends Type{
    public Sumbol(String sumvol){
        change(sumvol);
    }
    private char[] sumvol;

    //изменить сивол
    public void change(String sumvol){
        this.sumvol = sumvol.toCharArray();
    }
    public String get(){
        String back = "";
        for(char c: sumvol){
            back += c;
        }
        return back;
    }
    /**
     * @see Type (getType)
     * */
    @Override
    public int getType() {
        return SUMBOL;
    }
}
