package com.devops.dxc.devops;

import org.junit.Test;

import com.devops.dxc.devops.Utilidades.Utils;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

    private WebDriver driver;
	private Actions action;

    @Before
	public void setUp() {
		System.out.println("Iniciando configuración...");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8000");
		driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
		action = new Actions(driver);

	}

    @Test
	public void calculo10xCientoSaldoAhorradoSuperior150UFDeberiaDevolverMaximoRetiro() throws InterruptedException {
		System.out.println("Iniciando el test de la calculadora del 10%");
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("50000000");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoDXC = Utils.waitForElementPresence(driver, By.id("fila-resultado-dxc"), 30);
		System.out.println(resultadoDXC.getText());
		Thread.sleep(2000);
		Assert.assertEquals(resultadoDXC.getText(), "4350000");
	}


	@Test
	public void calculo10xCientoMenorIgual1MillonConSaldoAhorradoMayorIgual1MillonDeberiaDevolver1Millon() throws InterruptedException {		
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("9999999");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoDXC = Utils.waitForElementPresence(driver, By.id("fila-resultado-dxc"), 30);
		System.out.println(resultadoDXC.getText());
		Thread.sleep(2000);
		Assert.assertEquals(resultadoDXC.getText(), "1000000");
	}
    
}


