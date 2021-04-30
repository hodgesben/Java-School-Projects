/**********************************************************
 * InsurancePolicy.java
 * Benjamin Hodges
 *
 * Super Class of the Different Insurances Health, Life
 *********************************************************/

public abstract class InsurancePolicy
{
  private final String POLICY_HOLDER;        // Name of account holder
  private final int MINIMUM_PREMIUM = 10;    // minimum Premium allowed on account
  private double premium;                    // current premium on account
  
  //**********************************************************************
  
  public InsurancePolicy(String name, int premium, int deductible)
  {
    POLICY_HOLDER = name;
    this.premium = premium;
  } // end constructor
  
  //**********************************************************************
  
  // Get methods  in the Insurance Policy Class
  
  public String getPOLICY_HOLDER()
  {
    return this.POLICY_HOLDER;
  }
   // end getPOLICY_HOLDER
  public double getPremium()
  {
    return this.premium;
  } // end getPremium
  
  //**********************************************************************
  
  // Adjusts the Premium to the Insurance Policy Account
  
  public void adjustPremium(double premium)
  {
    this.premium += premium;
    if (this.premium < MINIMUM_PREMIUM)
    {
      this.premium = MINIMUM_PREMIUM;
    }
  } // end setPremium
  
  //**********************************************************************
  
  // returns the actual adjust amount if reduced lower than the Minimum Premium ($10)
  
  public double adjustCoverage(int addedPremium)
  {
    if(Math.abs(addedPremium) > getPremium() && addedPremium < 0)
    {
      return -(getPremium() - MINIMUM_PREMIUM);
    }
    else
    {
      return addedPremium;
    }
  } // end adjustCoverage
  
  public abstract void display();
} // end class InsurancePolicy
