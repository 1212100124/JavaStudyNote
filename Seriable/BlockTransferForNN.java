package Seriable;

import java.io.Serializable;

/**
 * Created by jackie on 17-6-27.
 */
public class BlockTransferForNN implements Serializable {
    private static final long serialVersionUID = 1L;
    private String ipAddr;     // IP address
    private String hostName;   // hostname claimed by datanode
    private String datanodeUuid;
    private int xferPort;      // data streaming port
    private int infoPort;      // info server port
    private int infoSecurePort; // info server port
    private int ipcPort;       // IPC server port

    public BlockTransferForNN(String ipAddr,String hostName,String datanodeUuid,
                              int xferPort,int infoPort,int infoSecurePort,int ipcPort){
        this.ipAddr = ipAddr;
        this.hostName = hostName;
        this.datanodeUuid = datanodeUuid;
        this.xferPort = xferPort;
        this.infoPort = infoPort;
        this.infoSecurePort = infoSecurePort;
        this.ipcPort = ipcPort;
    }

    @Override
    public String toString() {
        return "ipAddr="+ ipAddr+"hostName= "+hostName+"datanodeUuid= "+datanodeUuid+"xferPort= "+xferPort+
                "infoPort "+infoPort+"infoSecurePort "+infoSecurePort+"ipcPort "+ipcPort;
    }

}
