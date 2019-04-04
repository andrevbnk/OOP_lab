package gems.precious;

import gems.Gem;
/**
 * Emerald - класс описывающий изумруд.
 *
 * @see gems.Gem
 * @see gems.Stone;
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public class Emerald extends Gem {
    public Emerald(double carat){
        name = "Emerald";
        costForCarat = 1794;
        transparency = TRANSLUCENT;
        this.carat = carat;
        calculateCost();
    }
}
