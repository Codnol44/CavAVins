package fr.eni.dal;

import com.sun.istack.internal.NotNull;
import fr.eni.bo.Utilisateur;

import java.sql.*;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

    //1-Récupération des utilisateurs habilités en BDD
    @Override
    public Utilisateur ConnectByloginAndMdp(String login, String mdp) throws DALException, SQLException {

        final String SELECT_BY_LOGIN_AND_MDP = "SELECT * FROM UTILISATEURS WHERE login = ? AND mdp = ?";

        Utilisateur user = new Utilisateur(login, mdp);
        Utilisateur user2 = new Utilisateur("out", "out");
        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement pstt = connection.prepareStatement(SELECT_BY_LOGIN_AND_MDP);
        ) {

            //Remplacer les ? dans la requete
            pstt.setString(1, login);
            pstt.setString(2, mdp);

            //J'exécute la requête
            ResultSet rs = null;
            rs = pstt.executeQuery();
            if ((rs != null) && rs.next()) {
                user.setLogin(rs.getString("login"));
                user.setMdp(rs.getString("mdp"));

            } else {
                user.setLogin("wronglogin");
                user.setMdp("wrongmdp");
            }

        } catch (SQLException throwables) {
            System.out.println("Identifiant et/ou mot de passe incorrects !");
        }
        return user;
    }
}
