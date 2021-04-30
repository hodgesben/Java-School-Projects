/***************************************************************
* WhaleLengthCalculator.java
* Benjamin Hodges
* 
* This program calculates the length of the fluke of the whale
* and the total length of the whale in meters
****************************************************************/

import java.util.*;

public class WhaleLengthCalculator
{
  private double cameraLinearRegressionSlope; // Camera Linear Regression Slope
  private double cameraLinearYIntercept;      // Camera y intercept
  private double whaleLinearRegressionSlope;  // whales Linear Regression Slope
  private double whaleLinearYIntercept;       // Whales y intercept
  private double flukeSpan;                   // Length of the Whales Fluke
  private double totalWhaleLength;            // Calculated length of Whales Length
  private double cameraRange;                 // Camera Range
  private int cameraNumOfPixels;              // number of Pixels in camera
  Scanner stdIn = new Scanner(System.in);     // Scanner for input from user
  
  //************************************************************
  
  // Makes sure users entered number is valid entry or not
  
  public void linearRegressionForCamera()
  {
    this.cameraLinearRegressionSlope = positiveFloatingPointNumber(
      "Enter a positive decimal number for the camera's linear regression slope: ");
    
    this.cameraLinearYIntercept = floatingPointNumber(
      "Enter a decimal number for the camera's linear regression y intercept: ");
  } // end linearRegressionForCamera
  
  public void linearRegressionForLength()
  {
    this.whaleLinearRegressionSlope = positiveFloatingPointNumber("Enter "
      + "a positive decimal number for the whale length's linear regression slope: ");
    
    this.whaleLinearYIntercept = floatingPointNumber("Enter a decimal"
      + " number for the whale length's linear regression y intercept: ");
  } // end linearRegressionForLength
  
  public void promptForRange()
  {
    this.cameraRange = positiveFloatingPointNumber(
      "Enter a positive decimal number for the camera's range in meters: ");
  } // end promptForRange
  
  public void promptForPixels()
  {
    this.cameraNumOfPixels = checkIfPosInt(
      "Enter a positive integer for the number of pixels: ");
  } // end promptForPixels
  
  //************************************************************
  
  // checks if input from user is a valid double number
  
  private double floatingPointNumber(String prompt)
  {
   double rtnDouble = 0;    // return double value
   boolean valid = false;   // checks if valid input
   
   do
   {
     try
     {
       System.out.print(prompt);
       rtnDouble = stdIn.nextDouble();
       valid = true;
     }
     catch(InputMismatchException ime)
     {
       stdIn.next();
       System.out.println("Invalid entry.");
     }
   } while (!valid);
   
   return rtnDouble;  
  } // end checkIfRealNumber
  
  //************************************************************
  
  // checks if passed in value is positive
  
  private double positiveFloatingPointNumber(String prompt)
  {
    double rtnDouble = 0;    // return double value
    boolean valid = false;   // checks if valid input
    
    do
    {
      try
      {
        System.out.print(prompt);
        rtnDouble = stdIn.nextDouble();
        valid = true;
        if (rtnDouble <= 0)
        {
          valid = false;
          System.out.println("Invalid entry.");
        }
      }
      catch(InputMismatchException ime)
      {
        stdIn.next();
        System.out.println("Invalid entry.");
        rtnDouble = 0;
      }
    } while (!valid);
    
    return rtnDouble;
  } // end checkIfPositive
  
  //************************************************************
  
  // Checks if user entered value is positive and an Integer
  
  private int checkIfPosInt(String prompt)
  {
    int rtnInt = 0;         // return an Int value
    boolean valid = false;  // checks if valid input
    
    do
    {
      try
      {
        System.out.print(prompt);
        rtnInt = stdIn.nextInt();
        valid = true;
        if (rtnInt <= 0)
        {
          valid = false;
          System.out.println("Invalid entry.");
        }
      }
      catch (InputMismatchException ime)
      {
        stdIn.next();
        System.out.println("Invalid entry.");
        rtnInt = 0;
      }
    } while (!valid);
    
    return rtnInt;
  } // end checkIfPosInt
  
  //************************************************************
  
  // These methods help calculate the length of fluke and total length of whales
  
  private void calculateTotalLength()
  {
    this.totalWhaleLength = Math.pow(10, this.whaleLinearRegressionSlope * 
      Math.log10(this.flukeSpan) + this.whaleLinearYIntercept);
  } // end calculateTotalSpan

  private void calculateFlukeSpan()
  {
    this.flukeSpan = this.cameraNumOfPixels * 
      (cameraLinearRegressionSlope * cameraRange + cameraLinearYIntercept);
  } // end calculateFlukeSpan
  
  //************************************************************
  
  // Displays the calculated fluke span and the total length of the whale
  
  public void displayLength()
  {
    calculateFlukeSpan();
    calculateTotalLength();
    System.out.printf("fluke span = %,.2f" + " m, ", this.flukeSpan);
    System.out.printf("total length = %,.2f" + " m \n", this.totalWhaleLength );
  } // end displayLength
  
  //************************************************************
  
  // Main Method for the WhaleLengthCalculator Class
  
  public static void main(String[] args)
  {
    Scanner stdIn = new Scanner(System.in);
    WhaleLengthCalculator whale; // data for a whale
    String another;              // calculate another whale length (y/n)?
  
    whale = new WhaleLengthCalculator();
    whale.linearRegressionForCamera();
    System.out.println();
    whale.linearRegressionForLength();
    System.out.println();
  
    do
    {
      whale.promptForRange();
      System.out.println();
      whale.promptForPixels();
      System.out.println();
      whale.displayLength();
      System.out.print("\nCalculate another whale length (y/n)? ");
      another = stdIn.nextLine();
    } while (another.equalsIgnoreCase("y"));
  } // end main
} // end class WhaleLengthCalculator
