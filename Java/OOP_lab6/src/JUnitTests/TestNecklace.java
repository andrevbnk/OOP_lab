package JUnitTests;

import com.company.Necklace;
import gems.Stone;
import gems.precious.Diamond;
import gems.precious.Emerald;
import gems.precious.Ruby;
import gems.semiprecious.Chrysolite;
import gems.semiprecious.Garnet;
import gems.semiprecious.Topaz;

import java.util.ArrayList;

public class TestNecklace {
    Necklace necklace = new Necklace();

    private void rewrite(){
        necklace = new Necklace();
        necklace.add(new Diamond(2.5));
        necklace.add(new Emerald(1.7));
        necklace.add(new Ruby(0.9));
        necklace.add(new Topaz(3.1));
        necklace.add(new Garnet(2.1));
        necklace.add(new Chrysolite(0.3));
    }

    public void testGetNecklase(){
        rewrite();
        boolean isWork = true;
        ArrayList<Stone> arr = necklace.getNecklase();
        for(int i = 0; i < arr.size(); i++){
            if(!arr.get(i).equals(necklace.getNecklase().get(i))){
                isWork = false;
                break;
            }
        }
        out(isWork, "getNecklase");
    }
    public void testGetAllCarat(){
        rewrite();
        boolean isWork = true;
        double carat = 10.600000000000001;
        if(carat != necklace.getAllCarat()){
            isWork = false;
        }
        out(isWork, "getAllCarat");
    }

    public void testGetAllCost(){
        rewrite();
        boolean isWork = true;
        int cost = 17103;
        if(cost != necklace.getAllCost()){
            isWork = false;
        }
        out(isWork, "getAllCost");
    }




    private void out(boolean isWork, String methodName){
        if(isWork){
            System.out.println("Test Complete: " + methodName);
        }else{
            System.err.println("Test faild: " + methodName);
        }
    }
}
