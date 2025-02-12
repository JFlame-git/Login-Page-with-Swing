import javax.swing.JFrame;

public class GUI{
    private JFrame frame;

    public GUI(String s){
        //We create a frame and set its properties
        frame = new JFrame(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        //We create a Main Menu Page and add it to the frame
        MainMenuPage mainMenu = new MainMenuPage(frame);
        frame.add(mainMenu.thisPanel);

        frame.setVisible(true);
    }

    public static void main(String[] args){
        //Since each class is linked to each other, it is enough to create an object from the GUI class to run the program
        new GUI("Account");
    }
}
