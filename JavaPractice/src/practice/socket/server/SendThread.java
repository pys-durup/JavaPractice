package practice.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 송신 스레드
 */
public class SendThread extends Thread {

    private Socket mSocket;

    @Override
    public void run() {//run 메소드 재정의
        super.run();

        try {
            //보낼 데이터를 System.in에서 받아오는 객체
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter sendWriter = new PrintWriter(mSocket.getOutputStream());
            String sendString;

            while (true) {
                // 키보드로부터 입력받은 데이터
                sendString = bufferedReader.readLine();

                // 입력받은 문자열 전송
                sendWriter.println(sendString);
                sendWriter.flush();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void setSocket(Socket mSocket) {
        this.mSocket = mSocket;
    }
}
