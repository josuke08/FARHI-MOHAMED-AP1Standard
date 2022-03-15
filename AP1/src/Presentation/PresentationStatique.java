package Presentation;

import Dao.*;
import Metier.MetierImpl;

public class PresentationStatique {
    public static void main(String[] args) {
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl();

        metier.setDao(dao);
        System.out.println(metier.calcul());

        metier.setDao(new DaoImpl2());
        System.out.println(metier.calcul());
    }

}
