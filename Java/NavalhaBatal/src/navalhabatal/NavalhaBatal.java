/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navalhabatal;

/**
 *
 * @author Marco
 */
public class NavalhaBatal {

    private Celula head;

    private class Celula {

        private Celula direita, abaixo;
        private int linha, coluna, valor;

    }

    public NavalhaBatal() {
        head = new Celula();
    }

    public void inicializarMatriz(int coluna, int linha) { // Cria uma matriz com n colunas e m linhas de sentinelas
        Celula auxMatriz = head;
        if (coluna < 1 || linha < 1) {
            throw new NullPointerException("O tamanho não pode ser nulo.");
        }
        for (int i = 1; i <= linha; i++) {
            try {
                Celula novo = new Celula();
                if (head.abaixo == null) {
                    head.abaixo = novo;
                    auxMatriz = novo;
                } else {
                    auxMatriz.abaixo = novo;
                    auxMatriz = novo;
                }
                novo.linha = i;
            } catch (NullPointerException e) {
                throw new NullPointerException("Linha nula não encontrada.");
            }
        }
        for (int j = 1; j <= coluna; j++) {
            Celula novo = new Celula();
            try {
                if (head.direita == null) {
                    head.direita = novo;
                    auxMatriz = novo;
                } else {
                    auxMatriz.direita = novo;
                    auxMatriz = novo;
                }
                novo.coluna = j;
            } catch (NullPointerException e) {
                throw new NullPointerException("Coluna nula não encontrada.");
            }
        }
    }

    public void addMatriz(int coluna, int linha, int valor) { // Método responsável por adicionar na coluna e linha passada por parametro o elemento com o valor tambem passado por parametro
        Celula auxColuna = head.direita;
        Celula auxLinha = head.abaixo;
        Celula novo = new Celula();
        while (auxColuna.coluna != coluna) {
            auxColuna = auxColuna.direita;
        }
        while (auxLinha.linha != linha) {
            auxLinha = auxLinha.abaixo;
        }
        while (auxColuna.abaixo != null) {
            if (auxColuna.abaixo.linha > linha) {
                novo.coluna = coluna;
                novo.linha = linha;
                novo.valor = valor;
                novo.abaixo = auxColuna.abaixo;
                auxColuna.abaixo = novo;
                break;
            } else if (auxColuna.abaixo.linha < linha - 1) {
                auxColuna = auxColuna.abaixo;
            } else {
                auxColuna = auxColuna.abaixo;
            }
        }
        if (auxColuna.abaixo == null) {
            novo.coluna = coluna;
            novo.linha = linha;
            novo.valor = valor;
            auxColuna.abaixo = novo;
        }
        while (auxLinha.direita != null) {
            if (auxLinha.direita.coluna > coluna) {
                novo.direita = auxLinha.direita;
                auxLinha.direita = novo;
                break;
            } else if (auxLinha.direita.coluna < coluna) {
                auxLinha = auxLinha.direita;
            } else if (auxColuna.direita != null) {
                if (auxColuna.direita.linha == linha) {
                    auxLinha.direita.valor = valor;
                    break;
                }
                auxLinha = auxLinha.direita;
            } else {
                auxLinha.direita.valor = valor;
                break;
            }
        }
        if (auxLinha.direita == null) {
            auxLinha.direita = novo;
            novo.coluna = auxColuna.coluna;
        }

    }

    @Override
    public String toString() { // Método responsável por imprimir os elementos da matriz esparsa
        StringBuilder sb = new StringBuilder();
        Celula aux = head;
        Celula auxColuna = head;
        while (aux.abaixo != null) {
            aux = aux.abaixo;
        }
        while (auxColuna.direita != null) {
            auxColuna = auxColuna.direita;
        }
        int coluna = auxColuna.coluna, linha = aux.linha;
        aux = head.abaixo;
        auxColuna = aux;
        for (int i = 1; i <= linha; i++) {
            for (int j = 1; j <= coluna; j++) {
                if (auxColuna.direita != null) {
                    while (j < auxColuna.direita.coluna) {
                        sb.append(0).append("  ");
                        j++;
                    }
                    sb.append(auxColuna.direita.valor).append("  ");
                    auxColuna = auxColuna.direita;
                } else {
                    sb.append(0).append("  ");
                }
            }
            sb.append("\n");
            aux = aux.abaixo;
            auxColuna = aux;
        }
        return sb.toString();
    }

    public int possibilities() { // Método responsável por imprimir os elementos da matriz esparsa
        Celula aux = head;
        Celula auxColuna = head;
        int possibilities = 0, cont = 0;

        while (aux.abaixo != null) {
            aux = aux.abaixo;
        }
        while (auxColuna.direita != null) {
            auxColuna = auxColuna.direita;
        }
        int coluna = auxColuna.coluna, linha = aux.linha;
        aux = head.abaixo;
        auxColuna = aux;
        for (int i = 1; i <= linha; i++) {
            for (int j = 1; j <= coluna; j++) {
                if (auxColuna.direita != null) {
                    while (j < auxColuna.direita.coluna) {
                        j++;
                        cont++;
                    }
                    possibilities = possibilities + ((1 + cont) * cont) / 2;
                    auxColuna = auxColuna.direita;
                    cont = 0;
                } else {
                    cont = coluna - auxColuna.coluna;
                    j = coluna;
                    possibilities = possibilities + ((1 + cont) * cont) / 2;
                    cont = 0;
                }
            }
            aux = aux.abaixo;
            auxColuna = aux;
        }
        aux = head.direita;
        auxColuna = aux;
        cont = 0;
        for (int i = 1; i <= coluna; i++) {
            for (int j = 1; j <= linha; j++) {
                if (auxColuna.abaixo != null) {
                    while (j < auxColuna.abaixo.linha) {
                        j++;
                        cont++;
                    }
                    possibilities = possibilities + ((1 + cont) * cont) / 2 - cont;
                    auxColuna = auxColuna.abaixo;
                    cont = 0;

                } else {
                    cont = linha - auxColuna.linha;
                    j = linha;
                    possibilities = possibilities + (((1 + cont) * cont) / 2) - cont;
                    cont = 0;
                }
            }
            aux = aux.direita;
            auxColuna = aux;
        }
        return possibilities;
    }
}
