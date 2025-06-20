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
        
        Arrays.sort(pontos);
        int numParadas = 0;
        double posicaoAtual = 0.0;  
        int index = 0;               

        while (posicaoAtual + d < L) {
            double alcanceMaximo = posicaoAtual + d;
            double proximaParada = posicaoAtual; 
            
            
            while (index < pontos.length && pontos[index] <= alcanceMaximo) {
                proximaParada = pontos[index];
                index++;
            }
            
            
            if (proximaParada == posicaoAtual) {
                return -1;
            }
            
            
            posicaoAtual = proximaParada;
            numParadas++;
        }
        
        return numParadas;
    }

}