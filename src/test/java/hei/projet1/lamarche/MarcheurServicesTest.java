package hei.projet1.lamarche;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

import hei.projet1.lamarche.Model.Carte;
import hei.projet1.lamarche.Model.Lieu;
import hei.projet1.lamarche.Model.Marcheur;
import hei.projet1.lamarche.Model.Parcours;
import hei.projet1.lamarche.Model.Rue;
import hei.projet1.lamarche.Services.MarcheurServices;

public class MarcheurServicesTest {

    @Test
    public void testTrouvezLeChemin() {
        // Initialisation des objets nécessaires pour le test
        Marcheur Bjarni = new Marcheur("Bjarni", "Islande", "M"); 
        Lieu Marais = new Lieu("Marais");
        Lieu Sekolintsika = new Lieu("Sekolintsika");
        Lieu HEI = new Lieu("HEI");
        Lieu Pullman = new Lieu("Pullman");
        Lieu Nexta = new Lieu("Nexta");
        Lieu Balançoire = new Lieu("Balançoire");
        Lieu ESTI = new Lieu("ESTI");
        Lieu BoulevardDeLEurope = new Lieu("Boulevard de L'Europe");

        Rue Andriatsioarana = new Rue("Andriatsioarana", true, List.of(HEI, Pullman));
        Rue Ranaivo = new Rue("Ranaivo", true, List.of(Pullman, Balançoire));
        Rue HEIBal = new Rue("HEI Balaçoire", false, List.of(HEI, Balançoire));
        Rue SekHEI = new Rue("Sekolintsika HEI", false, List.of(Sekolintsika, HEI));
        Rue SekMar = new Rue("Sekolintsika Marais", false, List.of(Sekolintsika, Marais));
        Rue BalBou = new Rue("Balançoire - Boulevoure de l'Europe", false, List.of(Balançoire, BoulevardDeLEurope));
        Rue BouESTI = new Rue("Boulevard de l'Europe - ESTI", false, List.of(BoulevardDeLEurope, ESTI));
        Rue BalESTI = new Rue("Balançoire - ESTI", false, List.of(Balançoire, ESTI));
        Rue PullNexta = new Rue("Pullman - Nexta", false, List.of(Pullman, Nexta));

        Carte OrTana = new Carte("OrTana", List.of(PullNexta, Andriatsioarana, Ranaivo, HEIBal, SekHEI, SekMar, BalBou, BouESTI, BalESTI));
        Parcours ParcoursDeBjarni = new Parcours(OrTana, Bjarni, HEI, ESTI);

        // Visualiser le resultat
        List<String> chemin = MarcheurServices.trouvezLeChemin(ParcoursDeBjarni);
        System.out.println();

        // Vérifications
        assertFalse(chemin.isEmpty(), "Le chemin ne doit pas être vide");
        assertEquals(HEI.getNom(), chemin.get(0), "Le premier élément du chemin doit être le départ");
        assertEquals(ESTI.getNom(), chemin.get(chemin.size() - 1), "Le dernier élément du chemin doit être l'arrivée");
    }
}