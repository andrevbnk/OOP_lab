package gems;
/**
 * Gem(abstract) - класс родитель
 * для классов описывающих драгоценные камни.
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public abstract class Gem extends Stone{
    //тип камня
    protected final String type = "Precious";

    protected String getType(){
        return type;
    }
}
