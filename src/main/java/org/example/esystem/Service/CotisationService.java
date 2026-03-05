package org.example.esystem.Service;
import org.example.esystem.Model.*;
import org.example.esystem.DAO.*;
import java.util.List;

public class CotisationService {
    CotisationDAO cotisationDAO = new CotisationDAO();
    AssureDAO assureDAO = new AssureDAO();
    private static double taux_salariale = 0.0448;
    private static double taux_patronale = 0.0898;
    private static double plafond=5000;

    public Cotisation calculerCotisation(Assure assure,Declaration declaration){
        double salaire= assure.getSalaireMensuel();
        double salaireBase = Math.min(salaire, plafond);
        double cotiSalariale = salaireBase*taux_salariale;
        double cotiPatronale = salaireBase*taux_patronale;

        Cotisation cotisation = new Cotisation(cotiSalariale,cotiPatronale,salaire,declaration,assure);
        return cotisation;
    }

    public void calculerEnregistrer(Declaration declaration){
        int empolyeurId = declaration.getEmployeur().getId();
        List<Assure> assures = assureDAO.findEmployeur(empolyeurId);

        for (Assure assure : assures) {
            Cotisation cotisation = calculerCotisation(assure, declaration);
            cotisationDAO.ajouterCotisation(cotisation);
        }
    }

    public double getTotalParEmployeur(int employeurId) {
        return cotisationDAO.getTotalByEmployeur(employeurId);
    }
}
