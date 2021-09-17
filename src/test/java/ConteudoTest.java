import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConteudoTest {

    @Test
    public void deveMudarDescricaoConteudo() {
        Conteudo conteudo = new Conteudo();

        conteudo.setDescricao("Aula sobre segurança no transito");
        assertEquals("Aula sobre segurança no transito", conteudo.getDescricao());
    }

}