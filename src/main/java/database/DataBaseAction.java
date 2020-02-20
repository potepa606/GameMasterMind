package database;

import logic.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.Database.polocz;
import static database.Database.rozlocz;

public class DataBaseAction {


    public static void loadPlayers(){
        polocz();
        PreparedStatement st;
        Player.listOfPlayers.clear();
        try {
            st = Database.connection.prepareStatement("select *from MASTERMIND") ;
            ResultSet rs = st.executeQuery();
           // listaZakon.clear();

            String namePlayer, levelGame;
            int idPlayer, CountSamples,score;
            while (rs.next()){
                idPlayer = rs.getInt(1);
                namePlayer = rs.getString(2);
                CountSamples = rs.getInt(3);
                levelGame = rs.getString(4);
                score = rs.getInt(5);

                Player player = new Player(namePlayer,CountSamples,levelGame);
                player.setIdPlayer(idPlayer);
                player.setWynik(score);
                Player.listOfPlayers.add(player);

            }
        } catch (SQLException ex) {
            System.out.println("nie udalo sie wpisac do bazy");
        }
        rozlocz();
    }


    public static void removePlayers(int id){
        polocz();
        String deleteForm = "DELETE FROM MASTERMIND WHERE MASTERMIND.IDPlayer = ?";
        PreparedStatement st;
        try {
                st = Database.connection.prepareStatement(deleteForm) ;
                st.setInt(1, id);
                st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Nie udało sie usunąć z bazy playera o id: " + id);
        }
        rozlocz();
    }

    public static void sendPlayers(Player player){
        polocz();
        String insert = "INSERT INTO MASTERMIND (Idplayer, nameplayer, countsamples, levelgame,score) VALUES (?, ?, ?, ?, ?)";
        //String czyJuzbyło = "select *from JEDI WHERE JEDI.IDJedi = ?";


        PreparedStatement st;
       // PreparedStatement pst ;
        try {

                // sprawdz czy juz takich nie ma , jesli jest to continue
//                ResultSet rs = pst.executeQuery();
//                if(rs.next())
//                    continue;
                st = Database.connection.prepareStatement(insert) ;
                st.setInt(1, player.getIdPlayer());
                st.setString(2, player.getNamePlayer());
                st.setInt(3, player.getCountSamples());
                st.setString(4, player.getLevelGame());
                st.setInt(5, player.getWynik());
                st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Nie udało sie wpisac playera do bazy");
        }
        rozlocz();



    }



}
