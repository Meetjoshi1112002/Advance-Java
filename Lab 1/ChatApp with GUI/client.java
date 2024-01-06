import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class client extends JFrame implements ActionListener {
    JList<String> display;
    DefaultListModel<String> d;
    JPanel pan;
    JTextField input_text;
    JButton send; 
    Socket i;
    PrintStream p ;
    BufferedReader b;
    String temp = "";
    client()throws Exception{
        super("CLIENT");
        i = new Socket("localhost",777);
        p = new PrintStream(i.getOutputStream());
        b = new BufferedReader(new InputStreamReader(i.getInputStream()));

        d = new DefaultListModel<>();
        display = new JList<>(d);

        pan = new JPanel();
        pan.setLayout(new BorderLayout());
        input_text = new JTextField();
        pan.add(input_text,BorderLayout.CENTER);
        send = new JButton("Send");
        pan.add(send,BorderLayout.EAST);
        add(display);
        add(pan);
        send.addActionListener(this);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        setSize(500,700);
    }
    public void actionPerformed(ActionEvent e) {
        try{
            String temp = input_text.getText();
            input_text.setText(" ");
            d.addElement(temp);
            p.println(temp);
            String temp1 = b.readLine();
            d.addElement(temp1);

        }catch(Exception a){
            System.out.println(a);
        }
    }
    public static void main(String[] args)throws Exception {
        new client();
    }
}