package ClassLoad;

/**
 * Created by jackie on 17-6-23.
 */
class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public final static int count1;
    public static int count2 = 0;

    static{
        count1=1;
    }

    private SingleTon() {
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}


class TT{
    public static final int ss =1;
    public static int n;
    static {
        System.out.println("henqi"+n);
    }
    public final static void print(){
        System.out.println("sb");
    }
}
public class Test {
    public static void main(String[] args) {
//        SingleTon singleTon = SingleTon.getInstance();
//        System.out.println("count1=" + singleTon.count1);  //1
//        System.out.println("count2=" + singleTon.count2);  //0
        System.out.println(TT.ss);
        new TT();
        //TT.print();
        //TT.print();
    }
}