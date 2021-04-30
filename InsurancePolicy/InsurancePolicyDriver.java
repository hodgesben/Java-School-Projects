/**********************************************************
 * InsurancePolicyDriver.java
 * Benjamin Hodges
 *
 * This Class is the driver for Insurance Policies
 **********************************************************/

public class InsurancePolicyDriver
{
  public static void main(String[] args)
  {
    // local variable policies before assigning to array
    InsuranceLife lifePolicy;
    InsuranceHealth healthPolicy;
      
    // Array of insurance policies, to be filled with both types
    InsurancePolicy[] policies = new InsurancePolicy[50];

    lifePolicy = new InsuranceLife("John Dean", 40, 400000);
    lifePolicy.addBeneficiary("Caiden Dean");
    lifePolicy.addBeneficiary("Jordan Dean");
    lifePolicy.adjustCoverage(+10);
    policies[0] = lifePolicy;
      
    healthPolicy = new InsuranceHealth("John Dean", 500, 2000);
    healthPolicy.adjustCoverage(+100);
    policies[1] = healthPolicy;

    healthPolicy = new InsuranceHealth("Crystal Peng", 600, 1000);
    healthPolicy.adjustCoverage(-700);
    policies[2] = healthPolicy;
      
    for (int i=0; i<policies.length && policies[i] != null; i++)
    {
      policies[i].display();
      System.out.println();
    }
  } // end main
} // end class InsurancePolicyDriver
