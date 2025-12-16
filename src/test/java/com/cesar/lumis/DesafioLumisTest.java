package com.cesar.lumis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

class DesafioLumisTest {

    DesafioLumis desafio = new DesafioLumis();

    @Test
    @DisplayName("Calcular corretamente o fatorial de números positivos")
    void testeFatorialCaminhoOk() {
        long resultado = desafio.calcularFatorial(5);
        Assertions.assertEquals(120, resultado);

        Assertions.assertEquals(1, desafio.calcularFatorial(0));
        Assertions.assertEquals(1, desafio.calcularFatorial(1));
    }

    @Test
    @DisplayName("Lançar exceção para números negativos")
    void testeFatorialNumerosNegativos() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            desafio.calcularFatorial(-5);
        });
    }

    @Test
    @DisplayName("Identificar Palíndromos simples")
    void testePalindromoSimples() {
        Assertions.assertTrue(desafio.verificarPalindromo("ana"));
        Assertions.assertTrue(desafio.verificarPalindromo("Reviver")); // Teste de Maiúscula
        Assertions.assertTrue(desafio.verificarPalindromo("radar"));
    }

    @Test
    @DisplayName("Identificar Palíndromos com frases e espaços")
    void testePalindromoFrase() {
        // Esse é o teste que separa o Junior do Pleno
        Assertions.assertTrue(desafio.verificarPalindromo("A base do teto desaba"));
        Assertions.assertTrue(desafio.verificarPalindromo("Socorram me subi no onibus em Marrocos"));
    }

    @Test
    @DisplayName("Retornar false para não palíndromos")
    void testeNaoPalindromo() {
        Assertions.assertFalse(desafio.verificarPalindromo("Cesar"));
        Assertions.assertFalse(desafio.verificarPalindromo("Java"));
        Assertions.assertFalse(desafio.verificarPalindromo(null)); // Teste de segurança (Null)
    }

    @Test
    @DisplayName("Filtrar apenas carros pretos na lista")
    void testeFiltrarCarrosPretos() {
        // PREPARAÇÃO (Arrange)
        DesafioLumis.Carro c1 = new DesafioLumis.Carro("Fiat Uno", "Prata");
        DesafioLumis.Carro c2 = new DesafioLumis.Carro("Honda Civic", "Preta");
        DesafioLumis.Carro c3 = new DesafioLumis.Carro("Ford Ka", "preta");
        DesafioLumis.Carro c4 = new DesafioLumis.Carro("BMW", "Branco");

        List<DesafioLumis.Carro> garagem = List.of(c1, c2, c3, c4);

        List<DesafioLumis.Carro> filtrados = desafio.filtrarCarrosPretos(garagem);

        Assertions.assertEquals(2, filtrados.size(), "Deve encontrar 2 carros");
        Assertions.assertEquals("Honda Civic", filtrados.get(0).getModelo());
        Assertions.assertEquals("Ford Ka", filtrados.get(1).getModelo());
    }

    @Test
    @DisplayName("Retornar lista vazia se não houver carros pretos")
    void testeSemCarrosPretos() {
        List<DesafioLumis.Carro> garagem = List.of(
                new DesafioLumis.Carro("Fusca", "Azul"),
                new DesafioLumis.Carro("Ferrari", "Vermelha")
        );

        List<DesafioLumis.Carro> filtrados = desafio.filtrarCarrosPretos(garagem);
        Assertions.assertTrue(filtrados.isEmpty());
    }

    @Test
    @DisplayName("Lidar com listas nulas ou carros com cor nula (Segurança)")
    void testeSegurancaLista() {

        Assertions.assertTrue(desafio.filtrarCarrosPretos(null).isEmpty());

        List<DesafioLumis.Carro> garagemBugada = List.of(
                new DesafioLumis.Carro("Carro Fantasma", null)
        );
        Assertions.assertTrue(desafio.filtrarCarrosPretos(garagemBugada).isEmpty());
    }
}
