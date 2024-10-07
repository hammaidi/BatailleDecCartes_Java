package projet;

import java.util.ArrayList;

public class Joueurs {
    // Attributs
    private String name;
    private ArrayList<Cartes> paquet; // Liste de cartes
    private int score; // Compteur de points

    // Constructeur
    public Joueurs(String name) {
        this.name = name;
        this.paquet = new ArrayList<>(); // Initialiser le paquet de cartes avec le arraylist
        this.score = 0; // Initialiser score à 0
    }

    // Méthodes d'accès get
    public String getName() {
        return name;
    }

    public ArrayList<Cartes> getPaquet() {
        return paquet;
    }

    public int getScore() {
        return score;
    }

    // Méthode pour tirer une carte
    public Cartes tirerCarte() {
        if (!paquet.isEmpty()) {
            return paquet.remove(0); // Retirer et retourner la première carte
        }
        return null; // Si le paquet est vide
    }

    // Méthode pour ajouter une carte au paquet
    public void ajouterCarte(Cartes carte) {
        paquet.add(carte); // Ajouter la carte à la fin du paquet
    }

    // Méthode pour ajouter des points
    public void ajouterPoints(int points) {
        this.score += points; // Ajouter des points au score
    }

    // Méthode toString pour afficher les informations du joueur
    @Override
    public String toString() {
        return name + " a " + score + " points."; // Afficher le nom et le score
    }
}
