package fr.eni.bll;

import fr.eni.bo.Bouteille;
import fr.eni.dal.BouteilleDAO;
import fr.eni.dal.DALException;
import fr.eni.dal.DAOFactory;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class BouteilleManager {

    private static BouteilleDAO BDAO;

    public BouteilleManager() {
        BDAO = DAOFactory.getBouteilleDAO();
    }

    public static void addBout(String region, String appellation, String domaine, int annee, int prix) throws DALException, SQLException {
        Bouteille bout = new Bouteille(region, appellation, domaine, annee, prix);
        BDAO.inserBout(bout);
    }

    public List<Bouteille> selectBout() throws DALException, SQLException {
        List<Bouteille> listeBout = BDAO.afficBout();
        return listeBout;
    }

    public Bouteille deleteBout(String region) throws DALException, SQLException {
        Bouteille bout = BDAO.deleteBout(region);
        return bout;
    }

}