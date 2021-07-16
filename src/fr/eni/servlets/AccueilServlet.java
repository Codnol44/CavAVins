package fr.eni.servlets;

import fr.eni.bll.BouteilleManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.DALException;
import fr.eni.dal.UtilisateurDAO;
import org.apache.catalina.Manager;
import org.omg.CORBA.UserException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccueilServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //On récupère login et mdp
    String login = req.getParameter("login");
    String mdp = req.getParameter("mdp");

    //A partir des paramètres, créer une instance d'utilisateur via le Manager
    Utilisateur user;
    UtilisateurManager um;
    try {
        um = new UtilisateurManager();
        user = um.AutorisationConnection(login, mdp);

        //On vérifie ensuite login et mot de passe
        if((user.getLogin()).equals(login) && (user.getMdp().equals(mdp))) {

            //Je déclare le RequestDispatcher
            RequestDispatcher rd;

            //Pour aller à la JSP choix
            rd = req.getRequestDispatcher("WEB-INF/choix.jsp");
            rd.forward(req, resp);

            } else {
                // Affichage d'un message a l'utilisateur
                req.setAttribute("message", "Connexion impossible !");

                //Je déclare le RequestDispatcher
                RequestDispatcher rd;
                rd = req.getRequestDispatcher("WEB-INF/accueil.jsp");
                rd.forward(req, resp);
            }

            } catch (DALException | SQLException e) {
                System.out.println("Pb lors de la connexion !");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("WEB-INF/accueil.jsp");
        rd.forward(req, resp);
        }

}
