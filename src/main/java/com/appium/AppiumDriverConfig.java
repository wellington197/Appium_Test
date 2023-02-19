package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {

    //Instanciar, para que possa ser usando em outra classe.
    public final AppiumDriver driver;
    private static AppiumDriverConfig _instance;

    /*Usando padrão Singleton do Projeto*/
    /*Deixar uma única instância do projeto e acesso global */
    public static AppiumDriverConfig Instance(){
        //Acessor para instaciar a sessão do driver
        if (AppiumDriverConfig._instance == null) {
            AppiumDriverConfig._instance=new AppiumDriverConfig();

        }
        return AppiumDriverConfig._instance;
    }
    private AppiumDriverConfig(){
        /*Passar o caminho do arquivo APK*/
        File apk=new File("C:\\xampp\\htdocs\\CURSOS_WELLINGTON\\CURSOS_UDEMY\\Appium_Test\\src\\main\\resources\\alura_esporte.apk");

        /*Passar as configurações para appium executar*/
        DesiredCapabilities configuracoes=new DesiredCapabilities();

        configuracoes.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        //Chamar a conexão com a URL do servidor executado no Powershel
        URL urlConexao=null;

        try {
            urlConexao=new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        //Criando nova conexão de driver
        driver=new AppiumDriver<>(urlConexao,configuracoes);
    }
}
