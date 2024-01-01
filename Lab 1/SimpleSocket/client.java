import java.net.*;
import java.util.Scanner;
import java.io.*;

class client{
	
	public static void main(String args[]) throws Exception{

		Socket i = new Socket("localhost",777);
		PrintStream p = new PrintStream(i.getOutputStream());
		BufferedReader b = new BufferedReader(new InputStreamReader(i.getInputStream()));
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		p.println(s);
		s = b.readLine();
		System.out.println(s);
		sc.close();
		b.close();
		p.close();
		i.close();
	}

}
	
