package br.com.caelum.argentum.aceitacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import junit.framework.Assert;

public class GeraGraficoTest {
private static final String URL = "http://localhost:8100/fj22-argentum-web/index.xhtml";
	

	

/*	  @Before
	  public void setUp() {
	    driver = new FirefoxDriver();
	  }
	    
	  @After
	  public void tearDown() {
	    driver.close();
	  }*/

	
	  @Test
	  public void testeAoGerarGraficoSemTituloUmaMensagemEhApresentada() {
		  System.setProperty("webdriver.gecko.driver", "C:\\geckod‌​‌​‌​river\\geckodriver.exe");
		   DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		    capabilities.setCapability("marionette", true);
		    WebDriver driver = new FirefoxDriver(capabilities);
		   //driver =  new FirefoxDriver(capabilities);
		   
		driver.navigate().to(URL);
		    WebElement titulo = driver.findElement(By.id("dadosGrafico:titulo"));

		    
		    titulo.sendKeys("");
		    titulo.submit();
		    
		    boolean existeMensagem = driver.getPageSource().contains("Erro"
		    		+ "de validação");
		    
		    Assert.assertTrue(existeMensagem);
		    driver.close();
	  }
	}



