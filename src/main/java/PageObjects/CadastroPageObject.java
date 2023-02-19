package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastroPageObject {
    private AppiumDriver driver;
    private MobileElement camponome;
    private MobileElement camposenha;
    private MobileElement campoconfirmarsenha;
    private MobileElement botaoCadastrar;
    private MobileElement MensagemDeErro;


    //Buscando driver que estou usando
    public CadastroPageObject(AppiumDriver driver){
        this.driver=driver;
    }


    public void buscarElementos(){

        //Buscar elementos de input
        camponome= (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        camposenha= (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoconfirmarsenha= (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        //Clicar no botão confirma cadastro
        botaoCadastrar= (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");


    }

    private void PreencherFormulario(String usuario,String senha,String confirmacao){

        //chamar os campos para digitar na tela
        camponome.setValue(usuario);
        camposenha.setValue(senha);
        campoconfirmarsenha.setValue(confirmacao);
    }
    public void cadastrar(String usuario,String senha,String confirmacao) {
        PreencherFormulario(usuario,senha,confirmacao);
        botaoCadastrar.click();
    }

    public String MensagemDeErro() {
        MensagemDeErro=(MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
        return MensagemDeErro.getText();
    }
}
