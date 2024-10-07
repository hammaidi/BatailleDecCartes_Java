package projet;

//
import java.util.ArrayList;
import java.util.Collections;

public class Bataille {

    public static void main(String[] args) {
        // Étape 1 : créer le jeu de cartes
        ArrayList<Cartes> paquet = creerPaquet();

        // Étape 2 : mélanger aléatoirement le jeu
        Collections.shuffle(paquet);

        // Étape 3 : créer les 2 joueurs
        Joueurs joueur1 = new Joueurs("Joueur 1");
        Joueurs joueur2 = new Joueurs("Joueur 2");

        // Étape 4 : distribuer les cartes
        int mid = paquet.size() / 2; // Diviser le paquet en deux
        for (int i = 0; i < mid; i++) {
            joueur1.ajouterCarte(paquet.get(i)); // Ajouter la carte au joueur 1
            joueur2.ajouterCarte(paquet.get(mid + i)); // Ajouter la carte au joueur 2
        }

        // Étape 5 : Boucle de jeu
        while (!joueur1.getPaquet().isEmpty() && !joueur2.getPaquet().isEmpty()) {
            jouerUnTour(joueur1, joueur2);
        }

        // Afficher le vainqueur
        if (joueur1.getScore() > joueur2.getScore()) {
            System.out.println("Le " + joueur1.getName() + " a gagné avec " + joueur1.getScore() + " points !");
        } else if (joueur1.getScore() < joueur2.getScore()) {
            System.out.println("Le " + joueur2.getName() + " a gagné avec " + joueur2.getScore() + " points !");
        } else {
            System.out.println("C'est une égalité !");
        }
    }

    // Méthode pour créer le paquet de cartes
    private static ArrayList<Cartes> creerPaquet() {
        ArrayList<Cartes> paquet = new ArrayList<>();
        for (String couleur : Cartes.COLORS) {
            for (int i = 0; i < Cartes.VALUES.length; i++) {
                paquet.add(new Cartes(couleur, i));
            }
        }
        return paquet;
    }

    // Méthode pour jouer un tour
    private static void jouerUnTour(Joueurs joueur1, Joueurs joueur2) {
        Cartes carte1 = joueur1.tirerCarte(); // Joueur 1 tire une carte
        Cartes carte2 = joueur2.tirerCarte(); // Joueur 2 tire une carte

        System.out.println(joueur1.getName() + " tire : " + carte1);
        System.out.println(joueur2.getName() + " tire : " + carte2);

        // Comparer les cartes
        int comparison = carte1.compareTo(carte2);
        if (comparison > 0) {
            joueur1.ajouterPoints(1); // Joueur 1 gagne le tour
            System.out.println(joueur1.getName() + " gagne ce tour !");
        } else if (comparison < 0) {
            joueur2.ajouterPoints(1); // Joueur 2 gagne le tour
            System.out.println(joueur2.getName() + " gagne ce tour !");
        } else {
            System.out.println("Égalité");
        }

        System.out.println(); // Ligne vide pour séparer les tours
    }
}
