package JUnitTests;

import com.company.Necklace;
import gems.Stone;
import gems.precious.Diamond;
import gems.precious.Emerald;
import gems.precious.Ruby;
import gems.semiprecious.Chrysolite;
import gems.semiprecious.Garnet;
import gems.semiprecious.Topaz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestNecklace extends Assert {
    Necklace necklace = new Necklace();
    @Before
    public void rewrite(){
        necklace = new Necklace();
        necklace.add(new Diamond(2.5));
        necklace.add(new Emerald(1.7));
        necklace.add(new Ruby(0.9));
        necklace.add(new Topaz(3.1));
        necklace.add(new Garnet(2.1));
        necklace.add(new Chrysolite(0.3));
    }
    @Test
    public void testGetNecklase(){
        boolean isWork = true;
        ArrayList<Stone> arr = necklace.getNecklase();
        for (int i = 0; i < arr.size(); i++){
            if(!arr.get(i).equals(necklace.getNecklase().get(i))){
                isWork = false;
                break;
            }
        }
        assertTrue(String.valueOf(isWork), true);

    }

    @Test
    public void testGetAllCarat(){
        boolean isWork = true;
        double carat = 10.600000000000001;
        if(carat != necklace.getAllCarat()){
            isWork = false;
        }
        assertTrue(String.valueOf(carat), true);

    }
    @Test
    public void testGetAllCost(){
        int cost = 17103;
        assertEquals(cost, necklace.getAllCost());

    }

}
