package org.example.esystem.Service;
import org.example.esystem.DAO.CotisationDAO;
import java.util.HashMap;
import java.util.Map;
public class DroitsService {
    CotisationDAO cotisationDAO = new CotisationDAO();
    public Map<String, Object> consulterDroits(Long assureId) {
        Map<String, Object> droits = new HashMap<>();

        long moisDeclares = cotisationDAO.getNombreMoisDeclares(assureId);
        double totalCotisations =
                cotisationDAO.getTotalCotisationsByAssure(assureId);

        droits.put("moisDeclares", moisDeclares);
        droits.put("totalCotisations", totalCotisations);


        if (moisDeclares >= 54) {
            droits.put("couvertureMaladie", true);
            droits.put("message", "Vous avez droit à une couverture médicale");
        } else {
            droits.put("couvertureMaladie", false);
            droits.put("message",
                    "Vous n'avez pas le droit jusqu'à maintenant, vous avez besoin de "
                            + (54 - moisDeclares) + "mois supplémentaire");
        }

        return droits;
    }
}
