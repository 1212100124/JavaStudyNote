/*
    This class used for ArrayList basic function test!
*/


import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by jackie on 17-5-25.
 */
public class ArrayListTest <T>{
    public static void main(String args[]){
        // 看源代码发现ArrayList里面竟然可以存放null,并且可以判断是否存在null
        System.out.println("Null Test:");
        List<String> ls =new ArrayList();
        ls.add(null);
        System.out.println("Test if can store null "+ls.contains(null));
        printline();



        // 不指代元素默认存储 Object , 源代码里定义了一个 Object数组
        System.out.println("This Object:");
        List test1 = new ArrayList();
        test1.add("234");
        test1.add(1);
        for(Object o : test1){
            System.out.println(o);
        }
        printline();


        // Test sort
        System.out.println("Sort Test");
        List<String> test2 = new ArrayList<>();
        test2.add("Mike");
        test2.add("Jackie");
        test2.add("Nancy");
        test2.add("Soga");
        printAll(test2);
        printline();
        test2.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("After Sort");
        printAll(test2);
        printline();
        test2.add(3,"GaGa");
        System.out.println("Add One element to List");
        printAll(test2);
        printline();

        //Remove one and turn List to Array, Then use array sort method
        System.out.println("Remove one and turn List to Array, Then use array sort method");
        test2.remove(3);
        for(Iterator<String> it=test2.iterator();it.hasNext();){
            System.out.println(it.next());
        }
        printline();
        System.out.println("Change it to array");
        Object str[] =test2.toArray();
        Arrays.sort(str);
        for(Object ss:str){
            System.out.println(ss);
        }
        printline();

        System.out.println("Clear all element");
        test2.clear();
        System.out.println(test2.size());
    }

    // print one line
    public static void printline(){
        System.out.println("----------------------------------");
    }

    //print all element in List
    public static void printAll(List<?> e){
        for(Object o:e){
            System.out.println(o);
        }
    }
}



//  Answer


/*
Null Test:
Test if can store null true
----------------------------------
This Object:
234
1
----------------------------------
Sort Test
Mike
Jackie
Nancy
Soga
----------------------------------
After Sort
Jackie
Mike
Nancy
Soga
----------------------------------
Add One element to List
Jackie
Mike
Nancy
GaGa
Soga
----------------------------------
Remove one and turn List to Array, Then use array sort method
Jackie
Mike
Nancy
Soga
----------------------------------
Change it to array
Jackie
Mike
Nancy
Soga
----------------------------------
Clear all element
0

*/