package gems.precious;

import gems.Gem;
/**
 * Ruby - класс описывающий рубин.
 *
 * @see gems.Gem
 * @see gems.Stone;
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public class Ruby extends Gem {
    public Ruby(double carat){
        name = "Ruby";
        costForCarat = 2523;
        transparency = TRANSLUCENT;
        this.carat = carat;
        calculateCost();
    }
}
