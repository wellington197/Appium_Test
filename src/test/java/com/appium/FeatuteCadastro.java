package com.appium;


import PageObjects.CadastroPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class FeatuteCadastro {
    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem(){
        AppiumDriver driver= AppiumDriverConfig.Instance().driver;

        //buscar elementos da tela para cadastrar senha.
        MobileElement botaoCadastro= (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        CadastroPageObject telaCadastro=new CadastroPageObject(driver);
        telaCadastro.buscarElementos();
        telaCadastro.cadastrar("Wee","123","584");

        Assert.assertEquals("Senhas não conferem",telaCadastro.MensagemDeErro());

        //Faz com que a tela volte a tela de Login. Para estado inicial da Feature.
        driver.navigate().back();

    }



    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver= AppiumDriverConfig.Instance().driver;

        //buscar elementos da tela para cadastrar senha.
        MobileElement botaoCadastro= (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        CadastroPageObject telaCadastro=new CadastroPageObject(driver);
        telaCadastro.buscarElementos();
        telaCadastro.cadastrar("Wee","123","123");



        //Validar se ouve a transição de tela ao confirmar o cadastro. Retorna a tela de logar. Buscar o botão logar.
        MobileElement botaoLogar= (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");

        // Devido a Execeção throws NoSuchElementException, não é necessário Assert

    }
}