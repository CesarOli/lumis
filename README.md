# Desafio Técnico - Backend Java (Lumis)

Este repositório contém a solução para o teste técnico de Desenvolvedor Backend.
O projeto foi estruturado utilizando **Java 17**, **Maven** e **JUnit 5** para validação automatizada dos algoritmos.

## 🚀 Como Rodar os Testes

Para verificar a solução das questões práticas (1, 2 e 4), execute os testes unitários via Maven ou pela sua IDE.

## 📋 Respostas dos questionamentos apresentados

### Questão 3: Revisão de Código (Code Review)

Observei os seguintes pontos:
1.  **Erro de Sintaxe (Atribuição vs Comparação):** Na linha 1, foi utilizado o operador de atribuição `=` em vez de comparação. O correto seria usar `equals`.
2.  **NullPointerException:** Na linha 2 (`person.getName().equals("jan")`), há um grande risco de erro caso `person.getName()` retorne `null`.
3.  **Comparação de Strings:** O uso de operadores lógicos para comparação de Strings não é recomendado em Java, pois compara as referências de memória utilizadas na aplicação.
4.  **Correção Sugerida:** A linha 5 (`"jan".equals(person.getName())`) apresenta a melhor prática, pois é segura contra nulos (Null-Safe).

### Questão 5: Por que String é imutável?

A imutabilidade da String na linguagem Java é uma decisão de design arquitetural que tem como objetivo:
* **Segurança:** Impede que dados sensíveis (usuários, senhas, conexões) sejam alterados em memória após a verificação de segurança.
* **Thread Safety:** Permite que Strings sejam compartilhadas entre múltiplas threads sem risco de concorrência, essencial para aplicações Web robustas.
* **Performance (String Pool):** Permite que a JVM armazene em memória apenas uma cópia de textos repetidos.

### Questão 6: Aspecto Favorito do Java

Meu aspecto favorito na linguagem de programação JAVA é  **Tipagem Estática e a Robustez da Sintaxe**.
Aprecio como a linguagem realiza verificações rigorosas em tempo de compilação, o que evita uma série de erros surpresa em diversos ambientes de desenvolvimento, em especial no ambiente de produção (Runtime Exceptions).
Essa característica traz segurança para refatorar códigos legados e facilita a manutenção em grandes equipes, pois a própria sintaxe atua como uma documentação, deixando claro o que cada método espera receber e retornar.

---
**Autor:** César Oliveira