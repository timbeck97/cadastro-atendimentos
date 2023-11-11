import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    Scanner sc;
    List<Paciente> pacientes;

    public Service(Scanner sc) {
        this.sc=sc;
        this.pacientes = new ArrayList<>();
        this.pacientes.add(new Paciente("TIM", "MAIA", LocalDate.parse("28/09/1942", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }

    public void cadastrarPaciente(){
        clearBuffer(sc);
        System.out.println("Digite o nome do paciente:");
        String nome = sc.nextLine();
        System.out.println("Digite o sobrenome do paciente:");
        String sobrenome = sc.nextLine();
        System.out.println("Digite a data de nascimento do paciente (dd/MM/yyyy): ");
        String dataNascimento = sc.next();
        try{
            pacientes.add(new Paciente(nome, sobrenome, LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            System.out.println("Paciente cadastrado com sucesso!");

        }catch (DateTimeException e){
            System.out.println("Data inválida, operação cancelada!");
        }
        aguardar();
    }
    public void alterarDadosPaciente(){
        clearBuffer(sc);
        System.out.println("Digite o primeiro nome do paciente:");
        String nome = sc.nextLine();
        Paciente paciente = pacientes
                .stream()
                .filter(p->p.getNome().equalsIgnoreCase(nome))
                .findFirst().orElse(null);
        if(paciente==null){
            System.out.println("Paciente não encontrado!");
            return;
        }
        System.out.println("Digite o novo nome do paciente:");
        String novoNome = sc.nextLine();
        System.out.println("Digite o novo sobrenome do paciente:");
        String novoSobrenome = sc.nextLine();
        System.out.println("Digite a nova data de nascimento do paciente (dd/MM/yyyy): ");
        String novaDataNascimento = sc.next();
        paciente.setNome(novoNome);
        paciente.setSobrenome(novoSobrenome);
        try{
            paciente.setDataNascimento(LocalDate.parse(novaDataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Dados do paciente alterados com sucesso!");
        }catch (DateTimeException e){
            System.out.println("Data inválida, operação cancelada!");
        }
        aguardar();
    }
    public void cadastrarAtendimento(){
        clearBuffer(sc);
        System.out.println("Digite o primeiro nome do paciente: ");
        String nome = sc.nextLine();
        Paciente paciente = pacientes
                .stream()
                .filter(p->p.getNome().equalsIgnoreCase(nome))
                .findFirst().orElse(null);
        if(paciente==null){
            System.out.println("Paciente não encontrado, operação cancelada!");
            return;
        }
        System.out.println("Digite a data do atendimento (dd/MM/yyyy): ");
        String dataAtendimento = sc.nextLine();
        System.out.println("Digite a descrição do atendimento: ");
        String descricao = sc.next();
        try{
            Atendimento atendimento = new Atendimento(LocalDate.parse(dataAtendimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")), descricao);
            paciente.getAtendimentos().add(atendimento);
            System.out.println("Atendimeto cadastrado com sucesso!");
        }catch (DateTimeException e){
            System.out.println("Data inválida, operação cancelada!");
        }
        aguardar();
    }
    public void listarPacientes(){
        if(pacientes.isEmpty()){
            System.out.println("Não há pacientes cadastrados!");
        }else{
            System.out.println("Pacientes cadastrados:");
            pacientes.forEach(System.out::println);
        }
        aguardar();
    }
    public void listarPacientesAtendimentos(){
        clearBuffer(sc);
        System.out.println("Digite o primeiro nome do paciente: ");
        String nome = sc.next();
        Paciente paciente = pacientes
                .stream()
                .filter(p->p.getNome().equalsIgnoreCase(nome))
                .findFirst().orElse(null);
        if(paciente==null){
            System.out.println("Paciente não encontrado, operação cancelada!");
            return;
        }
        System.out.println(paciente);
        System.out.println("\tAtendimentos: ");
        paciente.getAtendimentos().forEach(x->System.out.println("\t"+x));
        aguardar();
    }
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    private void aguardar(){
        clearBuffer(sc);
        System.out.println("\nPressione alguma tecla para continuar...");
        sc.nextLine();
    }

    public void deletarPaciente() {
        clearBuffer(sc);
        System.out.println("Digite o primeiro nome do paciente: ");
        String nome = sc.next();
        Paciente paciente = pacientes
                .stream()
                .filter(p->p.getNome().equalsIgnoreCase(nome))
                .findFirst().orElse(null);
        if(paciente==null){
            System.out.println("Paciente não encontrado, operação cancelada!");
            return;
        }
        pacientes.remove(paciente);
        System.out.println("Paciente removido com sucesso!");
        aguardar();
    }
}
