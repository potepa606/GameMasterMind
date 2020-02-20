package logic;

import java.util.ArrayList;
import java.util.Objects;

public class Player {

    private int idPlayer;
    private String namePlayer;
    private int countSamples;
    private String levelGame;
    private int wynik;

    public static ArrayList<Player> listOfPlayers = new ArrayList<>();


    public Player(String namePlayer, int countSamples, String levelGame) {
        this.namePlayer = namePlayer;
        this.countSamples = countSamples;
        this.levelGame = levelGame;
        this.wynik = wynik();
        this.idPlayer = this.hashCode();
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public int getCountSamples() {
        return countSamples;
    }

    public void setCountSamples(int countSamples) {
        this.countSamples = countSamples;
    }

    public String getLevelGame() {
        return levelGame;
    }

    public void setLevelGame(String levelGame) {
        this.levelGame = levelGame;
    }

    public void setWynik(int wynik) {
        this.wynik = wynik;
    }

    public int getWynik(){
        return this.wynik;
    }

    public int wynik(){
        if (levelGame.equals("easy"))
            return (2 / countSamples)*100;
        else if (levelGame.equals("medium"))
            return (4 / countSamples)*100;
        else if (levelGame.equals("hard"))
            return (7 / countSamples)*100;
        else return 0;
    }


    @Override
    public int hashCode() {
        return Math.abs(Objects.hash(namePlayer + wynik));
    }

    @Override
    public String toString() {
        return "Player{" +
                "idPlayer=" + idPlayer +
                ", namePlayer='" + namePlayer + '\'' +
                ", countSamples=" + countSamples +
                ", levelGame='" + levelGame + '\'' +
                '}';
    }
}
