package org.example.esystem.Model;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="employeur")
public class Employeur {
    @Id
    @GeneratedValue(strategy  =GenerationType.IDENTITY)
    private int id;

    @Column(name="raison_sociale", nullable = false)
    private String raisonSociale;

    @Column (name="secteur_activite", nullable = false)
    private String secteurActivite;

    @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Assure> assures= new ArrayList<>();

    @OneToMany(mappedBy = "employeur" , cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    private List<Declaration>declarations=new ArrayList<>();

    public Employeur(){}

    public Employeur(String raisonSociale,String secteurActivite) {
        this.raisonSociale = raisonSociale;
        this.secteurActivite = secteurActivite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public void setAssures(List<Assure> assures) {
        this.assures = assures;
    }

    public void setDeclarations(List<Declaration> declarations) {
        this.declarations = declarations;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public List<Assure> getAssures() {
        return assures;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }
}
