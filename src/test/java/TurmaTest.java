import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {

    @Test
    public void deveInstanciarTurma() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");
        Aula aula = new Aula(conteudo);
        Turma turma = new Turma(aula);

        assertEquals(aula, turma.getAula());
    }

    @Test
    void deveAdicionarAluno() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");
        Aula aula = new Aula(conteudo);
        Turma turma = new Turma(aula);
        Aluno aluno = new Aluno("Guilherme");

        turma.adicionarAluno(aluno);

        assertEquals(1, turma.getNumeroAlunos());
    }

    @Test
    void deveRemoverAluno() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");
        Aula aula = new Aula(conteudo);
        Turma turma = new Turma(aula);
        Aluno aluno = new Aluno("Guilherme");

        turma.removerAluno(aluno);

        assertEquals(0, turma.getNumeroAlunos());
    }

    @Test
    void deveVerificarAluno() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");
        Aula aula = new Aula(conteudo);
        Turma turma = new Turma(aula);
        Aluno aluno = new Aluno("Guilherme");
        turma.adicionarAluno(aluno);

        assertTrue(turma.verificarAluno(aluno));
    }

    @Test
    void naoDeveVerificarAluno() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");
        Aula aula = new Aula(conteudo);
        Turma turma = new Turma(aula);
        Aluno aluno = new Aluno("Guilherme");

        assertFalse(turma.verificarAluno(aluno));
    }
    
    @Test
    void deveRetornarNomeAlunos() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");
        Aula aula = new Aula(conteudo);
        Turma turma = new Turma(aula);
        Aluno aluno1 = new Aluno("Guilherme");
        Aluno aluno2 = new Aluno("Letycia");

        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);

        assertTrue(turma.getNomesAlunos().contains(aluno1.getNome()));
        assertTrue(turma.getNomesAlunos().contains(aluno2.getNome()));
    }
    
    
    @Test
    void deveRetornarExcecaoNomeAlunos() {
        try{
            Conteudo conteudo = new Conteudo();
            conteudo.setDescricao("Aula sobre segurança no transito");
            Aula aula = new Aula(conteudo);
            Turma turma = new Turma(aula);
            turma.getNomesAlunos();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Turma sem alunos", e.getMessage());
        }
    }

    @Test
    void deveRetornarNomeAlunosMock() {
        Aula aula = createMock(Aula.class);
        Turma turma = new Turma(aula);

        Aluno aluno = createMock(Aluno.class);
        expect(aluno.getNome()).andReturn("Guilherme");
        replay(aluno);

        turma.adicionarAluno(aluno);

        assertTrue(turma.getNomesAlunos().contains("Guilherme"));
    }

    @Test
    void deveVerificarAlunoMock() {
        Aula aula = createMock(Aula.class);
        replay(aula);

        Turma turma = new Turma(aula);
        Aluno aluno = new Aluno("Guilherme");
        turma.adicionarAluno(aluno);

        assertTrue(turma.verificarAluno(aluno));
    }

}