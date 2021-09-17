import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;
    private Aula aula;

    public Turma(Aula aula){
        if (aula == null) {
            throw new NullPointerException("Aula é brigatorio");
        }
        this.aula = aula;
        this.alunos = new ArrayList<Aluno>();
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public int getNumeroAlunos() {
        return this.alunos.size();
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public boolean verificarAluno(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public List getNomesAlunos() {
        if (this.alunos.size() == 0) {
            throw new NullPointerException("Turma sem alunos");
        }
        List<String> nomes = new ArrayList<String>();
        for (Aluno aluno : this.alunos) {
            nomes.add(aluno.getNome());
        }
        return nomes;
    }
}
