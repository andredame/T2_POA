package com.seuprojeto.rally;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RallyTest {

    @Test
    public void testCenario1() {
        double[] pontos = {5, 9, 15, 18};
        assertEquals(2, Rally.minParadas(pontos, 20, 10));
    }

    @Test
    public void testCenario2() {
        double[] pontos = {5, 10, 15};
        assertEquals(1, Rally.minParadas(pontos, 20, 10));
    }

    @Test
    public void testCenario3() {
        double[] pontos = {};
        assertEquals(0, Rally.minParadas(pontos, 15, 20));
    }

    @Test
    public void testCenario4() {
        double[] pontos = {12, 25};
        assertEquals(-1, Rally.minParadas(pontos, 30, 10));
    }

    @Test
    public void testCenario5_LZero() {
        double[] pontos = {};
        assertEquals(0, Rally.minParadas(pontos, 0, 10));
    }

    @Test
    public void testCenario6_PrimeiraParadaForaDoAlcance() {
        double[] pontos = {15};
        assertEquals(-1, Rally.minParadas(pontos, 30, 10));
    }

    @Test
    public void testCenario7_ParadasEspacadasDemais() {
        double[] pontos = {5, 20, 35};
        assertEquals(-1, Rally.minParadas(pontos, 40, 10));
    }

    @Test
    public void testCenario8_JustoNoLimite() {
        double[] pontos = {10, 20, 30};
        assertEquals(3, Rally.minParadas(pontos, 30, 10));
    }

    @Test
    public void testCenario9_MuitasOpcoes() {
        double[] pontos = {2, 4, 6, 8, 10, 12};
        assertEquals(3, Rally.minParadas(pontos, 12, 5));
    }

    @Test
    public void testCenario10_SemPontosAlcanceSuficiente() {
        double[] pontos = {};
        assertEquals(0, Rally.minParadas(pontos, 10, 15));
    }

    @Test
    public void testCenario11_UltimaParadaObrigatoria() {
        double[] pontos = {7, 14, 19};
        assertEquals(2, Rally.minParadas(pontos, 20, 10));
    }

    @Test
    public void testCenario12_MuitosPontosProximos() {
        double[] pontos = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        assertEquals(4, Rally.minParadas(pontos, 20, 5));
    }

    @Test
    public void testCenario13_TrailLonga() {
        double[] pontos = new double[1000];
        for (int i = 0; i < 1000; i++) {
            pontos[i] = i * 5;  // pontos a cada 5 km
        }
        assertEquals(199, Rally.minParadas(pontos, 5000, 25));  // Exemplo de cálculo
    }

    @Test
    public void testCenarioGigante() {
        double L = 100_000;  // Distância total
        double d = 50;        // Alcance diário
        int numPontos = (int)(L / 10);  // Pontos a cada 10 km
        
        double[] pontos = new double[numPontos];
        for (int i = 0; i < numPontos; i++) {
            pontos[i] = i * 10;
        }

        int resultado = Rally.minParadas(pontos, L, d);

        // Como você percorre até 50 km por dia, o número de paradas esperado é:
        int esperado = (int)Math.ceil(L / d) - 1;

        System.out.println("Paradas calculadas: " + resultado);
        assertEquals(esperado, resultado);
    }
    @Test
    public void testCenarioExorbitante() {
        double L = 100_000_000;  // 100 milhões de km
        double d = 500;           // alcance diário de 50 km
        int numPontos = (int)(L / 10);  // ponto a cada 10 km -> 10 milhões de pontos
        
        double[] pontos = new double[numPontos];
        for (int i = 0; i < numPontos; i++) {
            pontos[i] = i * 10;
        }
        
        long startTime = System.currentTimeMillis();
        int resultado = Rally.minParadas(pontos, L, d);
        long endTime = System.currentTimeMillis();
        
        int esperado = (int)Math.ceil(L / d) - 1;
        
        System.out.println("Paradas calculadas: " + resultado);
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
        
        assertEquals(esperado, resultado);
    }


}
