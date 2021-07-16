package fr.eni.bll;

import fr.eni.bo.Bouteille;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.*;
import org.omg.CORBA.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UtilisateurManager {

    private static UtilisateurDAO UDAO;

    public UtilisateurManager() {
        UDAO = DAOFactory.getUtilisateurDAO();
    }

    public Utilisateur AutorisationConnection(String login, String mdp) throws DALException, SQLException {
        Utilisateur user = (Utilisateur) UDAO.ConnectByloginAndMdp(login, mdp);
        return user;
    }
}
