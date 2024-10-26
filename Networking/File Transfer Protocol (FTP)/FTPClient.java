import java.io.*;
import java.net.*;

public class FTPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9876);
        FileInputStream fileIn = new FileInputStream("send_file.txt");
        OutputStream out = socket.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fileIn.read(buffer)) > 0) {
            out.write(buffer, 0, bytesRead);
        }
        fileIn.close();
        socket.close();
    }
}
