package com.example;

import java.lang.reflect.Constructor;

/* Exercici 1

Crea un programa que instancii 3 objectes amb dades diferents de la classe tipus
**Singleton “Objecte.java”** amb 3 segons de diferència i aconseguint 3 instàncies diferents, ignorant el fet que es tracta d’un objecte que implementa el model ‘Singleton’. 

L’objecte ha de tenir les variables privades ‘nom’, ‘cognom’, ‘edat’
com a privades NO estàtiques i ha de seguir el model Singleton (com l’exercici anterior).

Mostra les dades de cada instància al final (caldrà sobreescriure toString)

Pots crear una funció ‘getNewDestroyedInstance’ que retorni una
instància ‘hackejada’ de Singleton, per no anar repetint codi. */


class Objecte {
    private static Objecte instance;
    private String nom;
    private String cognom;
    private int edat;

    private Objecte(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Objecte{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", edat=" + edat +
                '}';
    }

    public static Objecte getInstance(String nom, String cognom, int edat) {
        if (instance == null) {
            instance = new Objecte(nom, cognom, edat);
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        Objecte objecte1 = Objecte.getInstance("Albert", "Palacios", 20);

        Objecte objecte2 = null;
        try {
            Constructor[] constructors = Objecte.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                objecte2 = (Objecte) constructor.newInstance("Joan", "Perez", 25);
                break;
            }
        } catch (Exception e) { e.printStackTrace(); }
        Objecte objecte3 = null;
        try {
            Constructor[] constructors = Objecte.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                objecte3 = (Objecte) constructor.newInstance("Maria", "Gomez", 30);
                break;
            }
        } catch (Exception e) { e.printStackTrace(); }

        System.out.println(objecte1);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(objecte2);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(objecte3);
    }
}