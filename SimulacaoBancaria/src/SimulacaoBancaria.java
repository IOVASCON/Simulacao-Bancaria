import java.util.InputMismatchException;
import java.util.Scanner;

public class SimulacaoBancaria {

    // Método principal que inicia a execução do programa
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler entradas do usuário
        Scanner scanner = new Scanner(System.in);
        // Variável para armazenar o saldo da conta
        double saldo = 0;

        // Loop infinito para manter o programa em execução até que o usuário escolha encerrar
        while (true) {
            // Exibe o menu de opções para o usuário
            System.out.println("Escolha uma opção:");
            System.out.println("1: Depositar");
            System.out.println("2: Sacar");
            System.out.println("3: Consultar Saldo");
            System.out.println("0: Encerrar");

            // Variável para armazenar a opção escolhida pelo usuário
            int opcao;
            try {
                // Lê a opção escolhida pelo usuário
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                // Captura exceção de entrada inválida e exibe uma mensagem de erro
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpa a entrada inválida
                continue; // Volta ao início do loop
            }

            // Estrutura switch para tratar cada opção do menu
            switch (opcao) {
                case 1 -> {
                    // Caso o usuário escolha Depositar
                    System.out.print("Digite o valor a ser depositado: ");
                    double deposito;
                    try {
                        // Lê o valor a ser depositado
                        deposito = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        // Captura exceção de entrada inválida e exibe uma mensagem de erro
                        System.out.println("Entrada inválida. Por favor, insira um número.");
                        scanner.next(); // Limpa a entrada inválida
                        continue; // Volta ao início do loop
                    }
                    // Atualiza o saldo com o valor depositado
                    saldo += deposito;
                    // Exibe o saldo atualizado
                    System.out.println("Saldo atual: " + saldo);
                }
                case 2 -> {
                    // Caso o usuário escolha Sacar
                    System.out.print("Digite o valor a ser sacado: ");
                    double saque;
                    try {
                        // Lê o valor a ser sacado
                        saque = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        // Captura exceção de entrada inválida e exibe uma mensagem de erro
                        System.out.println("Entrada inválida. Por favor, insira um número.");
                        scanner.next(); // Limpa a entrada inválida
                        continue; // Volta ao início do loop
                    }
                    // Verifica se há saldo suficiente para o saque
                    if (saque > saldo) {
                        // Exibe mensagem de saldo insuficiente
                        System.out.println("Saldo insuficiente.");
                    } else {
                        // Atualiza o saldo com o valor sacado
                        saldo -= saque;
                        // Exibe o saldo atualizado
                        System.out.println("Saldo atual: " + saldo);
                    }
                }
                case 3 -> {
                    // Caso o usuário escolha Consultar Saldo
                    // Exibe o saldo atual
                    System.out.println("Saldo atual: " + saldo);
                }
                case 0 -> {
                    // Caso o usuário escolha Encerrar
                    // Exibe mensagem de encerramento
                    System.out.println("Programa encerrado.");
                    // Fecha o Scanner
                    scanner.close();
                    // Encerra o programa
                    return;
                }
                default -> {
                    // Caso o usuário insira uma opção inválida
                    // Exibe mensagem de erro
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
}








