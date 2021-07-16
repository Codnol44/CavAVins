package fr.eni.servlets;

import fr.eni.bll.BouteilleManager;
import fr.eni.dal.DALException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ChoixServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //On récupére les choix
        String region = req.getParameter("region");
        String appellation = req.getParameter("appellation");
        String domaine = req.getParameter("domaine");
        int annee = Integer.parseInt(req.getParameter("annee"));
        int prix = Integer.parseInt(req.getParameter("prix"));

        //A partir des paramètres, créer une instance de bouteille via BouteilleManager
        BouteilleManager bm = null;
        try {
            bm = new BouteilleManager();
            bm.addBout(region, appellation, domaine, annee, prix);

            // Affichage d'un message a l'utilisateur si ok !
            req.setAttribute("ajout", "Bouteille ajoutée !");

            } catch (DALException | SQLException e) {
                System.out.println("Pb lors de la demande d'ajout bouteille !");
            }

        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("WEB-INF/choix.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("WEB-INF/choix.jsp");
        rd.forward(req, resp);
    }
}
