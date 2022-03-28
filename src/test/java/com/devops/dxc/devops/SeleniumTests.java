package com.devops.dxc.devops;

import com.devops.dxc.devops.Utilidades.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.out.println("Iniciando configuración...");

        String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            System.out.println("Your Operating System is - Windows");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        } else if (os.contains("Mac OS X")) {
            System.out.println("Your Operating System is - macOS");
        } else if (os.contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            System.out.println("Your Operating System is - Linux");
        } else {
            System.out.println("Your Operating System is " + os);
        }
        driver = new ChromeDriver();
        driver.get("http://localhost:8000");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

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
        assertEquals(resultadoDXC.getText(), "4350000");
    }

    @Test
    public void calculo10xCientoMenorIgual1MillonConSaldoAhorradoMayorIgual1MillonDeberiaDevolver1Millon()
            throws InterruptedException {
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("9999999");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoDXC = Utils.waitForElementPresence(driver, By.id("fila-resultado-dxc"), 30);
        System.out.println(resultadoDXC.getText());
        Thread.sleep(2000);
        assertEquals(resultadoDXC.getText(), "1000000");
    }

    @Test
    public void calculo10xCientoSaldoAhorradoMenor1MillonDeberiaDevolverSaldoAhorrado() throws InterruptedException {
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("900000");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoDXC = Utils.waitForElementPresence(driver, By.id("fila-resultado-dxc"), 30);
        System.out.println(resultadoDXC.getText());
        Thread.sleep(2000);
        assertEquals(resultadoDXC.getText(), "900000");
    }

    @Test
    public void calculo10xCientoCasoBaseDeberiaDevolver10xCientoDelSaldoAhorrado() throws InterruptedException {
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("25000000");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoDXC = Utils.waitForElementPresence(driver, By.id("fila-resultado-dxc"), 30);
        System.out.println(resultadoDXC.getText());
        Thread.sleep(2000);
        assertEquals(resultadoDXC.getText(), "2500000");
    }

    @Test
    public void calculoImpuestoAlRetirarDeberiaDevolver10xCientoDelRetiro() throws InterruptedException {
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("25000000");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoImpuesto = Utils.waitForElementPresence(driver, By.id("fila-resultado-impuesto"), 30);
        System.out.println(resultadoImpuesto.getText());
        Thread.sleep(2000);
        assertEquals(resultadoImpuesto.getText(), "250000");
    }

    @Test
    public void calculoSaldoDespuesDelRetiroCasoBaseDeberiaDevolverSaldoAhorradoMenosRetiro()
            throws InterruptedException {
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("25000000");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoSaldo = Utils.waitForElementPresence(driver, By.id("fila-resultado-saldo"), 30);
        System.out.println(resultadoSaldo.getText());
        Thread.sleep(2000);
        assertEquals(resultadoSaldo.getText(), "$22500000");
    }

    @Test
    public void calculoSaldoDespuesDeMaximoRetiroDeberiaDevolverSaldoAhorradoMenosMontoMaximoRetiro()
            throws InterruptedException {
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("50000000");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoSaldo = Utils.waitForElementPresence(driver, By.id("fila-resultado-saldo"), 30);
        System.out.println(resultadoSaldo.getText());
        Thread.sleep(2000);
        assertEquals(resultadoSaldo.getText(), "$45650000");
    }

    @Test
    public void calculoSaldoDespuesDeMinimoRetiroDeberiaDevolverSaldoAhorradoMenosMontoMinimoRetiro()
            throws InterruptedException {
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("9999999");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoSaldo = Utils.waitForElementPresence(driver, By.id("fila-resultado-saldo"), 30);
        System.out.println(resultadoSaldo.getText());
        Thread.sleep(2000);
        assertEquals(resultadoSaldo.getText(), "$8999999");
    }

    @Test
    public void calculoSaldoDespuesDeRetirarTodoAhorroDeberiaDevolver0() throws InterruptedException {
        WebElement inputAhorro = Utils.waitForElementPresence(driver, By.id("ahorro"), 30);
        inputAhorro.sendKeys("600000");
        WebElement inputSueldo = Utils.waitForElementPresence(driver, By.id("sueldo"), 30);
        inputSueldo.sendKeys("1200000");
        WebElement botonRealizarRetiro = Utils.waitToBeClickable(driver, By.cssSelector("a.btn.btn-primary"), 30);
        botonRealizarRetiro.click();
        WebElement resultadoSaldo = Utils.waitForElementPresence(driver, By.id("fila-resultado-saldo"), 30);
        System.out.println(resultadoSaldo.getText());
        Thread.sleep(2000);
        assertEquals(resultadoSaldo.getText(), "$0");
    }

}
