package org.example.esystem;

import org.example.esystem.DAO.EmployeurDAO;
import org.example.esystem.Model.Employeur;
import org.example.esystem.util.JPAUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting JPA setup...");

        // 1. Create a new Employer
        Employeur emp = new Employeur();
        emp.setRaisonSociale("Tech Solutions Maroc");
        emp.setSecteurActivite("IT");

        // 2. Save it using the DAO
        EmployeurDAO dao = new EmployeurDAO();

        System.out.println("Employer saved successfully!");

        // Close the factory when done
            org.example.esystem.util.JPAUtil.close();
    }
}