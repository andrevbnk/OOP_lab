package gems.semiprecious;

import gems.SemipreciousStone;
/**
 * Chrysolite - класс описывающий хризолит.
 *
 * @see gems.SemipreciousStone
 * @see gems.Stone;
 *
 * @author Ekros
 * @version 1.0 23.02.2019
 * */
public class Chrysolite extends SemipreciousStone {
    public Chrysolite(double carat){
        name = "Chrysolite";
        costForCarat = 240;
        transparency = TRANSLUCENT;
        this.carat = carat;
        calculateCost();
    }
}
