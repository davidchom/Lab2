package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Application extends JFrame{

    Map<String, String> map = new HashMap<>();

    JPanel panel;
    JTextField tID;
    JLabel lPassword, lID;
    JButton bLogin, bCancel;
    JPasswordField tPassword;


    public String gettPassword() {
        String password = "";
        char[] pass = tPassword.getPassword();
        for(int i=0; i<pass.length; i++){
            password += pass[i];
        }
        return password;
    }

    public Application(){

        map.put("Witold", "3Wspanialy");
        map.put("Wilfred", "Leon");
        map.put("Ambroży", "brożka");
        map.put("Pantalejmon", "nomjelatnaP");
        map.put("Kunegunda", "1234qwer");
        map.put("Anastazja", "admin123");
        map.put("Barbara", "BarbarkaToMojeImie");

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Logowanie do systemu");
        this.setVisible(true);


        panel = new JPanel(null);
        panel.setBackground(Color.GRAY);
        add(panel);


        lID = new JLabel("User:");
        panel.add(lID);
        lID.setBounds(40, 20, 60, 20);


        tID = new JTextField("");
        panel.add(tID);
        tID.setBounds(120, 20, 100, 30);


        lPassword = new JLabel("Password:");
        panel.add(lPassword);
        lPassword.setBounds(40,70,60,20);


        tPassword = new JPasswordField();
        panel.add(tPassword);
        tPassword.setBounds(120, 70, 100, 30);
        tPassword.setEchoChar('X');


        bLogin = new JButton("Login");
        panel.add(bLogin);
        bLogin.setBounds(40, 120, 70, 40);
        bLogin.addActionListener(e -> doWork());


        bCancel = new JButton("Cancel");
        panel.add(bCancel);
        bCancel.setBounds(120, 120, 100, 40);
        bCancel.addActionListener(e -> closeButton());


    }

    public void doWork(){
        if(map.containsKey(tID.getText())){
            String password = map.get(tID.getText());
            if(password.equals(gettPassword()))
                panel.setBackground(Color.GREEN);
            else
                panel.setBackground(Color.RED);
        }
        else
            panel.setBackground(Color.RED);
    }

    public void closeButton(){
        tID.setText("");
        tPassword.setText("");
        panel.setBackground(Color.GRAY);
    }

    public static void main(String[] args) {
        new Application();
    }
}
