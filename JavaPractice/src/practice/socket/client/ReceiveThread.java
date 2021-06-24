package practice.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {

    private Socket socket;

    @Override
    public void run() {
        super.run();

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String receiveString;

            while (true) {
                receiveString = bufferedReader.readLine();

                System.out.println("user : " + receiveString);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
