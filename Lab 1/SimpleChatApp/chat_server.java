import java.net.*;
import java.util.Scanner;
import java.io.*;
class chat_server{

	public static void main(String arg[])throws Exception{
		ServerSocket i = new ServerSocket(777);
		Socket s = i.accept();
		BufferedReader b = new BufferedReader(new InputStreamReader(s.getInputStream()));
		Scanner sc = new Scanner(System.in);
		PrintStream p = new PrintStream(s.getOutputStream());
		while (true) {
			String str = b.readLine();
			if(str.equals("End")){
				break;
			}
			System.out.println(str);
			str = sc.nextLine();
			p.println(str);
		}
		p.close();
		sc.close();
		b.close();
		i.close();
		s.close();
	}
	
}
