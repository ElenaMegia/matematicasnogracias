package org.example;



public class Polinomio {
    private DatoPolinomio dato;

    public Polinomio() {
        this.dato = new DatoPolinomio();
    }

    public Polinomio(double coeficiente, int exponente) {
        this.dato = new DatoPolinomio(coeficiente, exponente);
    }

    public void agregarTermino(double coeficiente, int exponente) {
        this.dato.agregarTermino(coeficiente, exponente);
    }

    public void eliminarTermino(int exponente) {
        this.dato.eliminarTermino(exponente);
    }

    public String getInformacionDelPolinomio() {
        return this.dato.getInformacionDelPolinomio();
    }

    public double getValor() {
        return this.dato.getValor();
    }

    public Polinomio sumar(Polinomio otro) {
        Polinomio resultado = new Polinomio();
        Nodo actual1 = this.dato.getNodo();
        Nodo actual2 = otro.dato.getNodo();
        while (actual1 != null || actual2 != null) {
            if (actual1 == null || (actual2 != null && actual2.getExponente() > actual1.getExponente())) {
                resultado.agregarTermino(actual2.getDato().getValor(), actual2.getExponente());
                actual2 = actual2.getNext();
            } else if (actual2 == null || (actual1 != null && actual1.getExponente() > actual2.getExponente())) {
                resultado.agregarTermino(actual1.getDato().getValor(), actual1.getExponente());
                actual1 = actual1.getNext();
            } else {
                double coeficiente = actual1.getDato().getValor() + actual2.getDato().getValor();
                resultado.agregarTermino(coeficiente, actual1.getExponente());
                actual1 = actual1.getNext();
                actual2 = actual2.getNext();
            }
        }
        return resultado;
    }

    public Polinomio restar(Polinomio otro) {
        Polinomio resultado = new Polinomio();
        Nodo actual1 = this.dato.getNodo();
        Nodo actual2 = otro.dato.getNodo();
        while (actual1 != null || actual2 != null) {
            if (actual1 == null || (actual2 != null && actual2.getExponente() > actual1.getExponente())) {
                resultado.agregarTermino(-actual2.getDato().getValor(), actual2.getExponente());
                actual2 = actual2.getNext();
            } else if (actual2 == null || (actual1 != null && actual1.getExponente() > actual2.getExponente())) {
                resultado.agregarTermino(actual1.getDato().getValor(), actual1.getExponente());
                actual1 = actual1.getNext();
            } else {
                double coeficiente = actual1.getDato().getValor() - actual2.getDato().getValor();
                resultado.agregarTermino(coeficiente, actual1.getExponente());
                actual1 = actual1.getNext();
                actual2 = actual2.getNext();
            }
        }
        return resultado;
    }

    //crea el metodo multiplicar polinomio
    public Polinomio multiplicar(Polinomio otro) {
        Polinomio resultado = new Polinomio();
        Nodo actual1 = this.dato.getNodo();
        Nodo actual2 = otro.dato.getNodo();
        while (actual1 != null) {
            while (actual2 != null) {
                double coeficiente = actual1.getDato().getValor() * actual2.getDato().getValor();
                int exponente = actual1.getExponente() + actual2.getExponente();
                resultado.agregarTermino(coeficiente, exponente);
                actual2 = actual2.getNext();
            }
            actual1 = actual1.getNext();
            actual2 = otro.dato.getNodo();
        }
        return resultado;
    }

    //crea el metodo dividir polinomio
    public Polinomio dividir(Polinomio otro) {
        Polinomio resultado = new Polinomio();
        Nodo actual1 = this.dato.getNodo();
        Nodo actual2 = otro.dato.getNodo();
        while (actual1 != null) {
            while (actual2 != null) {
                double coeficiente = actual1.getDato().getValor() / actual2.getDato().getValor();
                int exponente = actual1.getExponente() - actual2.getExponente();
                resultado.agregarTermino(coeficiente, exponente);
                actual2 = actual2.getNext();
            }
            actual1 = actual1.getNext();
            actual2 = otro.dato.getNodo();
        }
        return resultado;
    }
}
