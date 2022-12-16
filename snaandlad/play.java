package SystemDesign.snaandlad;

import java.util.*;

public class play {
    public static void main(String[] args)
    {
        dice di=new dice(2);
        player a=new player("Alberts",1);
        player b=new player("Pintoss",2);
        Queue<player> players=new LinkedList<>();
        players.offer(a);
        players.offer(b);
        jumper snake1 = new jumper(10,2);
        jumper snake2 = new jumper(99,88);
        List<jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        jumper ladder1 = new jumper(5,25);
        jumper ladder2 = new jumper(40,89);
        List<jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        Map<String,Integer> playCurpos = new HashMap<>();
        playCurpos.put("Alberts",0);
        playCurpos.put("Pintoss",0);
        game gb=new game(di,players,ladders,snakes,playCurpos,100);
        gb.startgame();
    }
}
