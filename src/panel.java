import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class panel {
    //We create our frame elements outside the constructor and methods so that we can access them from other classes and methods.
    //And we make them protected so that they can be accessed from ingherited classes.
    public JPanel thisPanel;
    protected JButton button;
    protected JButton switchPageButton;
    protected JLabel userLabel;
    protected JTextField userText;
    protected JLabel passwordLabel;
    protected JPasswordField passwordText;
    protected JLabel notificationLabel;
    protected static Map<String, String> Username_And_Password = new HashMap<>();

    public panel(){
        try{
            //First thing when a page is created is to read the file and update the HashMap
            FileIO.writeInside_The_HashMap(Username_And_Password);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        thisPanel = new JPanel();
        thisPanel.setLayout(null);
    }

    //These are the methods that will be used to create the elements of the page.
    //All of them takes some parameters to set the properties of the elements from inherited classes.
    public void setUserLabel(String labelName, int x, int y, int width, int height){
        userLabel = new JLabel(labelName);
        userLabel.setBounds(x, y, width, height);
        thisPanel.add(userLabel);
    }

    public void setUserText(int maxSize, int x, int y, int width, int height){
        userText = new JTextField(maxSize);
        userText.setBounds(x, y, width, height);
        thisPanel.add(userText);
    }

    public void setPasswordLabel(String labelName, int x, int y, int width, int height){
        passwordLabel = new JLabel(labelName);
        passwordLabel.setBounds(x, y, width, height);
        thisPanel.add(passwordLabel);
    }

    public void setPasswordText(int maxSize, int x, int y, int width, int height){
        passwordText = new JPasswordField(maxSize);
        passwordText.setBounds(x, y, width, height);
        thisPanel.add(passwordText);
    }

    public void setButton(String buttonName, int x, int y, int width, int height, ActionListener a){
        button = new JButton(buttonName);
        button.setBounds(x, y, width, height);
        button.addActionListener(a);
        thisPanel.add(button);
    }
    public void setSwitchPageButton(String buttonName, int x, int y, int width, int height, ActionListener a){
        switchPageButton = new JButton(buttonName);
        switchPageButton.setBounds(x, y, width, height);
        switchPageButton.addActionListener(a);
        thisPanel.add(switchPageButton);
    }
    public void setnotificationLabel(String notificationString, int x, int y, int width, int height){
        notificationLabel = new JLabel(notificationString);
        notificationLabel.setBounds(x, y, width, height);
        thisPanel.add(notificationLabel);
    }

}
