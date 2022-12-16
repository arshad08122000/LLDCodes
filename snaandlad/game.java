package SystemDesign.snaandlad;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@Getter
@Setter

public class game {
    private dice di;
    private Queue<player> players;
    private List<jumper> ladders;
    private List<jumper> snakes;
    private Map<String,Integer> playCurpos;
    private int boardsize;
    game(dice di,Queue<player> players,List<jumper> ladders,List<jumper> snakes,Map<String,Integer> playCurpos,int boardsize)
    {
        this.di=di;
        this.players=players;
        this.ladders=ladders;
        this.snakes=snakes;
        this.playCurpos=playCurpos;
        this.boardsize=boardsize;
    }


    void startgame()
    {
        while(players.size()>1)
        {
           player curplayer=players.poll();
           String playername=curplayer.getName();
           int currentposition=playCurpos.get(playername);
           int dicevalue=di.rolldice();
           System.out.println("Dice value is : "+dicevalue);
           int nextcell=currentposition+dicevalue;
           int board=getBoardsize();
           if(nextcell>boardsize)
           {
               players.offer(curplayer);
           }
           else if(nextcell==board)
           {
               System.out.println(curplayer.getName()+" has won the game");
           }
           else
           {
               int[] nextposition=new int[1];
               nextposition[0]=nextcell;
               for(jumper snake:snakes)
               {
                   if(snake.getStpoint()==nextposition[0]) {
                       nextposition[0] = snake.getEdpoint();
                       System.out.println("Player " + curplayer.getName() + " bitten by snake at " + nextcell + " and goes to " + snake.getEdpoint());
                   }
               }

               for(jumper ladder:ladders)
               {
                   if(ladder.getStpoint()==nextposition[0])
                   {
                       nextposition[0] = ladder.getEdpoint();
                       System.out.println("Player " + curplayer.getName() + " got a ladder at " + nextcell + " and goes to " + ladder.getEdpoint());
                   }
               }

               if(nextposition[0]==boardsize)
               {
                   System.out.println(curplayer.getName()+" won a game");
               }
               else{
                   playCurpos.put(curplayer.getName(),nextposition[0]);
                   System.out.println(curplayer.getName()+ "is at position "+nextposition[0]);
                   players.offer(curplayer);
               }


           }

        }
    }
}

