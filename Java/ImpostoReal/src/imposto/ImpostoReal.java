package imposto;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Marco
 */
public class ImpostoReal {

    static Cidade[] cidades;

    public static class Cidade {

        List<Caminho> caminhos = new LinkedList();
        boolean visitado = false;
        int imposto;
        int menorDistancia = 0;
    }

    public static class Caminho {

        int comprimento;
        int destino;
    }

    public static int recolheImpostos(int cidade, int impostoTotal, int capacidadeCarruagem) {
        int distanciaPercorrida = 0, ant;
        int capacAtual;
        cidades[cidade].visitado = true;
        List<Integer> cidadesParaVisitar = new LinkedList();
        List<Integer> caminhosParaVisitar = new LinkedList();
        Caminho proxCidade;

        while (cidades[1].imposto != impostoTotal) {
            capacAtual = 0;
            for (int i = 0; i < cidades[cidade].caminhos.size(); i++) {
                
                proxCidade = cidades[cidade].caminhos.get(i);
                
                if (cidades[proxCidade.destino].visitado == false) {
                    cidades[proxCidade.destino].visitado = true;
                    distanciaPercorrida += proxCidade.comprimento;
                    cidadesParaVisitar.add(0, cidade);
                    caminhosParaVisitar.add(0, proxCidade.comprimento);
                    cidade = proxCidade.destino;
                    i = -1;
                }
                
            }

            while (cidades[cidade].imposto != 0) {
                ant = caminhosParaVisitar.get(0);
                if (cidades[cidade].imposto > capacidadeCarruagem) {
                    capacAtual += capacidadeCarruagem;
                    cidades[cidade].imposto -= capacidadeCarruagem;
                    distanciaPercorrida += 2 * ant;
                } else {
                    distanciaPercorrida += ant;
                    capacAtual += cidades[cidade].imposto;
                    cidades[cidade].imposto = 0;
                }
            }

            cidade = cidadesParaVisitar.remove(0);
            caminhosParaVisitar.remove(0);
            cidades[cidade].imposto += capacAtual;

        }

        return distanciaPercorrida;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int N = ler.nextInt();
        while (N < 2 || N > 10000) {
            N = ler.nextInt();
        }

        int capacidadeCarruagem = ler.nextInt();
        while (capacidadeCarruagem < 1 || capacidadeCarruagem > 100) {
            capacidadeCarruagem = ler.nextInt();
        }
        cidades = new Cidade[N + 1];
        for (int i = 0; i < cidades.length; i++) {
            cidades[i] = new Cidade();
        }
        int impostoTotal = 0;
        for (int i = 1; i <= N; i++) {
            cidades[i].imposto = ler.nextInt();
            impostoTotal += cidades[i].imposto;
        }

        int part, cheg, cami;
        for (int i = 0; i < N - 1; i++) {
            part = ler.nextInt();
            cheg = ler.nextInt();
            cami = ler.nextInt();

            Caminho caminho = new Caminho();
            caminho.destino = cheg;
            caminho.comprimento = cami;
            cidades[part].caminhos.add(caminho);

            caminho = new Caminho();
            caminho.destino = part;
            caminho.comprimento = cami;
            cidades[cheg].caminhos.add(caminho);

        }
        System.out.println(recolheImpostos(1, impostoTotal, capacidadeCarruagem));
    }
}
