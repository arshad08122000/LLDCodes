package SystemDesign.tictactoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class gameboard {
    char [][] board;
    Scanner input;
    Queue<player> players=new LinkedList<player>();
    boolean gameover;

    int count=0;

    gameboard(Queue<player> players)
    {
        board=new char[][]
                {{' ','|',' ','|',' '},
                {'-',' ','-',' ','-'},
                {' ','|',' ','|',' '},
                {'-',' ','-',' ','-'},
                {' ','|',' ','|',' '}
        };
        input=new Scanner(System.in);
        this.players=players;
        gameover=false;
    };

    protected void printBoard (char[][] board){
        for(char[] row : board){
            for(char col: row){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private boolean check(player p){
        if(board[0][0]+board[0][2]+board[0][4] == p.getSymbol()+p.getSymbol()+p.getSymbol()) return true;
        if(board[2][0]+board[2][2]+board[2][4] == p.getSymbol()+p.getSymbol()+p.getSymbol()) return true;
        if(board[4][0]+board[4][2]+board[4][4] == p.getSymbol()+p.getSymbol()+p.getSymbol()) return true;
        if(board[0][0]+board[2][0]+board[4][0] == p.getSymbol()+p.getSymbol()+p.getSymbol()) return true;
        if(board[0][2]+board[2][2]+board[4][2] == p.getSymbol()+p.getSymbol()+p.getSymbol()) return true;
        if(board[0][4]+board[2][4]+board[4][4] == p.getSymbol()+p.getSymbol()+p.getSymbol()) return true;
        if(board[0][0]+board[2][2]+board[4][4] == p.getSymbol()+p.getSymbol()+p.getSymbol()) return true;
        if(board[0][4]+board[2][2]+board[4][0] == p.getSymbol()+p.getSymbol()+p.getSymbol()) return true;

        return false;
    }

    protected int getcoordinates(int position)
    {
        switch(position)
        {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 20;
            case 5:
                return 22;
            case 6:
                return 24;
            case 7:
                return 40;
            case 8:
                return 42;
            case 9:
                return 44;
        }

        return -1;
    }

    protected boolean validposition(int position)
    {
        if(position<1 || position>9)
        {
            return false;
        }

        int val=getcoordinates(position);
        if(board[val/10][val%10]=='X'||board[val/10][val%10]=='0')
        {
            return false;
        }

        return true;
    }

    protected int nextmove()
    {
        System.out.println("Enter the position via 1-9");
        int position=input.nextInt();
        while(!validposition(position)) {
            System.out.println("Sry!Wrong Position");
            position=input.nextInt();
        }
        return getcoordinates(position);
    }


    public void start()
    {
        System.out.println("Welcome to Tic tac Toe");
        System.out.println("   ");
        printBoard(board);
        System.out.println("   ");
        while(!gameover)
        {
            count++;
            if(count==10)
            {
                System.out.println("Sry!Bro Game Over");
                break;
            }
            player p=players.poll();
            int val=nextmove();
            board[val/10][val%10] = p.getSymbol();
            if(check(p))
            {
                gameover=true;
                System.out.println(p.getPlayername()+" has won the game");
            }
            printBoard(board);
            players.offer(p);
        }


    }








}



