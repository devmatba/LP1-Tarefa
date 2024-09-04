import java.util.Scanner;

import entities.*;

public class TesteClasse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.println();
            System.out.println("             ---TAREFA 2 MENU---");
            System.out.println("[1] Carro ");
            System.out.println("[2] Cadeira");
            System.out.println("[3] Livro");
            System.out.println("[4] Relogio");
            System.out.println("[5] Celulares");
            System.out.println("[6] Computador");
            System.out.println("[7] Prato");
            System.out.println("[8] Sofá");
            System.out.println("[9] Geladeira");
            System.out.println("[10] Copo");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma das opções acima: ");
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    Carro carro = new Carro();
                    System.out.println("Digite a marca: ");
                    carro.marca = sc.next();
                    System.out.println("Digite o modelo: ");
                    carro.modelo = sc.next();
                    System.out.println("Digite a velocidade maxima: ");
                    carro.velocidadeMaxima = sc.nextInt();
                    carro.acelerar();
                    carro.frear();
                    carro.ligarMotor();
                    break;
                case 2:
                    Cadeira cadeira = new Cadeira("Média", "preta", "couro");
                    cadeira.sentar();
                    cadeira.reclinar();
                    cadeira.ajustarAltura();
                    break;
                case 3:
                    Livro livro = new Livro("Diurantia", "João Paulo", 55);
                    livro.abrir();
                    livro.virarPagina();
                    livro.fechar();
                    break;
                case 4:
                    Relogio relogio = new Relogio("Rolex", "Pulso", "Grande");
                    relogio.mostrarHora();
                    relogio.ajustarAlarme();
                    relogio.ajustarData();
                    break;
                case 5:
                    Celular celular = new Celular("Iphone", 1288888888, "Apple");
                    System.out.println("Para qual numero deseja ligar?");
                    celular.fazerChamada(sc.nextInt());
                    celular.receberChamada();
                    celular.desligar();
                    break;
                case 6:
                    Computador computador = new Computador("AMD", 16, 500);
                    computador.ligar();
                    System.out.println("Qual programa deseja abrir?");
                    computador.abrirPrograma(sc.next());
                    computador.telaAzul();
                    break;
                case 7:
                    Prato prato = new Prato("Vidro", 20, "marrom");
                    prato.empilhar();
                    prato.lavar();
                    prato.quebrar();
                    break;
                case 8:
                    Sofa sofa = new Sofa("Tecido", 6, "Azul");
                    sofa.massageador();
                    sofa.pessoasSentadas();
                    sofa.dobrarDescanso();
                    break;
                case 9:
                    Geladeira geladeira = new Geladeira("Eletrolux", 20, 10);
                    geladeira.resfriar();
                    System.out.print("Digite a nova temperatura:");
                    geladeira.ajustarTemperatura(sc.nextInt());
                    geladeira.descongelar();
                    break;
                case 10:
                    Copo copo = new Copo("Plastico", 700, "Vermelho");
                    System.out.println("Quantos ml serão adicionados ao copo?");
                    copo.encher(sc.nextDouble());
                    copo.esvaziar();
                    copo.lavar();
                    break;
            }


        } while (escolha != 0);

        System.out.println("FIM DO PROGRAMA");

        sc.close();
    }
}