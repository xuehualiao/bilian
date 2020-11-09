package jiagou.api;

import jiagou.connection.Connection;
import jiagou.protocol.Protocol;

/**
 * 给程序员提供API接口的类
 * API操作层
 */
public class Client {

    private Connection connection;

    public Client(String host,int port){
        connection = new Connection(host, port);
    }

    public String set(final String key, final String value) {
        connection.sendCommand(Protocol.Command.SET,SafeEncode.encode(key),SafeEncode.encode(value));
        return null;
    }

    public String get(final String key){
        connection.sendCommand(Protocol.Command.GET,SafeEncode.encode(key));
        return connection.getStatusReply();
    }

}
