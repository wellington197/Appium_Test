package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class App {

    public static void main( String[] args ) throws MalformedURLException {
        /*Passar o caminho do arquivo APK*/
        File apk=new File("C:\\xampp\\htdocs\\CURSOS_WELLINGTON\\CURSOS_UDEMY\\Appium_Test\\src\\main\\resources\\alura_esporte.apk");

        /*Passar as configurações para appium executar*/
        DesiredCapabilities configuracoes=new DesiredCapabilities();

        configuracoes.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        //Chamar a conexão com a URL do servidor executado no Powershel
        URL urlConexao=new URL("http://127.0.0.1:4723/wd/hub");

        //Criando nova conexão de driver
        AppiumDriver driver=new AppiumDriver<>(urlConexao,configuracoes);
    }
}
