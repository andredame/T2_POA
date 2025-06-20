package com.seuprojeto.rally;
import java.util.Arrays;

public class Rally {

    /**
     * Calcula o número mínimo de paradas necessárias para completar o rally.
     * 
     * @param pontos Array com as distâncias dos pontos de parada em relação ao início
     * @param L      Comprimento total da trilha
     * @param d      Distância máxima que pode ser percorrida em um dia
     * @return       Número mínimo de paradas ou -1 se não for possível completar o rally
     */
    public static int minParadas(double[] pontos, double L, double d) {
        // Ordena os pontos de parada por distância do início
        Arrays.sort(pontos);
        int numParadas = 0;
        double posicaoAtual = 0.0;  // Começa no ponto de partida (0 km)
        int index = 0;               // Índice para percorrer os pontos ordenados

        while (posicaoAtual + d < L) {
            double alcanceMaximo = posicaoAtual + d;
            double proximaParada = posicaoAtual; // Armazena o próximo ponto válido
            
            // Procura o ponto mais distante dentro do alcance atual
            while (index < pontos.length && pontos[index] <= alcanceMaximo) {
                proximaParada = pontos[index];
                index++;
            }
            
            // Se não foi encontrado um ponto válido, retorna falha
            if (proximaParada == posicaoAtual) {
                return -1;
            }
            
            // Atualiza a posição atual para o ponto escolhido e incrementa o contador
            posicaoAtual = proximaParada;
            numParadas++;
        }
        
        return numParadas;
    }

}