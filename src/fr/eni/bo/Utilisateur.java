package fr.eni.bo;

import java.util.ArrayList;

public class Utilisateur {
    private Integer id;
    private String login;
    private String mdp;

    public Utilisateur(String pseudo, String password) {
        this.login = login;
        this.mdp = mdp;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
