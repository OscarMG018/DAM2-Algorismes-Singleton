package com.example;

/*# Exercici 0

Crea un programa que instancii 3 objectes amb dades diferents de
la classe tipus **Singleton “Objecte.java”** amb 3 segons de diferència. 

L’objecte ha de tenir les variables privades ‘nom’, ‘cognom’,
‘edat’ com a privades NO estàtiques i ha de seguir el model Singleton.

Mostra les dades de cada instància al final (caldrà sobreescriure toString) */

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
        Objecte objecte2 = Objecte.getInstance("Joan", "Perez", 25);
        Objecte objecte3 = Objecte.getInstance("Maria", "Gomez", 30);

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