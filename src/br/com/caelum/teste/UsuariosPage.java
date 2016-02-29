package br.com.caelum.teste;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsuariosPage {
	
	private WebDriver driver;
	
	public UsuariosPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void visita(){
		driver.get("http://localhost:8080/usuarios");
	}
	
	public NovoUsuarioPage novo(){
		WebElement botao = driver.findElement(By.linkText("Novo Usuário"));
		botao.click();
		return new NovoUsuarioPage(driver);
	}
	
	public boolean existeNaListagem(String nome, String email){
		return	driver.getPageSource().contains(nome) &&
				driver.getPageSource().contains(email);
	}
	
	public boolean nomeObrigatorio(String nomeObrigatorio){
		return	driver.getPageSource().contains(nomeObrigatorio);
	}
	
	public boolean nomeEEmailObrigatorio(String nomeObrigatorio, String emailObrigatorio){
		return	driver.getPageSource().contains(nomeObrigatorio) &&
				driver.getPageSource().contains(emailObrigatorio);
	}
	
	public void deletaUsuarioNaPosicao(int posicao) {
	       driver.findElements(By.tagName("button")).get(posicao-1).click();
	       // pega o alert que está aberto
	       Alert alert = driver.switchTo().alert();
	       // confirma
	       alert.accept();
	    }
	
	
}
