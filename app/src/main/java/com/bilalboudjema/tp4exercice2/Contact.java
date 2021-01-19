package com.bilalboudjema.tp4exercice2;

public class Contact
{
    public String Nom;
    public  String Prenom;
    public  int Telephone;

    public Contact(String nom, String prenom, int telephone) {
        Nom = nom;
        Prenom = prenom;
        Telephone = telephone;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int telephone) {
        Telephone = telephone;
    }
}
