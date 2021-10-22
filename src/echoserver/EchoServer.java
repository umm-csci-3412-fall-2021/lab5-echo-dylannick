package echoserver;
import java.net.*;
import java.io.*;

class EchoServer{
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(6013);//declare a new ServerSocket on port 3500
            Socket socket = null;  //open the ServerSocket to receive connections
            OutputStream toClient = null;
            InputStream fromClient = null;
            int b = -1;
            while(true) {
                    try {
                        socket = ss.accept();
                        toClient = socket.getOutputStream();
                        fromClient = socket.getInputStream();
                        b = 0;
                        System.out.println("Client connected. ");
                    } catch (IOException ex) {
                        System.out.println("Can't accept client connection. ");
                    }


                    while (b != -1) {
                        b = fromClient.read();
                        toClient.write(b);  //write the array
                    }

                    System.out.println("Client disconnected. ");
                    toClient.flush();

            }
    } catch (Exception e) {
        System.out.println(e);
    }
   }
 
}