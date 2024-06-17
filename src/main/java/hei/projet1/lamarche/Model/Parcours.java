package hei.projet1.lamarche.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Parcours {
    private Carte carte;
    private Marcheur marcheur;
    private Lieu depart;
    private Lieu arrive;
}
