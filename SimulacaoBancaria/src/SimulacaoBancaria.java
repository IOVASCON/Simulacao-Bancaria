import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimulacaoBancaria {

    public static void main(String[] args) throws IOException {
        // Cria um BufferedReader para ler a entrada do usuário
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Inicializa a variável saldo com zero
        double saldo = 0;

        // Loop infinito para manter o programa em execução até que o usuário escolha
        // encerrar
        while (true) {
            // Exibe o menu de opções para o usuário
            System.out.println("Escolha uma opção:");
            System.out.println("1: Depositar");
            System.out.println("2: Sacar");
            System.out.println("3: Consultar Saldo");
            System.out.println("0: Encerrar");

            int opcao; // Variável para armazenar a opção escolhida pelo usuário

            try {
                // Lê a entrada do usuário para a opção e converte para inteiro
                opcao = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                // Captura exceções de formato de número e exibe uma mensagem de erro
                System.out.println("Entrada inválida. Por favor, insira um número.");
                continue; // Volta ao início do loop para tentar novamente
            }

            // Estrutura switch para tratar cada opção do menu
            switch (opcao) {
                case 1 -> {
                    // Caso o usuário escolha Depositar
                    System.out.print("Digite o valor a ser depositado: ");
                    double deposito; // Variável para armazenar o valor do depósito
                    try {
                        // Lê o valor a ser depositado e converte para double
                        deposito = Double.parseDouble(reader.readLine());
                    } catch (NumberFormatException e) {
                        // Captura exceções de formato de número e exibe uma mensagem de erro
                        System.out.println("Entrada inválida. Por favor, insira um número.");
                        continue; // Volta ao início do loop para tentar novamente
                    }
                    // Atualiza o saldo com o valor depositado
                    saldo += deposito;
                    // Exibe o saldo atualizado
                    System.out.printf("Saldo atual: %.1f%n", saldo);
                }
                case 2 -> {
                    // Caso o usuário escolha Sacar
                    System.out.print("Digite o valor a ser sacado: ");
                    double saque; // Variável para armazenar o valor do saque
                    try {
                        // Lê o valor a ser sacado e converte para double
                        saque = Double.parseDouble(reader.readLine());
                    } catch (NumberFormatException e) {
                        // Captura exceções de formato de número e exibe uma mensagem de erro
                        System.out.println("Entrada inválida. Por favor, insira um número.");
                        continue; // Volta ao início do loop para tentar novamente
                    }
                    // Verifica se há saldo suficiente para o saque
                    if (saque > saldo) {
                        // Exibe mensagem de saldo insuficiente
                        System.out.println("Saldo insuficiente.");
                    } else {
                        // Atualiza o saldo com o valor sacado
                        saldo -= saque;
                        // Exibe o saldo atualizado
                        System.out.printf("Saldo atual: %.1f%n", saldo);
                    }
                }
                case 3 -> {
                    // Caso o usuário escolha Consultar Saldo
                    // Exibe o saldo atual
                    System.out.printf("Saldo atual: %.1f%n", saldo);
                }
                case 0 -> {
                    // Caso o usuário escolha Encerrar
                    // Exibe mensagem de encerramento
                    System.out.println("Programa encerrado.");
                    return; // Encerra o programa
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
