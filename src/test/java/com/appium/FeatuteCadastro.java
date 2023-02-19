package com.appium;


import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;

public class FeatuteCadastro {
    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() throws MalformedURLException {
        AppiumDriverConfig driver=new AppiumDriverConfig();

        //buscar elementos da tela para cadastrar senha.
        MobileElement botaoCadastro= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        //Buscar elementos de input
        MobileElement camponome= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        MobileElement camposenha= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        MobileElement confirmarsenha= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        //chamar os campos para digitar na tela
        camponome.setValue("bugan");
        camposenha.setValue("123");
        confirmarsenha.setValue("4587");

        //Clicar no botão confirma cadastro
        MobileElement botaoConfirmaCadastro= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoConfirmaCadastro.click();
        MobileElement erro=(MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");

        Assert.assertEquals("Senhas não conferem",erro.getText());

    }

    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException, MalformedURLException {
        AppiumDriverConfig driver=new AppiumDriverConfig();

        //buscar elementos da tela para cadastrar senha.
        MobileElement botaoCadastro= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        //Buscar elementos de input
        MobileElement camponome= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        MobileElement camposenha= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        MobileElement confirmarsenha= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        //chamar os campos para digitar na tela
        camponome.setValue("bugan");
        camposenha.setValue("123");
        confirmarsenha.setValue("123");

        //Clicar no botão confirma cadastro
        MobileElement botaoConfirmaCadastro= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        botaoConfirmaCadastro.click();

        //Validar se ouve a transição de tela ao confirmar o cadastro. Retorna a tela de logar. Buscar o botão logar.
        MobileElement botaoLogar= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");


      //  MobileElement erro=(MobileElement) driver.driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");

       // Assert.assertEquals("Senhas não conferem",erro.getText());

    }
}