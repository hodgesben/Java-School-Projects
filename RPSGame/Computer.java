/***********************************************************
* Computer.java
* Benjamin Hodges
*
* This class implements an improved computer player for a game of
* rock, paper, scissors.
***********************************************************/

public class Computer
{
  private int wins = 0;                            // number of computer wins
  private String expertPlayer = null;              // sees if player is expert
  RpsGameImproved.RpsResult  previousWinner;       // last games winner
  RpsGameImproved.RpsThing  previousUserSelection; // user's last Selection
  private boolean firstPlay = true;                // checks if first game

  //***********************************************************

  public int getWins()
  {
    return this.wins;
  }

  // increment the number of wins for the computer
  
  public void incrementWins()
  {
    this.wins++;
  } // end wins
  
  //************************************************************
  
  // passes in if the player is an expert or not
  
  public void expertPlayer(String expertPlayer)
  {
    this.expertPlayer = expertPlayer;
  } // expertPlayer
  
  //************************************************************
  
  // uses passed knowledge to make the appropriate decision
  
  public RpsGameImproved.RpsThing selectRPS()
  {
    RpsGameImproved.RpsThing computerSelection;      // selection computer is going to make
    
    if (this.expertPlayer.equals("n") && firstPlay)  // if first round and not expert
    {
      computerSelection = RpsGameImproved.RpsThing.PAPER;
      firstPlay = false;
    }
    else if (previousWinner == previousWinner.USER_WIN) 
    {
     computerSelection = fixedComputerSelection(previousUserSelection);
    }
    else if (previousWinner == previousWinner.COMPUTER_WIN)  
    {
      computerSelection = previousUserSelection;
    }
    else
    {
      computerSelection = randomComputerSelection(); 
    }
    return computerSelection;
  } // end select
  
  //*********************************************

  // Use random strategy to make computer selection
  
  private static RpsGameImproved.RpsThing randomComputerSelection()
  {
    if (Math.random() < .33)
    {
      return RpsGameImproved.RpsThing.ROCK;
    }
    else if (Math.random() >= .66)
    {
      return RpsGameImproved.RpsThing.SCISSORS;
    }
    else
    {
      return RpsGameImproved.RpsThing.PAPER;
    }
  } // end randomComputerSelection
  
  //*********************************************
  
  // computer making choice based off of users previous play
  
  private static RpsGameImproved.RpsThing fixedComputerSelection(
    RpsGameImproved.RpsThing playerHandType)
  {
    if (playerHandType == RpsGameImproved.RpsThing.ROCK)
    {
      return RpsGameImproved.RpsThing.PAPER;
    }
    else if (playerHandType == RpsGameImproved.RpsThing.PAPER)
    {
      return RpsGameImproved.RpsThing.SCISSORS;
    }
    else
    {
      return RpsGameImproved.RpsThing.ROCK;
    }
  } // end fixedComputerSelection
} // end class Computer
