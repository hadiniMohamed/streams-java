import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> mots = new ArrayList<>();
        mots.add("pc");
        mots.add("tv");
        mots.add("mobile");


        System.out.println("Filtrer les mots qui contiennent la lettre \"a\".");

        mots.stream().filter(mot->mot.contains("a"))
                .forEach(System.out::println);


        System.out.println("Filtrer les mots qui ont une longueur supérieure à 3 et transformer chaque mot en son inverse.");

        mots.stream().filter(mot->mot.length()>3)
                .map(mot->new StringBuilder(mot).reverse())
                .forEach(System.out::println);

        System.out.println("Filtrer les chaînes qui contiennent la lettre \"e\" et aplatir chaque chaîne en une liste de\n" + "ses caractères.");

        mots.stream().filter(mot->mot.contains("e"))
                .flatMap(mot->mot.chars().mapToObj(m-> (char) m))
                .forEach(System.out::println);

        System.out.println("Transformer chaque chaîne en sa version en majuscules.");

        mots.stream().map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("Convertir chaque chaîne en sa longueur.");

        mots.stream().map(String::length)
                .forEach(System.out::println);

        System.out.println("Transformer chaque chaîne en une liste de ses caractères, puis aplatir toutes les listes en\n" + "une seule liste de caractères.");

        mots.stream().flatMap(mot->mot.chars().mapToObj(m->(char) m))
                .forEach(System.out::println);

        System.out.println("À partir d'une liste de mots, transformer chaque nom en une chaîne de la forme \"Nom -\n" + "Index\" où l'index représente la position du nom dans la liste.");

        mots.stream().map(mot->mot +"-"+ mots.indexOf(mot))
                .forEach(System.out::println);
    }
}
