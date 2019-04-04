package gems;
/**
 * Класс Stone(abstract) - описывает
 * драгоценный или полудрагоценный
 * камень.
 *
 * @autor Ekros
 * @version 1.0 23.02.2019
 * */
public abstract class Stone {
    //типы прозрачности
    protected static final int TRANSPARENT = 0;
    protected static final int TRANSLUCENT = 1;
    protected static final int OPAQUE = 2;

    protected String name;        //название камня
    protected double carat;       //вес камня
    protected double cost;        //стоимость камня
    protected int costForCarat;   //стоимость за 1 карат
    protected int transparency;   //прозрачность

    protected double getMass(){
        return carat;
    }
    public double getCost(){
        return cost;
    }
    public int getCostForCarat(){
        return costForCarat;
    }

    /*
    * Высчитывает стоимость камня
    * исходя из веса и стоимости
    * за 1 карат.
    * */
    protected void calculateCost(){
        cost = carat*costForCarat;
    }
    public void setCarat(double carat){
        this.carat = carat;
        calculateCost();
    }
    public int getTransparency(){
        return transparency;
    }
    public double getCarat(){
        return carat;
    }
    public String getName(){
        return name;
    }


}
