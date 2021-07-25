import java.util.Scanner;

public class Game {
    String[] moves;
    int playerMove;
    int computerMove;
    public Game(String[] args){
        moves=args;
    }
   public int getComputerMove(){
        computerMove =(int) (Math.random()*moves.length);
        return computerMove;
    }
   public boolean menu(){
        while(true) {
        System.out.println("Available moves:");
        for(int i=0;i< moves.length;i++)
            System.out.println((i+1)+"-"+moves[i]);
        System.out.println(0+"-exit");
        System.out.print("Enter your move: ");
          playerMove=-1;
            Scanner in = new Scanner(System.in);
            playerMove = in.nextInt();
            playerMove--;
            if(playerMove==-1)
                return false;
            if(playerMove>=moves.length||playerMove<-1)
                continue;
                break;
        }
        return true;
    }
     public void result(){
        System.out.println("Your move: "+moves[playerMove]+"\nComputer move: "+moves[computerMove]);
        if(playerMove-computerMove> (moves.length-1)/2||playerMove-computerMove>=-(moves.length-1)/2&&playerMove-computerMove<0)
            System.out.println("You lose");
        else if(playerMove-computerMove==0)
            System.out.println("Draw");
        else
            System.out.println("You win!");
    }
}
