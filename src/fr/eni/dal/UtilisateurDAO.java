package fr.eni.dal;

import java.sql.SQLException;

public interface UtilisateurDAO {

    Object ConnectByloginAndMdp(String login, String mdp) throws DALException, SQLException;

}
