import java.net.*;
import java.util.Scanner;
import java.io.*;
class chat_client{

	public static void main(String arg[])throws Exception{
		Socket i = new Socket("localhost",777);
		BufferedReader b = new BufferedReader(new InputStreamReader(i.getInputStream()));
		Scanner sc = new Scanner(System.in);
		PrintStream p = new PrintStream(i.getOutputStream());
		while (true) {
			String str = sc.nextLine();
			p.println(str);
			str = b.readLine();
			System.out.println(str);
			if(str.equals("End")){
				break;
			}
		}
		p.close();
		sc.close();
		b.close();
		i.close();
	}
	
}
