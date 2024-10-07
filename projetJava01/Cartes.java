package projet;

public class Cartes {
    // Attributs
    public static String[] COLORS = {"Cœur", "Trèfle", "Pic", "Carreau"};
    public static String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};

    private String color;
    private int value;

    // Constructeur
    public Cartes(String c, int v) {
        this.color = c;
        this.value = v;
    }

    // Méthodes d'accès
    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    // Méthodes de modification
    public void setColor(String c) {
        this.color = c;
    }

    public void setValue(int v) {
        this.value = v;
    }

    // Méthode pour comparer les cartes
    public int compareTo(Cartes other) {
        return Integer.compare(this.value, other.value); // Comparaison par valeur
    }

    // Méthode toString pour afficher les informations de la carte
    @Override
    public String toString() {
        return color + " " + VALUES[value]; // Affiche la carte sous la forme "Couleur Valeur"
    }
}
