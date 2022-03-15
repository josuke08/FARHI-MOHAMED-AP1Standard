package Presentation;


import Dao.*;
import Metier.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationDynamique {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, FileNotFoundException, InvocationTargetException, NoSuchMethodException {
        Scanner scanner=new Scanner(new File("config.txt"));
        String daoClassname=scanner.next();
        Class cdao=Class.forName(daoClassname);
        IDao dao= (IDao) cdao.newInstance();
        String metierClassName=scanner.next();
        Class cmetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) cmetier.newInstance();
        Method meth=cmetier.getMethod("setDao",IDao.class);
        meth.invoke(metier,dao);
        System.out.println(metier.calcul());
    }
}