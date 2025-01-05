package main.java.com.example;

import main.java.com.example.Game.Game;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> names=new ArrayList<>();
        names.add("eknath");
        names.add("reddy");
        int sizeOfBoard=3;
        Game game=new Game(names,sizeOfBoard);
        game.start();
    }
}