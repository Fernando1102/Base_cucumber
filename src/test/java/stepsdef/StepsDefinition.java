package stepsdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.globalVariables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StepsDefinition {
    WebDriver driver;
    Map<String, Object> vars;
    JavascriptExecutor js;



    @Given("^Estoy en la pagina de inicio de clikink$")
    public void estoy_en_la_pagina_de_inicio_de_clikink() throws Throwable {
        System.out.println("Given  Estoy en la pagina de inicio de clikink");
        WebDriverManager.chromedriver().setup();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));//Remover mensaje "Chrome esta siendo controlado por un software de prueba"
        options.addArguments("--ignore-ssl-errors=yes");//ignorar certificados de error,
        options.addArguments("--ignore-certificate-errors");//ignorar certificados de error,
        driver = new ChromeDriver(options);
        String verificationCode = "";
        driver.get(globalVariables.URLCLICKINK);
    }

    @When("^Realizo el login en clikink$")
    public void realizo_el_login_en_clikink_accion() throws Throwable {
        System.out.println("When Realizo el login en clikink");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebDriverWait wait2 = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("submit-button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("1-email"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("1-email"))).sendKeys("user");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("auth0-lock-submit"))).click();

    }

    @Then("^Deberian aparecer los resultados de la busqueda$")
    public void deberian_aparecer_los_resultados_de_la_busqueda() throws Throwable {
        System.out.println("then Deberian aparecer los resultados de la busqueda");
    }

    @And("^Realizara el login en Auth0$")
    public void realizara_el_login_en_auth0_accion() throws Throwable {
        System.out.println("And Realizara el login en Auth0");
    }

    @And("^Realizara el login en Gmail$")
    public void realizara_el_login_en_gmail_accion() throws Throwable {
        System.out.println("And Realizara el login en Gmail");
    }

}
