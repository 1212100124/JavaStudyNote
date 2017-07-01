package Collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by jackie on 17-6-5.
 */
public class VectorTest {
    public static void main(String args[]){
        Vector<String> s = new Vector<>();
        s.add("jackie");
        s.add("mike");
        s.add("nancy");
        Iterator it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        s.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.compareTo(o2)>0){
                    return -1;
                }
                else if(o1.compareTo(o2)<0){
                    return 1;
                }
                return 0;
            }
        });
        it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        s.remove("jackie");
        it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
