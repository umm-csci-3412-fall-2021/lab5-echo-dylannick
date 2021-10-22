package echoserver;
import java.net.*;
import java.io.*;

class EchoServer{
    public static void main(String[] args){
        while(true) {
            try {
                ServerSocket ss = new ServerSocket(3502);//declare a new ServerSocket on port 3500
                Socket socket = null;  //open the ServerSocket to receive connections
                OutputStream toClient = null;
                InputStream fromClient = null;
                int b = 0;

                try {
                    socket = ss.accept();
                    toClient = socket.getOutputStream();
                    fromClient = socket.getInputStream();
                    b = 0;
                    System.out.println("Client connected. ");
                } catch (IOException ex) {
                    //System.out.println("Can't accept client connection. ");
                }


                while (b != -1) {
                    b = fromClient.read();
                    if(b == -1) {
                        System.out.println("Client disconnected. ");
                        toClient.flush();
                    }
                    toClient.write(b);  //write the array
                }
            } catch (Exception e) {
                // System.out.println(e);
            }
        }
   }
 
}