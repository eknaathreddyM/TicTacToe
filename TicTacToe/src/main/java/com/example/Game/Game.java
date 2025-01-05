package main.java.com.example.Game;

import java.util.*;

public class Game {
    Deque<Player> players;
    Board board;
    Player currPlayer;

    Scanner sc=new Scanner(System.in);
    private int token=65;
    public Game(List<String> users, int size){
        players=new LinkedList<>();
        for(int i=0; i<users.size();i++){
            players.addLast(new Player(users.get(i),token+i));
        }
        board=new Board(size);

    }

    public void start(){
        board.printBoard();
        while(!board.isFull()){
            currPlayer  =players.pollFirst();
            System.out.println(currPlayer.getName()+"'s move");
            System.out.println("Enter row number: ");
            int x=sc.nextInt();
            System.out.println("Enter column number: ");
            int y=sc.nextInt();

            if(board.move(x,y,currPlayer.getToken())) {
                board.printBoard();
                if (board.isFinish(x, y, currPlayer.getToken())) {
                    System.out.println(currPlayer.getName() + " won the game");
                    break;
                }
                players.addLast(currPlayer);
            }else{
                board.printBoard();
                System.out.println("select valid move!");
            }
        }
    }

}
