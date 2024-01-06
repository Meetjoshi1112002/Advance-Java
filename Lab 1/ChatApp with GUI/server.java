import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class server extends JFrame implements ActionListener {
    JList<String> display;
    DefaultListModel<String> d;
    JTextField input_text;
    JButton send;
    Socket i;
    JPanel pan;
    PrintStream p ;
    BufferedReader b;
    ServerSocket s;
    server()throws Exception{
        super("Server");
        s = new ServerSocket(777);
        i = s.accept();
        d = new DefaultListModel<>();
        pan = new JPanel(new BorderLayout());
        display = new JList<>(d);
        p = new PrintStream(i.getOutputStream());
        b = new BufferedReader(new InputStreamReader(i.getInputStream()));
        input_text = new JTextField();
        send = new JButton("Send");
        pan.add(input_text,BorderLayout.CENTER);        
        pan.add(send,BorderLayout.EAST);
        add(display);
        add(pan);
        send.addActionListener(this);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        setSize(500,700);
        String temp2 = b.readLine();
        d.addElement(temp2);
    }
    public void actionPerformed(ActionEvent e) {
        try{
            String temp = input_text.getText();
            input_text.setText(" ");
            p.println(temp);
            d.addElement(temp);
            String temp2 = b.readLine();
            d.addElement(temp2);
        }catch(Exception a){
            System.out.println(a);
        }
    }
    public static void main(String[] args)throws Exception {
        new server();
    }
}