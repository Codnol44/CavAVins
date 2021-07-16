package fr.eni.dal;

public class DAOFactory {

    public static BouteilleDAO getBouteilleDAO() {
        BouteilleDAO BDAO = new BouteilleDAOJdbcImpl();
        return BDAO;
    }

    public static UtilisateurDAO getUtilisateurDAO() {
        UtilisateurDAO UDAO = new UtilisateurDAOJdbcImpl();
        return UDAO;
    }

}