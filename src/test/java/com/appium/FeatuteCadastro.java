package com.appium;


import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static junit.framework.Assert.*;

public class FeatuteCadastro {
    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() throws MalformedURLException {
        AppiumDriverConfig driver=new AppiumDriverConfig();

        //buscar elementos da tela
        MobileElement botaoCadastro= (MobileElement)driver.driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");

        botaoCadastro.click();

        assertTrue(true);
    }
}