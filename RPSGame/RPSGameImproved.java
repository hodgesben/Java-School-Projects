/***********************************************************
* RpsGameImproved.java 
* Benjamin Hodges
*
* This class implements an improved game of rock, paper, scissors.
***********************************************************/

import java.util.Scanner;

class RpsGameImproved
{
  private Computer computer = new Computer();
  private User user = new User();
  public enum RpsThing {ROCK, PAPER, SCISSORS};
  public enum RpsResult {USER_WIN, COMPUTER_WIN, TIE};
  
  //*********************************************************
  
  // This method prompts the user for his/her name and number of rounds
  // and then plays that number of rounds and determines the winner.
  
  public void play()
  {
    Scanner stdIn = new Scanner(System.in);
    String name;                           // user's name
    int rounds;                            // number of rounds 
    RpsThing computerSelection;            // computer's selection
    RpsThing userSelection;                // user's selection

    System.out.println(
      "The computer is ready to play you in a rousing game of Rock," +
      " Paper, Scissors!\n");
    
    System.out.print("What is your name? ");
    name = stdIn.nextLine();
    user.setName(name);
    System.out.print("How many rounds would you like to play? ");
    rounds = stdIn.nextInt();
    stdIn.nextLine();             // flush new line
    System.out.print("Are you an expert player? (y/n): ");
    computer.expertPlayer(stdIn.next());

    for (int i=0; i<rounds; i++)
    {
      System.out.print(
        "\nOn a piece of paper, write \"rock\", \"paper\", or" +
        " \"scissors\", and then press enter.");
      
      // Consume prior newline, then generate a pause by waiting for enter
      stdIn.nextLine();
      stdIn.nextLine();
      
      computerSelection = computer.selectRPS();
      
      System.out.print(
        "The computer chooses " + computerSelection + ".\n" +
        "Did you choose \"rock\", \"paper\", or \"scissors\" (r/p/s)? ");
        
      switch (stdIn.next().charAt(0))
      {
        case 'r': case 'R':
          userSelection = RpsThing.ROCK;
          computer.previousUserSelection = RpsThing.ROCK;
          break;
        case 'p': case 'P':
          userSelection = RpsThing.PAPER;
          computer.previousUserSelection = RpsThing.PAPER;
          break;
        case 's': case 'S':
          userSelection = RpsThing.SCISSORS;
          computer.previousUserSelection = RpsThing.SCISSORS;
          break;
        default:
          System.out.println("Invalid selection. Must enter r, p, or s.");
          userSelection = null;
      } // end switch
      
      switch (determineWinner(userSelection, computerSelection))
      {
        case USER_WIN:
          user.incrementWins();
          computer.previousWinner = RpsResult.USER_WIN;
          System.out.println("You won this round.");
          break;
        case COMPUTER_WIN:
          computer.incrementWins();
          computer.previousWinner = RpsResult.COMPUTER_WIN;
          System.out.println("The computer won this round.");
          break;
        case TIE:
          computer.previousWinner = RpsResult.TIE;
          System.out.println("You tied the computer this round.");
      }
    } // end for
    
    if (user.getWins() > computer.getWins())
    {
      System.out.println(
        "\nCongratulations, " + user.getName() + "! You won " +
        user.getWins() + " to " + computer.getWins() + ".");
    }
    else if (user.getWins() < computer.getWins())
    {
      System.out.println(
        "\nSorry, " + user.getName() + ". The computer won " +
        computer.getWins() + " to " + user.getWins() + ".");
    }
    else
    {
      System.out.println(
        "\n" + user.getName() + ", you tied the computer with " +
        user.getWins() + " wins each.");
    }
  } // end play
  
  //*********************************************************
  
  // This method determines who wins this one round.
  
  private RpsResult determineWinner(
    RpsThing userSelection, RpsThing computerSelection)
  {
    if (userSelection.equals(computerSelection))
    {
      return RpsResult.TIE;
    }
    else if (
      userSelection == RpsThing.ROCK && computerSelection == RpsThing.SCISSORS ||
      (userSelection == RpsThing.PAPER && computerSelection == RpsThing.ROCK) ||
      (userSelection == RpsThing.SCISSORS && computerSelection == RpsThing.PAPER))
    {
      return RpsResult.USER_WIN;
    }
    else
    {
      return RpsResult.COMPUTER_WIN;
    }
  } // determineWinner
  
  //*********************************************************
  
  // This method is the main method of RPS Game 

  public static void main(String[] args)
  {
    RpsGameImproved game;  // a game of rock, paper, scissors
    
    game = new RpsGameImproved();
    game.play();
  } // end main
} // end class RpmGameImproved
