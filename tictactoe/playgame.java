package SystemDesign.tictactoe;

import java.util.LinkedList;
import java.util.Queue;

public class playgame {
    public static void main(String[] args)
    {
        Queue<player> players=new LinkedList<player>();
        player Pl1=new player("pintoss",1,'0');
        player Pl2=new player("albert",2,'X');
        players.offer(Pl1);
        players.offer(Pl2);

        gameboard gb=new gameboard(players);
        gb.start();


    }
}
