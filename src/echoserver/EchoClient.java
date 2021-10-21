package echoserver;
import java.net.*;
import java.io.*;

class EchoClient{
    public static void main(String[] args){
        try {


            Socket socket = new Socket("localhost", 3501);//connect to ServerSocket

            InputStream consoleInput = System.in;

            InputStream fromServer = socket.getInputStream();
            OutputStream toServer = socket.getOutputStream();  //generate InputStream from Socket

            toServer.write(consoleInput.read());  // Write what we input into the console directly to the server
            System.out.println(fromServer.read()); // Print the response from the server

            socket.close();

        } catch(Exception e){
            System.out.println(e);
         }
    }
}