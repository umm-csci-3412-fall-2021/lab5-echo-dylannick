package echoserver;
import java.net.*;
import java.io.*;

class EchoServer{
    public static void main(String[] args){
        try{

            ServerSocket ss = new ServerSocket(3501);//declare a new ServerSocket on port 3500
            Socket s = ss.accept( );  //open the ServerSocket to receive connections
            OutputStream os = s.getOutputStream( );
            InputStream is = s.getInputStream();  //generate an outputstream from the Socket
            // byte[] b = new byte[2];
            // b[0] = 1;
            // b[1] = 2;
            int b = 0;
            while(b != -1){
                b = is.read();
                System.out.println("byte 1: " + b);
                os.write(b);  //write the array
                os.close();   //close everything
    
            }
            
        }catch(Exception e){
             System.out.println(e);
         }
   }
 
}