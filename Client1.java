import java.io.*;
import java.net.*;
 
public class Client1
{
 
    private static Socket socket;
	
	private static String asciiToHex(String asciiStr) {
    char[] chars = asciiStr.toCharArray();
    StringBuilder hex = new StringBuilder();
    for (char ch : chars) {
        hex.append(Integer.toHexString((int) ch));
    }
 
    return hex.toString();
	}
 
    private static String hexToAscii(String hexStr) {
    StringBuilder output = new StringBuilder("");
     
    for (int i = 0; i < hexStr.length(); i += 2) {
        String str = hexStr.substring(i, i + 2);
        output.append((char) Integer.parseInt(str, 16));
    }
     
    return output.toString();
    }
	
    public static void main(String args[])
    {
        try
        {
            String host = "localhost";
            int port = 9090;
            socket = new Socket(host, port);
			DataInputStream  input   = new DataInputStream(System.in);
			DataOutputStream out     = new DataOutputStream(socket.getOutputStream());
			String line = "";
 
			
			while (!line.equalsIgnoreCase("END"))
			{
				try
				{
					line = input.readLine();
					out.writeUTF(asciiToHex(line));
				}
				catch(IOException i)
				{
					System.out.println(i);
				}
			}
			
            
			    String line1 = "";
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				 while (!line1.equalsIgnoreCase("END"))
				{
					try
					{
						line1 = br.readLine();
						System.out.println("Message received from the server : " +hexToAscii(line1));
					}
					catch(IOException i)
					{
						System.out.println(i);
					}
				}
			
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
       
    }
}