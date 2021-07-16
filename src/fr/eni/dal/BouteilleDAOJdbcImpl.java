package fr.eni.dal;

import fr.eni.bo.Bouteille;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BouteilleDAOJdbcImpl implements BouteilleDAO {

    //1-Ajout d'une bouteille
    @Override
    public void inserBout(Bouteille bout) throws DALException, SQLException {

        String INSER_BOUT = "INSERT into BOUTEILLES(region, appellation, domaine, annee, prix) VALUES(?,?,?,?,?)";

        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement pstt = connection.prepareStatement(INSER_BOUT, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {

            //Remplacer les ? dans la requete
            pstt.setString(1, bout.getRegion());
            pstt.setString(2, bout.getAppellation());
            pstt.setString(3, bout.getDomaine());
            pstt.setInt(4, bout.getAnnee());
            pstt.setInt(5, bout.getPrix());

            //J'exécute la requête
            pstt.executeUpdate();

            //On récupère l'id généré que l'on insère
            ResultSet rs = pstt.getGeneratedKeys();
            if (rs.next()) {
                bout.setId_B(rs.getInt(1));
            }

        } catch (SQLException throwables) {
            System.out.println("Pb lors de l'ajout bouteille !");
        }
    }

    //2-Affichage des bouteilles
    @Override
    public List<Bouteille> afficBout() throws DALException, SQLException {

    String AFFIC_BOUT = "SELECT * FROM BOUTEILLES";

        List<Bouteille> listeBouteille = new ArrayList<>();

        try (
                //On remplace la connexion initiale
                Connection connection = ConnectionProvider.getConnection();
                Statement stt = connection.createStatement();
        ) {
            //J'exécute la requête
            ResultSet rs = stt.executeQuery(AFFIC_BOUT);

            //On recupere les paramètres de son objet avec le get
            while (rs.next()) {
                listeBouteille.add(new Bouteille(rs.getString("region"), rs.getString("domaine"), rs.getString("appellation"), rs.getInt("annee"),rs.getInt("prix")));
            }
        } catch (SQLException throwables) {
            System.out.println("Pb lors de l'affichage liste bouteilles !");
        }
        return listeBouteille;
    }

    //3-Suppression d'une bouteille
    @Override
    public Bouteille deleteBout(String region) throws DALException, SQLException {

        String DELETE_BOUT = "DELETE FROM BOUTEILLES WHERE region = ?";

        try (
                //On remplace la connexion initiale
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement pstt = connection.prepareStatement(DELETE_BOUT);
        ) {

            //Remplacer le ? dans la requete puis l'executer
            pstt.setString(1, region);
            pstt.executeUpdate();

        } catch (SQLException throwables) {
            System.out.println("Pb lors de la suppression bouteille !");
        }
        return null;
    }

}