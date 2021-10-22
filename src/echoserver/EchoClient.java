package echoserver;
import java.net.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

class EchoClient{
    public static void main(String[] args){
        try {
            InputStream consoleInput = System.in;
            OutputStream serverOutput = System.out;

            Socket socket = new Socket("localhost", 3502);//connect to ServerSocket

            InputStream fromServer = socket.getInputStream();
            OutputStream toServer = socket.getOutputStream();

            int b = 0;
            while(true) {
                b = consoleInput.read();
                if(b == -1) {
                    socket.shutdownOutput();
                }
                toServer.write(b);
                serverOutput.write(fromServer.read());
            }


        } catch(Exception e){
            System.out.println(e);
         }
    }
}