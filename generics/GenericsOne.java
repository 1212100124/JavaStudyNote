package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jackie on 17-5-22.
 */
public class GenericsOne {
    public static void main(String args[]) {
        List<Integer> ls = new LinkedList<Integer>();
        ls.add(new Integer(1));
        Integer a = ls.iterator().next();
        System.out.println(a);
    }
}
