package br.com.caelum.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeiloesSystemTest {

	private FirefoxDriver driver;
	private LeiloesPage leiloes;
	
	@Before
	public void inicializa(){
		driver.get("http://localhost:8080/apenas-teste/limpa");
		this.driver = new FirefoxDriver();
		 this.leiloes = new LeiloesPage(driver);
		 
		 UsuariosPage usuarios = new UsuariosPage(driver);
		 usuarios.visita();
		 usuarios.novo().cadastra("Ronaldo Alves", "maximilianoalves@gmail.com");
	}
	
	@Test
	public void deveCadastrarUmLeilao(){
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Geladeira", 123, "Ronaldo Alves", true);
		
		assertTrue(leiloes.existe("Geladeira", 123, "Ronaldo Alves", true));
	}
}
