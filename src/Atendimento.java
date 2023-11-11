import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Atendimento {

    private LocalDate data;
    private String descricao;

    public Atendimento() {
    }

    public Atendimento(LocalDate data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString(){
        DateTimeFormatter formatoBr = DateTimeFormatter.
                ofPattern("dd/MM/yyyy");
        String data = formatoBr.format (this.data);
        String retorno = "Data: "+data;
        retorno += "   -   Informações: "
        +descricao;
        return retorno;
    }
}
