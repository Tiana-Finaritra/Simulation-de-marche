package hei.projet1.lamarche.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Carte {
    private String nom;
    private List<Rue> tousRues;
}