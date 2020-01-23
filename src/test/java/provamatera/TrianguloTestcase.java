package provamatera;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class TrianguloTestcase {

    //constante
    private static final String BOTAO_CALCULAR = "calcular";
    private static final String CAMPO_LADO1 = "lado1";
    private static final String CAMPO_LADO2 = "lado2";
    private static final String CAMPO_LADO3 = "lado3";
    private static final String CAMPO_MENSAGEM = "message";

    private static final String MENSAGEM_TRIANGULO_ISOSCELES  = "Triângulo Isósceles";
    private static final String MENSAGEM_TRIANGULO_EQUILATERO = "Triângulo Equilátero";
    private static final String MENSAGEM_TRIANGULO_ESCALENO   = "Triângulo Escaleno";
    private static final String MENSAGEM_PREENCHA_CAMPOS      = "Preencha todos os lados";
    private static final String MENSAGEM_SOMENTE_NUMEROS      = "Insira um número";
    private WebDriver chrome;

    @Before
    public void carregarWebDriver() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--headless");
        this.chrome = new ChromeDriver(opt);
        this.chrome.get("https://calculadoratriangulo.herokuapp.com");
    }



    @Dado("que preenchi o campo lado1 com o valor {string}")
    public void preencherCampoLado1(String valorCampo) {
        this.chrome.findElement(By.id(CAMPO_LADO1)).sendKeys(valorCampo);
    }

    @Dado("preenchi o campo lado2 com o valor {string}")
    public void preencherCampoLado2(String valorCampo) {
        this.chrome.findElement(By.id(CAMPO_LADO2)).sendKeys(valorCampo);
    }
    @Dado("que preenchi o campo lado3 com o valor {string}")
    public void preencherCampoLado3(String valorCampo) {
        this.chrome.findElement(By.id(CAMPO_LADO3)).sendKeys(valorCampo);
    }

    @Quando("clicar no botão Calcular")
    public void clicarNoBotaoCalcular() {
        this.chrome.findElement(By.id(BOTAO_CALCULAR)).click();
    }

    @Então("o sistema exibirá a mensagem \"Triângulo Isósceles\" e sua imagem")
    public void seraExibidoAMensagemDoTipoDoTrianguloIsosceles() {
        Assert.assertEquals(this.chrome.findElement(By.id(CAMPO_MENSAGEM)).getText(), MENSAGEM_TRIANGULO_ISOSCELES);
    }

    @Então("o sistema exibirá a mensagem \"Triângulo Equilátero\" e sua imagem")
    public void seraExibidoAMensagemDoTipoDoTrianguloEquilatero() {
        Assert.assertEquals(this.chrome.findElement(By.id(CAMPO_MENSAGEM)).getText(), MENSAGEM_TRIANGULO_EQUILATERO);
    }

    @Então("o sistema exibirá a mensagem \"Triângulo Escaleno\" e sua imagem")
    public void seraExibidoAMensagemDoTipoDoTrianguloEscaleno() {
        Assert.assertEquals(this.chrome.findElement(By.id(CAMPO_MENSAGEM)).getText(), MENSAGEM_TRIANGULO_ESCALENO);
    }

    @Dado("que não preechi nenhum campo")
    public void CamposNull() {

    }

    @Então("o sistema exibirá a mensagem \"Preencha todos os lados\"")
    public void seraExibidoMsgPreenchaCampos() {
        Assert.assertEquals(this.chrome.findElement(By.id(CAMPO_MENSAGEM)).getText(),MENSAGEM_PREENCHA_CAMPOS);
    }

    @Então("o sistema exibirá a mensagem \"Insira um número\"")
    public void somenteNumeros() {
        Assert.assertEquals(this.chrome.findElement(By.id(CAMPO_MENSAGEM)).getText(),MENSAGEM_SOMENTE_NUMEROS);
    }
}


