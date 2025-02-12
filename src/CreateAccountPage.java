import java.awt.event.*;
import javax.swing.JFrame;

public class CreateAccountPage extends panel implements ActionListener {
    JFrame frame;
    public CreateAccountPage(JFrame superFrame){
        frame = superFrame;
        this.setUserLabel("User", 10, 20, 80, 25);
        this.setUserText(20, 100, 20, 165, 25);
        this.setPasswordLabel("Password", 10, 60, 80, 25);
        this.setPasswordText(20, 100, 60, 165, 25);
        this.setButton("Create Account", 10, 100, 255, 50, this);
        this.setSwitchPageButton("Go To Login Page", 10, 150, 255, 25, this);
        this.setnotificationLabel(null, 10, 200, 255, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            String username = userText.getText();
            String password = String.valueOf(passwordText.getPassword());
            
            //If the username does not exist in the HashMap, we add it to the HashMap with its password and write it to the file.
            if(!Username_And_Password.containsKey(username)){
                Username_And_Password.put(username, password);
                try{
                    FileIO.writeInside_The_File(Username_And_Password,username,password);
                }
                catch(Exception exp){
                    exp.printStackTrace();
                }

                notificationLabel.setText("Account created!");  
            }
            else{
                notificationLabel.setText("This username has already been used");
                userText.setText(null);
            }

        }
        else if(e.getSource() == switchPageButton){
            loginPage newLoginPage = new loginPage(frame);
            frame.add(newLoginPage.thisPanel);

            this.thisPanel.setVisible(false);
            frame.remove(this.thisPanel);
            frame.revalidate();
            frame.repaint();
        }
    }

}
