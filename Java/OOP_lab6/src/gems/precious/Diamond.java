package gems.precious;

import gems.Gem;
/**
 * Diamond - класс описывающий алмаз.
 *
 * @see gems.Gem
 * @see gems.Stone;
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public class Diamond extends Gem {
    public Diamond(double carat){
        name = "Diamond";
        costForCarat = 3672;
        transparency = TRANSPARENT;
        this.carat = carat;
        calculateCost();
    }
}
