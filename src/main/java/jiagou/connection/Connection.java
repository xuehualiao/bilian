package jiagou.connection;

import jiagou.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connection {

    private Socket socket;
    private String host;
    private int port;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Connection() {
    }

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 连接之后发送数据
     * @return
     */
    public Connection sendCommand(Protocol.Command command,byte[]... args){
        connect();
        Protocol.sendCommand(outputStream,command,args);
        return this;
    };

    public void connect(){
        if (isConnected()){
            return;
        }
        try {
            socket = new Socket(host,port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return socket != null && socket.isBound() && !socket.isClosed() && socket.isConnected()
                && !socket.isInputShutdown() && !socket.isOutputShutdown();
    }

    public String getStatusReply(){

        byte[] bytes = new byte[1024];
        try {
            socket.getInputStream().read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

}
