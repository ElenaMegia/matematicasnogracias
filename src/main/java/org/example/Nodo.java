package org.example;

public class Nodo {
    private DatoPolinomio dato;
    private int exponente;
    private Nodo next;
    public Nodo(DatoPolinomio dato, int exponente) {
        this.dato = dato;
        this.exponente = exponente;
        this.next = null;
    }

    public DatoPolinomio getDato() {
        return dato;
    }

    public void setDato(DatoPolinomio dato) {
        this.dato = dato;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getNodo() {
        return this;
    }
}
