package practice.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) {
        final int PORT = 8000;

        // 서버 소켓 포트번호 8000에 바인딩
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // 연결 수신
                Socket socket = serverSocket.accept();

                // Socket 객체가 반환 되면(연결 되면) InputStream을 사용해서 데이터를 읽어올 수 있다
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                System.out.println("##### msg : " + reader.readLine());

                // Socket과 연결 된 클라이언트에게 OutputStream을 사용해서 데이터를 보낸다
                System.out.println("[ "+socket.getInetAddress()+" ] client connected");
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println(new Date().toString());

                socket.close();
            }

        } catch (IOException exception) {
            System.out.println("Server exception : " + exception.getMessage());
            exception.printStackTrace();
        }

    }
}
