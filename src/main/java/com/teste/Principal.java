package com.teste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 - Inserir todos os funcionários na ordem da tabela
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        System.out.println("3.1 - Funcionários inseridos: " + funcionarios.size());

        // Imprimir funcionários na ordem
        System.out.println("\nFuncionários na ordem de inserção:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() +
                    ", Data Nascimento: " + funcionario.getDataNascimento() +
                    ", Salário: " + funcionario.getSalario() +
                    ", Função: " + funcionario.getFuncao());
        }

        // 3.2 - Remover o funcionário "João" da lista
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));
        System.out.println("\n3.2 - Funcionário João removido. Total: " + funcionarios.size());

        // 3.3 - Imprimir todos os funcionários com formatação
        System.out.println("\n3.3 - Funcionários com formatação:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() +
                    ", Data Nascimento: " + funcionario.getDataNascimentoFormatada() +
                    ", Salário: " + funcionario.getSalarioFormatado() +
                    ", Função: " + funcionario.getFuncao());
        }

        // 3.4 - Aumento de 10% nos salários
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal novoSalario = salarioAtual.multiply(new BigDecimal("1.10"));
            funcionario.setSalario(novoSalario);
        }
        System.out.println("\n3.4 - Aumento de 10% aplicado aos salários.");

        // 3.5 - Agrupar funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();
            funcionariosPorFuncao.computeIfAbsent(funcao, k -> new ArrayList<>()).add(funcionario);
        }
        System.out.println("\n3.5 - Funcionários agrupados por função: ");

        // 3.6 - Imprimir funcionários agrupados por função
        System.out.println("\n3.6 - Funcionários por função:");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("\nFunção: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                System.out.println("  - Nome: " + funcionario.getNome() +
                        ", Salário: " + funcionario.getSalarioFormatado());
            }
        }

    }
}
