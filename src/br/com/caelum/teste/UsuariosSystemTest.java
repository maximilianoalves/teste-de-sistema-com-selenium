package br.com.caelum.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
	
	private FirefoxDriver driver;
	private UsuariosPage usuarios;
	
	@Before
	public void inicializa(){
		driver.get("http://localhost:8080/apenas-teste/limpa");
		this.driver = new FirefoxDriver();
		 this.usuarios = new UsuariosPage(driver);
	}
	
	@After
	public void finaliza(){
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuario() {
		usuarios.visita();
		usuarios.novo().cadastra("Maximiliano Alves", "maximilianodacruz@gmail.com");
		
		assertTrue(usuarios.existeNaListagem("Maximiliano Alves", "maximilianodacruz@gmail.com"));

	}
	@Test
	public void naoDeveAdicionarSemNome(){
		usuarios.visita();
		usuarios.novo().cadastraEmail("maximilianodacruz@gmail.com");
		
		assertTrue(usuarios.nomeObrigatorio("Nome obrigatorio!"));
		
	}
	
	@Test
	public void naoDeveAdicionarUsuario(){
		usuarios.visita();
		usuarios.novo().naoCadastra("");
		
		assertTrue(usuarios.nomeEEmailObrigatorio("Nome obrigatorio!", "E-mail obrigatorio!"));
	}
	
	@Test
    public void deveDeletarUmUsuario() {
		usuarios.visita();
        usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br");
        assertTrue(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));

        usuarios.deletaUsuarioNaPosicao(1);
        assertFalse(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));

    }
}
