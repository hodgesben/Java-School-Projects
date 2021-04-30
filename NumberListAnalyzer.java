/***************************************************************
 * NumberListAnalyzer.java
 * Benjamin Hodges 
 *
 * This program reads in a users list of numbers and calculates 
 * the mean, variance, or standard deviation based on users request
 **************************************************************/

import javax.swing.*; // for JFrame & JLabel
import java.awt.*;    // for FlowLayout
import java.awt.event.*;
import java.util.*;

public class NumberListAnalyzer extends JFrame
{
  private static final int WIDTH = 300;
  private static final int HEIGHT = 200;;
  private JTextField numBoxString;   // user entered numbers
  private JButton meanButton = new JButton("mean");
  private JButton varianceButton = new JButton("variance");
  private JButton stdDeviationButton = new JButton("std deviation");
  private JLabel outPut;

  public NumberListAnalyzer()
  {
    setTitle("Number List Analyzer");
    setSize(WIDTH, HEIGHT);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    createContents();
    setVisible(true);
  } // end SimpleWindow constructor

  private void createContents()
  {
    JLabel instrutionPrompt = new JLabel("Enter a list of numbers " +
      "separated by spaces:");
    outPut = new JLabel();
    numBoxString = new JTextField(20);
    add(instrutionPrompt);
    add(numBoxString);
    add(meanButton);
    add(varianceButton);
    add(stdDeviationButton);
    add(outPut);
    meanButton.addActionListener(new Listener());
    varianceButton.addActionListener(new Listener());
    stdDeviationButton.addActionListener(new Listener());
  } // end createContents
  
  //*********************************************************
  
  // Calculates the mean with a passed in array
  
  private double calculateMean(ArrayList<Double> userNumbers)
  {
    double total = 0;
    
    for (int i=0; i<userNumbers.size(); i++)
    {
      total += userNumbers.get(i);
    }
    return total/userNumbers.size();
  } // end calculateMean
  
  //************************************************************
  
  // Calculates the variance with a passed in array
  
  private double calculateVariance(ArrayList<Double> userNumbers)
  {
    double mean = calculateMean(userNumbers);
    double variance = 0;
    
    for (int i=0; i<userNumbers.size(); i++)
    {
      variance += Math.pow((userNumbers.get(i) - mean), 2);  
    }
    variance = variance / userNumbers.size();
    return variance;
  } // end calculateVariance
  
  //************************************************************
  
  // Calculates the standard Deviation with a passed in array
  
  private double calculateStdDeviation(ArrayList<Double> userNumbers)
  {
    double variance = calculateVariance(userNumbers);
    return Math.sqrt(variance);
  }
  
  //************************************************************
  
  // Inner Class for event handling
  // Listener Class for the buttons Jmean, JVariance, and JSTDevition.
  
  private class Listener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // user numbers to be calculated
      ArrayList<Double> userNumbers = new ArrayList<>();  
      Scanner strIn;          // user entered list of numbers
      double StdDeviation;    // Standard Deviation
      double variance;        // variance calculation
      double mean;            // mean calculation
      
      strIn = new Scanner(numBoxString.getText());
      
      while (strIn.hasNextDouble())
      {
        userNumbers.add(strIn.nextDouble());
      }
      
      if (e.getSource() == meanButton)
      {
        mean = calculateMean(userNumbers);
        outPut.setText("mean" + userNumbers + " = " + mean);
      }
      else if (e.getSource() == varianceButton)
      {
        variance = calculateVariance(userNumbers);
        outPut.setText("variance" + userNumbers + "=" + variance);
      }
      else if (e.getSource() == stdDeviationButton)
      {
        StdDeviation = calculateStdDeviation(userNumbers);
        outPut.setText("stdDev" + userNumbers + "=" + StdDeviation);
      }
    } // end actionPerformed
  } // end class Listener

  public static void main(String[] args)
  {
    new NumberListAnalyzer();
  } // end main
} // end class NumberListAnalyzer
