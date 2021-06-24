package practice.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {

    private Socket mSocket;

    @Override
    public void run() { // run 메소드 재정의
        super.run();

        try {
            // 소켓에서 데이터를 받아온다
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            String receiveString;

            while (true) {// 받은 데이터를 출력
                receiveString = bufferedReader.readLine();

                if (receiveString == null) {
                    System.out.println("상대방 연결이 끊겼습니다");
                    break;
                } else {
                    System.out.println("상대방 : " + receiveString);
                }
            }

            bufferedReader.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void setSocket(Socket mSocket) {
        this.mSocket = mSocket;
    }
}
