import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coletando a primeira fração
        System.out.println("Digite o numerador da primeira fração: ");
        int numerador1 = scanner.nextInt();
        System.out.println("Digite o denominador da primeira fração: ");
        int denominador1 = scanner.nextInt();

        Fracao resultado = new Fracao(numerador1, denominador1);

        while (true) {
            // Escolhendo a operação
            System.out.println("Escolha a operação a ser realizada: ");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("5 - Finalizar e mostrar o resultado");
            int operacao = scanner.nextInt();

            // Finaliza o loop se o usuário escolher "5"
            if (operacao == 5) {
                break;
            }

            // Verifica se o usuário deseja realizar uma operação com prioridade (parênteses)
            System.out.println("Deseja realizar uma operação prioritária (em parênteses) antes dessa? (1 - Sim / 2 - Não)");
            int escolhaPrioridade = scanner.nextInt();

            Fracao proximaFracao;

            if (escolhaPrioridade == 1) {
                // Coletando a primeira fração da operação prioritária
                System.out.println("Digite o numerador da primeira fração dentro dos parênteses: ");
                int numeradorParenteses1 = scanner.nextInt();
                System.out.println("Digite o denominador da primeira fração dentro dos parênteses: ");
                int denominadorParenteses1 = scanner.nextInt();
                Fracao fracaoParenteses1 = new Fracao(numeradorParenteses1, denominadorParenteses1);

                // Escolhendo a operação dentro dos parênteses
                System.out.println("Escolha a operação dentro dos parênteses: ");
                System.out.println("1 - Soma");
                System.out.println("2 - Subtração");
                System.out.println("3 - Multiplicação");
                System.out.println("4 - Divisão");
                int operacaoParenteses = scanner.nextInt();

                // Coletando a segunda fração dentro dos parênteses
                System.out.println("Digite o numerador da segunda fração dentro dos parênteses: ");
                int numeradorParenteses2 = scanner.nextInt();
                System.out.println("Digite o denominador da segunda fração dentro dos parênteses: ");
                int denominadorParenteses2 = scanner.nextInt();
                Fracao fracaoParenteses2 = new Fracao(numeradorParenteses2, denominadorParenteses2);

                // Realizando a operação dentro dos parênteses
                switch (operacaoParenteses) {
                    case 1:
                        proximaFracao = fracaoParenteses1.somar(fracaoParenteses2);
                        break;
                    case 2:
                        proximaFracao = fracaoParenteses1.subtrair(fracaoParenteses2);
                        break;
                    case 3:
                        proximaFracao = fracaoParenteses1.multiplicar(fracaoParenteses2);
                        break;
                    case 4:
                        proximaFracao = fracaoParenteses1.dividir(fracaoParenteses2);
                        break;
                    default:
                        System.out.println("Operação inválida. Tente novamente.");
                        continue;
                }
            } else {
                // Coletando a próxima fração normalmente
                System.out.println("Digite o numerador da próxima fração: ");
                int numerador2 = scanner.nextInt();
                System.out.println("Digite o denominador da próxima fração: ");
                int denominador2 = scanner.nextInt();
                proximaFracao = new Fracao(numerador2, denominador2);
            }

            // Realizando a operação global (fora dos parênteses)
            switch (operacao) {
                case 1:
                    resultado = resultado.somar(proximaFracao);
                    break;
                case 2:
                    resultado = resultado.subtrair(proximaFracao);
                    break;
                case 3:
                    resultado = resultado.multiplicar(proximaFracao);
                    break;
                case 4:
                    resultado = resultado.dividir(proximaFracao);
                    break;
                default:
                    System.out.println("Operação inválida. Tente novamente.");
                    break;
            }
        }

        // Exibindo o resultado final
        System.out.println("O resultado final é: " + resultado);

        scanner.close();
    }
}
