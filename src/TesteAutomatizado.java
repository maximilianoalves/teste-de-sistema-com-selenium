import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com.br");
		
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("Caelum");
		
		campoDeTexto.submit();
	}
}
