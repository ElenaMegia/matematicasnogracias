package org.example;
public class DatoPolinomio {
    private double valor = 0;
    private Nodo nodo;

    public DatoPolinomio() {
        this.valor = 0;
        this.nodo = null;
    }

    public DatoPolinomio(double coeficiente, int exponente) {
        this.valor = 0;
        this.nodo = new Nodo(new DatoPolinomio(), exponente);
        this.nodo.getDato().agregarTermino(coeficiente, 0);
    }



    public void agregarTermino(double coeficiente, int exponente) {
        if (coeficiente != 0) {
            Nodo nuevoNodo = new Nodo(new DatoPolinomio(coeficiente, 0), exponente);
            if (this.nodo == null) {
                this.nodo = nuevoNodo;
            } else {
                Nodo actual = this.nodo;
                Nodo anterior = null;
                while (actual != null && actual.getExponente() > exponente) {
                    anterior = actual;
                    actual = actual.getNext();
                }
                if (actual != null && actual.getExponente() == exponente) {
                    actual.getDato().agregarTermino(coeficiente, 0);
                    if (actual.getDato().getValor() == 0) {
                        eliminarTermino(exponente);
                    }
                } else {
                    nuevoNodo.setNext(actual);
                    if (anterior == null) {
                        this.nodo = nuevoNodo;
                    } else {
                        anterior.setNext(nuevoNodo);
                    }
                }
            }
            this.valor += coeficiente;
        }
    }

    public void eliminarTermino(int exponente) {
        if (this.nodo != null) {
            if (this.nodo.getExponente() == exponente) {
                this.valor -= this.nodo.getDato().getValor();
                this.nodo = this.nodo.getNext();
            } else {
                Nodo actual = this.nodo;
                Nodo anterior = null;
                while (actual != null && actual.getExponente() != exponente) {
                    anterior = actual;
                    actual = actual.getNext();
                }
                if (actual != null) {
                    this.valor -= actual.getDato().getValor();
                    if (anterior == null) {
                        this.nodo = actual.getNext();
                    } else {
                        anterior.setNext(actual.getNext());
                    }
                }
            }
        }
    }

    public String getInformacionDelPolinomio() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = this.nodo;
        while (actual != null) {
            double coeficiente = actual.getDato().getValor();
            int exponente = actual.getExponente();
            if (coeficiente > 0 && sb.length() > 0) {
                sb.append("+");
            }
            if (coeficiente == -1) {
                sb.append("-");
            } else if (coeficiente != 1) {
                sb.append(coeficiente);
            }
            if (exponente > 1) {
                sb.append("x^").append(exponente);
            } else if (exponente == 1) {
                sb.append("x");
            }
            actual = actual.getNext();
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }


    public double getValor() {
        return valor;
    }

    public Nodo getNodo() {
        return nodo;
    }
}