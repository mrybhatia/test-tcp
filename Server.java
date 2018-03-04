import java.io.*;
import java.net.*;
 
public class Server
{
 
    private static Socket socket;
 
    public static void main(String[] args)
    {
        try
        {
 
            int port = 9090;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 9090");
 
            
            while(true)
            {
                
                socket = serverSocket.accept();
				System.out.println("Connected");
                DataInputStream in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
 
            String line = "";
 
            
				while (!line.equalsIgnoreCase("END"))
				{
					try
					{
						line = in.readUTF();
						System.out.println(line);
						OutputStream os = socket.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					BufferedWriter bw = new BufferedWriter(osw);
					bw.write(line);
					System.out.println("Message sent to the client is "+line);
					bw.flush();
	 
					}
					catch(IOException i)
					{
						System.out.println(i);
					}
				}
 
			}   
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch(Exception e){}
        }
    }
}