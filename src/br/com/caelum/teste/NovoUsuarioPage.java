package br.com.caelum.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoUsuarioPage {
	
	private WebDriver driver;
	
	public NovoUsuarioPage(WebDriver driver){
		this.driver = driver;
	}

	public void cadastra(String nome, String email){
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));	
		WebElement botao = driver.findElement(By.id("btnSalvar"));
		txtNome.sendKeys(nome);
		txtEmail.sendKeys(email);
		botao.click();
	}
	public void cadastraEmail(String email){
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));	
		
		txtEmail.sendKeys(email);
		txtEmail.submit();
	}
	public void naoCadastra(String vazio){
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));	
		WebElement botao = driver.findElement(By.id("btnSalvar"));
		
		txtEmail.sendKeys(vazio);
		botao.click();
	}
}
