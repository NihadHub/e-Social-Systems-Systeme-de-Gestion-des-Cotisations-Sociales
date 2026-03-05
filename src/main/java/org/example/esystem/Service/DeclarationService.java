package org.example.esystem.Service;
import org.example.esystem.Model.*;
import org.example.esystem.DAO.DeclarationDAO;
import java.time.LocalDate;
public class DeclarationService {
   DeclarationDAO declarationDAO= new DeclarationDAO();
   CotisationService cotisationService= new CotisationService();

   public String creerDeclaration(Employeur e,int mois, int annee){
       if(declarationDAO.exister(e.getId(),mois,annee)){
           return "Error: La declaration de cet mois "+mois+annee+" est deja existé!";
       }
      Declaration declaration = new Declaration(mois,annee,LocalDate.now(),e);
       declarationDAO.ajouterDeclaration(declaration);
       cotisationService.calculerEnregistrer(declaration);
       return "Declaration ajouté avec success!";
   }
}
