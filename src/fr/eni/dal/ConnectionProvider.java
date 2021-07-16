package fr.eni.dal;

import javax.naming.Context; //TOMCAT
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection; //JAVA
import java.sql.SQLException;


public class ConnectionProvider {

    public static DataSource dataSource;

    static { //Equivalent du constructeur  dans une classe non-statique !
        Context context;

        try {
            //Lire le fichier Context.xml
            context = new InitialContext();
            ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/bdd"); //Nom de la ressource à droite de "env"

        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException("Impossible d'accéder à la base de données");
        }
    }

    public static Connection getConnection() throws SQLException {
        //A partir des infos, ouvrir une connexion
        return ConnectionProvider.dataSource.getConnection();

    }

}