package gems.semiprecious;

import gems.SemipreciousStone;
/**
 * Garnet - класс описывающий гранат.
 *
 * @see gems.SemipreciousStone
 * @see gems.Stone;
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public class Garnet extends SemipreciousStone {
    public Garnet(double carat){
        name = "Garnet";
        costForCarat = 437;
        transparency = OPAQUE;
        this.carat = carat;
        calculateCost();
    }
}
