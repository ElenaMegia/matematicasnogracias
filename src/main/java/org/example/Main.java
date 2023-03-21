package org.example;

public class Main {
    public static void main(String[] args) {
        //Crea el polinomio1
        Polinomio polinomio1 = new Polinomio();
        polinomio1.agregarTermino(2, 3);
        //crea el polinomio2
        Polinomio polinomio2 = new Polinomio();
        polinomio2.agregarTermino(3, 2);
        polinomio2.agregarTermino(4, 1);
        polinomio2.agregarTermino(5, 0);
        //suma los polinomios
        Polinomio polinomio3 = polinomio1.sumar(polinomio2);
        //imprime el polinomio3
        System.out.println(polinomio3.getInformacionDelPolinomio());

    }
}