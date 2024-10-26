import java.io.*;
import java.net.*;

public class FTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9876);
        System.out.println("FTP Server started...");
        Socket clientSocket = serverSocket.accept();
        InputStream in = clientSocket.getInputStream();
        FileOutputStream fileOut = new FileOutputStream("received_file.txt");
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) > 0) {
            fileOut.write(buffer, 0, bytesRead);
        }
        fileOut.close();
        clientSocket.close();
    }
}
