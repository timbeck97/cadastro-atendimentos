import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;

    private List<Atendimento> atendimentos;

    public Paciente() {
    }

    public Paciente(String nome, String sobrenome, LocalDate dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Atendimento> getAtendimentos() {
        if(atendimentos==null)
            atendimentos = new ArrayList<>();
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
    public int getIdade(){
        LocalDate now = LocalDate.now();
        Period periodo= Period.between(dataNascimento, now);
        return periodo.getYears();
    }

    @Override
    public String toString() {
        String retorno = "Nome: "+nome+" "+sobrenome+"   -    ";
        DateTimeFormatter formatoBr = DateTimeFormatter.
                ofPattern ("dd/MM/yyyy");
        String data = formatoBr. format (this. dataNascimento);
        retorno += "Data de nascimento:"
        +data+"   -    ";
        retorno += "Idade: "
        +getIdade();
        return retorno;
    }
}
