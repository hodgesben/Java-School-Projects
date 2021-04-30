/***********************************************************
* User.java
* Benjamin Hodges
*
* This class implements an improved human player for a game of
* rock, paper, scissors.
***********************************************************/

public class User
{
  String name; // user's name
  int wins;    // number of user wins
   
  //*********************************************
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getWins()
  {
    return this.wins;
  }

  // increment the number of wins for the computer
  
  public void incrementWins()
  {
    this.wins++;
  } // end wins
} // end class User
