package org.example.esystem.Model;
import jakarta.persistence.*;

@Entity
@Table(name="cotisation")
public class Cotisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="cotisation_salariale", nullable = false)
    private double cotisationSalariale;

    @Column(name = "cotisation_patronale", nullable = false)
    private double cotisationPatronale;

    @Column(name="salaire_brut", nullable = false)
    private double salaireBrut;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "declaration_id", nullable = false)
    private Declaration declaration;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="assure_id", nullable = false)
    private Assure assure;

    public Cotisation(){}

    public Cotisation(double cotisationSalariale, double cotisationPatronale, double salaireBrut, Assure assure) {
        this.cotisationSalariale = cotisationSalariale;
        this.cotisationPatronale = cotisationPatronale;
        this.salaireBrut = salaireBrut;
        this.assure = assure;
    }

    public double getTotalCotisation(){
        return cotisationSalariale+cotisationPatronale;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCotisationSalariale() {
        return cotisationSalariale;
    }

    public void setCotisationSalariale(double cotisationSalariale) {
        this.cotisationSalariale = cotisationSalariale;
    }

    public double getCotisationPatronale() {
        return cotisationPatronale;
    }

    public void setCotisationPatronale(double cotisationPatronale) {
        this.cotisationPatronale = cotisationPatronale;
    }

    public double getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(double salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public Assure getAssure() {
        return assure;
    }

    public void setAssure(Assure assure) {
        this.assure = assure;
    }
}
