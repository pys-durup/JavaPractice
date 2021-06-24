package practice.socket.client;

import java.io.IOException;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {

        try {

            Socket cSocket = new Socket("127.0.0.1", 8888);

            ReceiveThread receiveThread = new ReceiveThread();
            receiveThread.setSocket(cSocket);

            SendThread sendThread = new SendThread();
            sendThread.setSocket(cSocket);

            receiveThread.start();
            sendThread.start();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
