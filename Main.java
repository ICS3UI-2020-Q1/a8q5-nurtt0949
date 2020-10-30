import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Main implements Runnable, ActionListener{

  //create random number generator
  Random rand = new Random();
  // Class Variables  
  JPanel mainPanel;

  JLabel guessLabel;
  JLabel ansLabel;

  JTextField numInput;

  JButton submitButton;
  JButton resetButton;
  
  
  int randNum = rand.nextInt(100) + 1;
  

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    //initialize the mainJPanel
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);
    //create the labels
    guessLabel = new JLabel("Guess the number between 1 and 100:");
    ansLabel = new JLabel("");
    //layout the labels with their cordinates and size 
    guessLabel.setBounds(50,10,300,40);
    ansLabel.setBounds(50,100,300,20);
    //add labels to main panel
    mainPanel.add(guessLabel);
    mainPanel.add(ansLabel);
    //initialize the text fields
    numInput = new JTextField();
    //layout the text field with its cordinates and size
    numInput.setBounds(50,50,200,20);
    //add the text field to the main panel
    mainPanel.add(numInput);
    //initialize the buttons
    submitButton = new JButton("Submit");
    resetButton = new JButton("New Number");
    //layout the buttons with their cordinates and size
    submitButton.setBounds(50,70,100,20);
    resetButton.setBounds(180,70,150,20);
    //add action listener to buttons
    submitButton.addActionListener(this);
    resetButton.addActionListener(this);
    //add buttons to main panel
    mainPanel.add(submitButton);
    mainPanel.add(resetButton);
    //add main panel to the window
    frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    if(command.equals("Submit")){
      //get text from input box
      String firstText = numInput.getText();
      //convert string into integer
      int number = Integer.parseInt(firstText);
      int guess = number + 0;
     
      if(guess > randNum){
      ansLabel.setText("Your guess of " + guess + " is too high");
      }else if(guess < randNum){
        ansLabel.setText("Your guess of " + guess + " is too low");
      }
      if(guess == randNum){
        ansLabel.setText("Congratulations! You win!");
      }
    }
    if(command.equals("New Number")){
      //clear the text field
      numInput.setText("");
      ansLabel.setText("");
      //generate new random number
      randNum = rand.nextInt(100) + 1;
 
    }


  }
  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
