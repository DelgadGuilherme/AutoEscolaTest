import java.util.TimeZone;

public class Aula {

    private Conteudo conteudo;
    private Professor professor;

    public Aula(Conteudo conteudo){
        if (conteudo == null) {
            throw new NullPointerException("Conteudo é obrigatorio");
        }
        this.conteudo = conteudo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNomeProfessor() {
        if (professor == null) {
            return "Aula sem professor";
        }
        return professor.getNome();
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public String getDescricaoConteudo() {
        return this.conteudo.getDescricao();
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

}
