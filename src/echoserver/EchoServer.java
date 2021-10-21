package echoserver;
import java.net.*;
import java.io.*;

class EchoServer{
    public static void main(String[] args){
        try {

            ServerSocket ss = new ServerSocket(3501);//declare a new ServerSocket on port 3500
            Socket socket = ss.accept();  //open the ServerSocket to receive connections
            OutputStream toClient = socket.getOutputStream();
            InputStream fromClient = socket.getInputStream();  //generate an outputstream from the Socket

            int b = 0;
            while(b != -1){
                b = fromClient.read();
                System.out.println("byte: " + b);
                toClient.write(b);  //write the array
            }

            toClient.flush();

        }catch(Exception e){
             System.out.println(e);
         }
   }
 
}