package main.java.com.example.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    Character[][] board;
    private int size;
    private List<Map<Character, Integer>> rows;
    private List<Map<Character, Integer>> cols;
    private Map<Character, Integer> mainDia;
    private Map<Character,Integer> offDia;

    public Board(int size){
        this.size=size;
        board=new Character[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j]=' ';
            }
        }
        rows=new ArrayList<>();
        cols=new ArrayList<>();
        mainDia=new HashMap<>();
        offDia=new HashMap<>();
        for(int i=0;i<size;i++) {
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
        }
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
    }

    public boolean isFull(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==' ') return false;
            }
        }
        return true;
    }

    public boolean move(int x, int y, Character token){
        if(x<0 || y<0 || x>=size || y>=size|| board[x][y]!=' '){
            System.out.println("Invalid Move!");
            return false;
        }
        board[x][y]=token;
        rows.get(x).put(token,rows.get(x).getOrDefault(token,0)+1);
        cols.get(y).put(token,cols.get(y).getOrDefault(token,0)+1);
        if(x==y) mainDia.put(token,mainDia.getOrDefault(token,0)+1);
        if(x+y==size-1) offDia.put(token, offDia.getOrDefault(token,0)+1);
        return true;
    }

    public boolean isFinish(int x, int y, Character token){
        if(rows.get(x).get(token)==size) return true;
        if(cols.get(y).get(token)==size) return true;
        if(mainDia.getOrDefault(token,0)==size) return true;
        if(offDia.getOrDefault(token,0)==size) return true;
        return false;
    }


}
