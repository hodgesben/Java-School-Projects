/**********************************************************
 * InsuranceLife.java
 * Benjamin Hodges
 * 
 * Class is a subclass of InsurancePolicy deals 
 * with Life Insurance specific policies
 *********************************************************/

import java.util.*;

public class InsuranceLife extends InsurancePolicy
{
  //beneficiaries on account
  private ArrayList<String> beneficiaries = new ArrayList<>();
  //deathBenefit on account
  private double deathBenefit; 
  // adjusted amount bases on premium change
  private final int PREMIUM_ADJUST = 10000;                  
  
  //**********************************************************************
  
  public InsuranceLife(String name, int premium, int benefit)
  {
    super(name, premium, benefit);
    this.deathBenefit = benefit;
  } // end constructor
  
  //**********************************************************************
  
  // Adds a Beneficiary to get a cut of the total deathBenefit amount
  
  public void addBeneficiary(String beneficiary)
  {
    beneficiaries.add(beneficiary);
  } // end addBenefirciary
  
  //**********************************************************************
  
  // This method displays the Policy Holder, Premium, death beneficiaries
  // and how much each Beneficiary will get if the passing of Policy Holder

  public void display()
  {
    System.out.println("Life insurance policy holder: " + getPOLICY_HOLDER());
    System.out.printf("Premium: $%,.2f\n", getPremium());
    System.out.printf("Death benefit: $%,.2f\n", this.deathBenefit);
    System.out.println("Beneficiaries:");
    for(int i=0; i<beneficiaries.size(); i++)
    {
      System.out.printf(beneficiaries.get(i) + ": $%,.2f\n", 
        (deathBenefit/beneficiaries.size())); 
    }
  } // end display

  //**********************************************************************
  
  // Adjusts the premium and death benefit on the Life insurance account
  
  public double adjustCoverage(int addedPremium)
  {
    this.deathBenefit += (super.adjustCoverage(addedPremium)) * PREMIUM_ADJUST;
    adjustPremium(addedPremium);
    return addedPremium;
  } // end adjustCoverage
} // end InsuranceLife
