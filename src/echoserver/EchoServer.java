package echoserver;
import java.net.*;
import java.io.*;

class EchoServer{
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(6013);
            Socket socket = null;
            OutputStream toClient = null;
            InputStream fromClient = null;
            byte[] buffer = new byte[4096];
            int bytesRead;

            while(true) {
                    try {
                        socket = ss.accept();
                        toClient = socket.getOutputStream();
                        fromClient = socket.getInputStream();
                        System.out.println("Client connected. ");
                    } catch (IOException ex) {
                        System.out.println("Can't accept client connection. ");
                    }


                    while ((bytesRead = fromClient.read(buffer)) != -1) {
                        toClient.write(buffer, 0, bytesRead);
                        toClient.flush();
                    }

                    System.out.println("Client disconnected. ");
                    socket.shutdownOutput();

            }
    } catch (Exception e) {
        System.out.println(e);
    }
   }
 
}