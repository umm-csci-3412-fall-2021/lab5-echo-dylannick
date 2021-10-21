package echoserver;
import java.net.*;
import java.io.*;

class EchoClient{
    public static void main(String[] args){
        try{

            Socket s = new Socket("localhost", 3501);//connect to ServerSocket
            InputStream is = System.in;
            OutputStream os = s.getOutputStream();  //generate InputStream from Socket
            byte[] b = new byte[1];
            is.read(b);
            os.write(b);  //read byte array into array b
            System.out.println("byte 1: " + b[0]); //print what was received
            is.close();  //close everything
            s.close();

        }catch(Exception e){
            System.out.println(e);
         }
    }
}