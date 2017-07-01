package Collection;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jackie on 17-5-25.
 */
public class TestOfTreeSet {
    public  static  void main(String args[]){
        Set<NeedToCompare> ntc = new TreeSet<>();
        ntc.add(new NeedToCompare("jackie"));
        ntc.add(new NeedToCompare("hahaha"));
        ntc.add(new NeedToCompare("mike"));
        System.out.println("size = " + ntc.size());
        for(NeedToCompare nn:ntc){
            System.out.println(nn);
        }


        Set<NeedToCompare> newntc = new TreeSet<>(new Comparator<NeedToCompare>() {
            @Override
            public int compare(NeedToCompare o1, NeedToCompare o2) {
                return o2.getStr().compareTo(o1.getStr());
            }
        });

        newntc.addAll(ntc);


        Pair<Pair> p = new Pair<>();
        p.addAll(p);
    }
}


class NeedToCompare implements Comparable<NeedToCompare>{
    private String str;

    public NeedToCompare(String str){
        this.str= str;
    }

    @Override
    public int compareTo(NeedToCompare o) {
        return str.compareTo(o.str);
    }

    @Override
    public String toString() {
        return str;
    }

    public String getStr(){
        return str;
    }
}


class Pair<T>{
    public void addAll(Pair<? extends Pair> p){

    }
}
