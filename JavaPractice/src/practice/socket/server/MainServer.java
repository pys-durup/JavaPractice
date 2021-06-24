package practice.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        try {
            ServerSocket sSocket = new ServerSocket(8888);
            System.out.println("Server Start port : 8888");

            Socket cSocket = sSocket.accept();
            System.out.println("connection = " + cSocket.getInetAddress());

            // 수신스레드 생성, 소켓 전달
            ReceiveThread receiveThread = new ReceiveThread();
            receiveThread.setSocket(cSocket);

            // 송신스레드 생성, 소켓 전달
            SendThread sendThread = new SendThread();
            sendThread.setSocket(cSocket);

            receiveThread.start();
            sendThread.start();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
