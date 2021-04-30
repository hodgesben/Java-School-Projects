/**********************************************************
 * InsuranceHealth.java
 * Benjamin Hodges
 *
 * Class is a subclass of InsurancePolicy deals 
 * with Health specific insurance policies
 *********************************************************/

public class InsuranceHealth extends InsurancePolicy
{
  private final int PREMIUM_ADJUST = 10;  // Amount adjusted b/c of premium change
  private double deductible;              // Decutible on account
  
  //**********************************************************************

  public InsuranceHealth(String name, int premium, int deductible)
  {
    super(name, premium, deductible);
    this.deductible = deductible;
  } // end constructor

  //**********************************************************************
  
  // Displays the Policy Holder, Premium, and deductible 
  // on their Health insurance account
  
  public void display()
  {
    System.out.println("Health insurance policy holder: " + getPOLICY_HOLDER());
    System.out.printf("Premium: $%,.2f", getPremium());
    System.out.printf("\nDeductible: $%,.2f\n", this.deductible);
  } // end display
  
  //**********************************************************************
  
  // Adjusts the deductible and Premium on the Health insurance account
  
  public double adjustCoverage(int addedPremium)
  { 
    this.deductible -= ((super.adjustCoverage(addedPremium)) * PREMIUM_ADJUST);
    adjustPremium(addedPremium);
    return addedPremium;
  } // end adjustCoverage
} // end class InsuranceHealth
