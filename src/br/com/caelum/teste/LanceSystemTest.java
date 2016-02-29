package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanceSystemTest {
	
	private FirefoxDriver driver;
	private LeiloesPage leiloes;
	
	@Before
	public void inicializa(){
		driver = new FirefoxDriver();
		leiloes = new LeiloesPage(driver);
		
		driver.get("http://localhost:8080/apenas-teste/limpa");
		
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Ivan Ronaldo", "ivan@ronaldo.com");
		usuarios.novo().cadastra("José Eduardo", "jose@eduardo.com");
		
		LeiloesPage leiloes = new LeiloesPage(driver);
		leiloes.visita();
		leiloes.novo().preenche("Geladeira", 100, "Ivan Ronaldo", false);
	}
	
	@Test
	public void deveFazerUmLance(){
		DetalhesDoLeilaoPage lances = leiloes.detalhes(1);
		
		lances.lance("José Eduardo", 150);
		
		assertTrue(lances.existeLance("José Eduardo", 150));
	}
	
}
