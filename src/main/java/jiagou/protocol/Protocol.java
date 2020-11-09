package jiagou.protocol;

import java.io.IOException;
import java.io.OutputStream;

public class Protocol {
    public static final String DOLLOR_BYTE="$";
    public static final String ASTERISK_BYTE="*";
    public static final String BLANK_BYTE="\r\n";

    public static void sendCommand(OutputStream outputStream,Protocol.Command command, byte[]... b){
        StringBuffer stringBuffer = new StringBuffer();
        //数组三
        stringBuffer.append(ASTERISK_BYTE).append(b.length+1).append(BLANK_BYTE);
        //第一组三个 SET长度
        stringBuffer.append(DOLLOR_BYTE).append(command.name().length()).append(BLANK_BYTE);
        //第一组 "SET"
        stringBuffer.append(command).append(BLANK_BYTE);
        for (byte[] arg:b){
            //第二组长度
            stringBuffer.append(DOLLOR_BYTE).append(arg.length).append(BLANK_BYTE);
            //第二组字符串
            stringBuffer.append(new String(arg)).append(BLANK_BYTE);
        }
        byte[] bytes = stringBuffer.toString().getBytes();
        try {
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static enum Command{
        SET,GET

    }
}

