package practice.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {
    public static void main(String[] args) {

//        String hostname = args[0];
        String hostname = "127.0.0.1";
//        int port = Integer.parseInt(args[1]);
        int port = 8000;

        for (int i = 0; i < 10; i++) {
            // socket 객체 생성 > 서버에 연결
            try (Socket socket = new Socket(hostname, port)) {

                // 서버에 보낼 데이터를 OutputStream 객체에 담는다
                OutputStream outputStream = socket.getOutputStream();
                String str = "This is woolbro dev Test";
                outputStream.write(str.getBytes());

                // 서버로 부터 읽을 데이터를 InputStream 객체에 가져온다
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String time = bufferedReader.readLine();

                System.out.println(time);


            } catch (UnknownHostException exception) {
                System.out.println("Server not found : " + exception.getMessage());
            } catch (IOException exception) {
                System.out.println("I/O error : " + exception.getMessage());
            }
        }
    }
}
