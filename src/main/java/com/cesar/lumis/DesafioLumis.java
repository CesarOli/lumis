package com.cesar.lumis;

import java.util.List;
import java.util.stream.Collectors;

public class DesafioLumis {

    /**
     * Fatorial
     */
    public long calcularFatorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Fatorial não é definido para números negativos.");
        }

        if (numero <= 1) {
            return 1;
        }

        return numero * calcularFatorial(numero - 1);
    }

    /**
     * Palíndromo
     */
    public boolean verificarPalindromo(String palavra) {
        if (palavra == null || palavra.isEmpty()) {
            return false;
        }

        String palavraLimpa = palavra.replaceAll("\\s+", "").toLowerCase();
        String palavraInvertida = new StringBuilder(palavraLimpa).reverse().toString();

        return palavraLimpa.equals(palavraInvertida);
    }

    /**
     * Classe Modelo
     */
    public static class Carro {
        private String modelo;
        private String cor;

        public Carro(String modelo, String cor) {
            this.modelo = modelo;
            this.cor = cor;
        }

        public String getModelo() { return modelo; }
        public String getCor() { return cor; }
    }

    /**
     * 4) Filtrar Carros
     */
    public List<Carro> filtrarCarrosPretos(List<Carro> carros) {
        if (carros == null) {
            return List.of();
        }

        return carros.stream()
                .filter(carro -> carro != null && carro.getCor() != null && "preta".equalsIgnoreCase(carro.getCor()))
                .collect(Collectors.toList());
    }
}