package generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jackie on 17-5-24.
 */
public class TestForEarse {
    public static void main(String args[]){

        List<String>[] las = new List[10];
        Object[] oa = las;
        List li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1]= li;
        String s = las[1].get(0);

    }
}

class tt extends Pair<Date>{
    public void setFirst(Date first) {

    }
}
