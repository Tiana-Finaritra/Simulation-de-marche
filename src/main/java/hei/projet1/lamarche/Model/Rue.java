package hei.projet1.lamarche.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@AllArgsConstructor
@ToString
public class Rue {
    private String nom;
    private boolean estUnRueReel;
    private List<Lieu> connection = new ArrayList<Lieu>(2);
}