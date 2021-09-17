import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class AulaTest {

    @Test
    public void deveIntanciarAula(){
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");

        Aula aula = new Aula(conteudo);
        assertEquals(conteudo, aula.getConteudo());
    }

    @Test
    public void deveRetornarExcecaoConteudoNulo(){
        try {
            Aula aula = new Aula(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Conteudo é obrigatorio", e.getMessage());
        }
    }

    @Test
    public void deveRetornarDescricaoConteudoAula() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");

        Aula aula = new Aula(conteudo);

        assertEquals("Aula sobre segurança no transito", aula.getDescricaoConteudo());
    }

    @Test
    public void deveRetornarProfessor() {
        Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");

        Professor professor = new Professor("Guilherme");

        Aula aula = new Aula(conteudo);
        aula.setProfessor(professor);

        assertEquals(professor, aula.getProfessor());
    }

    @Test
    public void deveRetornarNomeProfessor() {

       Conteudo conteudo = new Conteudo();
        conteudo.setDescricao("Aula sobre segurança no transito");

        Professor professor = new Professor("Guilherme");

        Aula aula = new Aula(conteudo);
        aula.setProfessor(professor);

        assertEquals("Guilherme", aula.getNomeProfessor());
    }

    @Test
    public void deveRetornarAulaSemProfessor() {
            Conteudo conteudo = new Conteudo();
            conteudo.setDescricao("Aula sobre segurança no transito");

            Aula aula = new Aula(conteudo);

            assertEquals("Aula sem professor", aula.getNomeProfessor());
    }

    @Test
    public void deveRetornarNomeProfessorMock() {
        Conteudo conteudo = new Conteudo();

        Professor professor = createMock(Professor.class);
        expect(professor.getNome()).andReturn("Guilherme");
        replay(professor);

        Aula aula = new Aula(conteudo);
        aula.setProfessor(professor);

        assertEquals("Guilherme", aula.getNomeProfessor());
    }

    @Test
    public void deveRetornarDescricaoConteudoAulaMock() {
        Conteudo conteudo = createMock(Conteudo.class);
        expect(conteudo.getDescricao()).andReturn("Aula sobre segurança no transito");
        replay(conteudo);

        Aula aula = new Aula(conteudo);

        assertEquals("Aula sobre segurança no transito", aula.getDescricaoConteudo());
    }

}