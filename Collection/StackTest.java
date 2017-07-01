package Collection;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by jackie on 17-6-5.
 * Anyway, it's a Vector
 */
public class StackTest {
    public  static  void main(String args[]){
        Stack<String> s = new Stack();
        s.push("jackie");
        s.push("mike");
        Iterator it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
