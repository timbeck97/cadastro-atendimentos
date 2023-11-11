import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao sistema de atendimento médico!");
        Scanner sc=new Scanner(System.in);
        Service service = new Service(sc);
        while (true){
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Cadastrar atendimento");
            System.out.println("3 - Alterar paciente");
            System.out.println("4 - Listar pacientes");
            System.out.println("5 - Listar atendimentos");
            System.out.println("6 - Deletar paciente");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");
            int opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Cadastrar paciente");
                    service.cadastrarPaciente();
                    break;
                case 2:
                    System.out.println("Cadastrar atendimento");
                    service.cadastrarAtendimento();
                    break;
                case 3:
                    System.out.println("Alterar paciente");
                    service.alterarDadosPaciente();
                    break;
                case 4:
                    service.listarPacientes();
                    break;
                case 5:
                    System.out.println("Listar atendimentos");
                    service.listarPacientesAtendimentos();
                    break;
                case 6:
                    System.out.println("Deletar paciente");
                    service.deletarPaciente();
                    break;
                case 7:
                    System.out.println("Sair");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }


}