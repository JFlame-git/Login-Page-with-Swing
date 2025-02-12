import java.awt.event.*;
import javax.swing.JFrame;

//Since MainMenuPage is a panel, we extend the panel class.
//And since we will use the ActionListener interface for the buttons, we implement it.

public class MainMenuPage extends panel implements ActionListener{

    //On each page we create a frame object and then equalize it to the frame object that is created in the GUI class.
    //So that we can change the properties of the frame (such as changing the current panel) from the inherited classes.
    JFrame frame;

    //We call the main frame object from the GUI class and equalize it to the main frame object (referenece). Like explained above
    public MainMenuPage(JFrame superFrame){
        frame = superFrame;
        //We set the properties of the elements of the page.
        //The ones whose method is not called will not be created on the page.
        this.setButton("Login Page", 10, 50, 255, 55, this);
        this.setSwitchPageButton("Create Account Page", 10, 150, 255, 55, this);
    }

    //Since we implement the ActionListener interface, we have to override the actionPerformed method.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){

            //This is how we switch between pages.
            //First we create a new page object and add it to the frame.
            //Then we remove the current page from the frame.
            
            loginPage newLoginPage = new loginPage(frame);
            frame.add(newLoginPage.thisPanel);
            
            this.thisPanel.setVisible(false);
            frame.remove(this.thisPanel);
            frame.revalidate();
            frame.repaint();

        }
        else if(e.getSource() == switchPageButton){
            CreateAccountPage newCreateAccountPage = new CreateAccountPage(frame);
            frame.add(newCreateAccountPage.thisPanel);

            this.thisPanel.setVisible(false);
            frame.remove(this.thisPanel);
            frame.revalidate();
            frame.repaint();
        }
    }

}
