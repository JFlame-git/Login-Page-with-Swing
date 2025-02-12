import java.awt.event.*;

import javax.swing.JFrame;

public class loginPage extends panel implements ActionListener{
    JFrame frame;
    public loginPage(JFrame superFrame){
        //super() is used to call the constructor of the parent class.
        //But since we don't have a constructor in the parent class, we don't need to use it. As it is automatically called.
        frame = superFrame;
        this.setUserLabel("User", 10, 20, 80, 25);
        this.setUserText(20, 100, 20, 165, 25);
        this.setPasswordLabel("Password", 10, 60, 80, 25);
        this.setPasswordText(20, 100, 60, 165, 25);
        this.setButton("Login", 10, 100, 255, 50, this);
        this.setSwitchPageButton("Go To Create Account Page", 10, 150, 255, 25, this);
        this.setnotificationLabel(null, 10, 200, 255, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == button){
            //We check if the username exists in the HashMap
            //If it exists, we check if the password is correct
            //Depending on wheteher it is correct or not, we set the text of the notification label
            if(Username_And_Password.containsKey(userText.getText())){
                if(Username_And_Password.get(userText.getText()).equals(String.valueOf(passwordText.getPassword()))){
                    notificationLabel.setText("Successfully logged in");
                }
                else{
                    notificationLabel.setText("Password is incorrect");
                }
            }
            else{
                notificationLabel.setText("This username does not exist");
            }
       }
       else if(e.getSource() == switchPageButton){
            CreateAccountPage newcCreateAccountPage = new CreateAccountPage(frame);
            frame.add(newcCreateAccountPage.thisPanel);

            this.thisPanel.setVisible(false);
            frame.remove(this.thisPanel);
            frame.revalidate();
            frame.repaint();
       }
    }
}
