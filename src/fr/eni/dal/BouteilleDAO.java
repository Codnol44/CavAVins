package fr.eni.dal;

import fr.eni.bo.Bouteille;
import java.sql.SQLException;
import java.util.List;

public interface BouteilleDAO {

    void inserBout(Bouteille bout) throws DALException, SQLException;

    List<Bouteille> afficBout() throws DALException, SQLException;

    Bouteille deleteBout(String region) throws DALException, SQLException;
}

