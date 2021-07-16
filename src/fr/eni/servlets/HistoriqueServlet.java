package fr.eni.servlets;

import fr.eni.bll.BouteilleManager;
import fr.eni.bo.Bouteille;
import fr.eni.dal.DALException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoriqueServlet extends HttpServlet {
    private Object List;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Créer une liste de bouteilles via BouteilleManager
        List<Bouteille> listeBouteille = new ArrayList<>();
        BouteilleManager bm;
        try {
            bm = new BouteilleManager();
            listeBouteille = bm.selectBout();

        } catch (DALException | SQLException e) {
            System.out.println("Pb lors de la demande de sélection liste !");
        }

        //La servlet envoie l'info à la JSP !
        req.setAttribute("listeBouteille", listeBouteille);

        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        rd = req.getRequestDispatcher("WEB-INF/historique.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //On récupére la Région
        String region = req.getParameter("region");

        //A partir du paramètre, créer une instance via BouteilleManager
        Bouteille bout = new Bouteille();
        BouteilleManager bm;
        try {
            bm = new BouteilleManager();
            bout = bm.deleteBout(region);

        } catch (DALException | SQLException e) {
            System.out.println("Pb lors de la demande de suppression !");
        }

        // Je rappelle la méthode doGet
        this.doGet(req, resp);

    }
}
