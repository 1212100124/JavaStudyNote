package Seriable;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jackie on 17-6-27.
 */
public class SerServer {
    public static void main(String args[]){
        (new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket ss = new ServerSocket(12345);
                    Socket s= ss.accept();
                    ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                    BlockTransferForNN btfn[] = (BlockTransferForNN[])ois.readObject();
                    System.out.println(btfn[0]+""+btfn[1]);
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        })).start();
    }
}
