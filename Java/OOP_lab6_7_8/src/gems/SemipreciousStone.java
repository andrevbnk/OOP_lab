package gems;
/**
 * Gem(abstract) - класс родитель
 * для классов описывающих драгоценные камни.
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public class SemipreciousStone extends Stone {
    //тип камня
    protected final String type = "Semiprecious";

    protected String getType(){
        return type;
    }
}
