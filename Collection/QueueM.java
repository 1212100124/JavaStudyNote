package Collection;

import java.io.Serializable;

/**
 * Created by jackie on 17-6-5.
 */
public class QueueM<T> implements Cloneable,Serializable{
    // head pointer
    private int first;
    // tail pointer
    private int last;
    // elementa size
    private int size;

    private double factor;

    private Object [] elementdata;

    private final static int initNumber = 10;

    private int capability;
    public QueueM(){
        elementdata = new Object[initNumber];
        capability = initNumber;
        first = 0;
        last = 0;
        factor = 0.75;
    }

    public QueueM(int factor){
        this();
        this.factor =factor;
    }

    public void push(T data){
        if(last-first>capability*factor){
            ensureCapability(true);
        }
        if(last>=capability){
            ensureCapability(false);
        }
        elementdata[last++] = data;
    }

    public void ensureCapability(boolean Dou){
        Object[] newele;
        if(Dou) {
             newele = new Object[capability << 1];
        }
        else{
            newele = new Object[capability];
        }
       System.arraycopy(elementdata,first,newele,0,last-first);
       elementdata = newele;
       capability = capability<<1;
       first = 0;
       last=last-first;
    }
    public  T pop(){
        if(last==first) return null;
        return (T)elementdata[first++];
    }
}
