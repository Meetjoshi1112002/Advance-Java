import java.net.*;
import java.io.*;

class server {

public static void main(String args[])throws Exception {
		ServerSocket s = new ServerSocket(777);
		Socket i = s.accept();
		BufferedReader b = new BufferedReader(new InputStreamReader(i.getInputStream()));
		String str = b.readLine();
		str = str.toUpperCase();
		PrintStream p = new PrintStream(i.getOutputStream());
		p.println(str);
		System.out.println(str);
		p.close();
		s.close();
		i.close();
		b.close();
	}
}
