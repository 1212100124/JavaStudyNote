package Seriable;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by jackie on 17-6-27.
 */
public class SerClient {
    public static void main(String args[]){
        (new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket s = new Socket("192.168.1.33", 12345);
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    BlockTransferForNN btfn[] = new BlockTransferForNN[2];
                    btfn[0]=new BlockTransferForNN("0","0","0",0,0,0,0);
                    btfn[1]= new BlockTransferForNN("0","0","0",0,0,0,0);
                    oos.writeObject(btfn);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        })).start();
    }
}
