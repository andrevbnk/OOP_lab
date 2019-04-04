package gems.semiprecious;

import gems.SemipreciousStone;
/**
 * Topaz - класс описывающий топаз.
 *
 * @see gems.SemipreciousStone
 * @see gems.Stone;
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public class Topaz extends SemipreciousStone {
    public Topaz(double carat){
        name = "Topaz";
        costForCarat = 521;
        transparency = TRANSLUCENT;
        this.carat = carat;
        calculateCost();
    }
}
