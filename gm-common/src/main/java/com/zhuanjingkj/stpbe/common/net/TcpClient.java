package com.zhuanjingkj.stpbe.common.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
    public static byte[] sendRequest(String addr, short port, byte[] request) {
        Socket socket = null;
        int readLen = 0;
        byte[] data = new byte[1024];
        String resp = null;
        OutputStream outStrm = null;
        InputStream inStrm = null;
        try {
            socket = new Socket(addr, port);
            outStrm = socket.getOutputStream();
            outStrm.write(request);
            inStrm = socket.getInputStream();
            readLen = inStrm.read(data, 0, 1024);
            if (readLen > 0) {
                resp = new String(data, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outStrm != null) {
                    outStrm.close();
                }
                if (inStrm != null) {
                    inStrm.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (resp != null) {
            return resp.getBytes();
        } else {
            return null;
        }
    }
}
