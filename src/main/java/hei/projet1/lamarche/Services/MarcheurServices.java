package hei.projet1.lamarche.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import hei.projet1.lamarche.Model.Carte;
import hei.projet1.lamarche.Model.Lieu;
import hei.projet1.lamarche.Model.Parcours;
import hei.projet1.lamarche.Model.Rue;

public class MarcheurServices {
    
    private static Random random = new Random();


    public static List<String> trouvezLeChemin(Parcours parcours) {
        Lieu arrive = parcours.getArrive();
        Lieu depart = parcours.getDepart();
        Carte carte = parcours.getCarte();
        List<Rue> tousLesRues = carte.getTousRues();
        
        List<Lieu> chemin = new ArrayList<>();
        Lieu lieuActuel = depart;
        chemin.add(lieuActuel);

        while (!lieuActuel.equals(arrive)) {
            Lieu lieuActuelFinal = lieuActuel;
            List<Rue> ruesDisponibles = tousLesRues.stream()
                    .filter(rue -> rue.getConnection().contains(lieuActuelFinal))
                    .collect(Collectors.toList());

            Rue rueChoisie = ruesDisponibles.get(random.nextInt(ruesDisponibles.size()));
            lieuActuel = rueChoisie.getConnection().stream()
                    .filter(lieu -> !lieu.equals(lieuActuelFinal))
                    .findFirst()
                    .orElse(lieuActuel);
            
            chemin.add(lieuActuel);
        }

        return chemin.stream().map(Lieu::getNom).collect(Collectors.toList());
    }
}
