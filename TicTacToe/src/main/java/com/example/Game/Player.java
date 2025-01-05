package main.java.com.example.Game;

public class Player {
    private String name;
    private Character token;

    public Player(String name, int token){
        this.name=name;
        this.token=(char)token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getToken() {
        return token;
    }

    public void setToken(Character token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", token=" + token +
                '}';
    }
}
