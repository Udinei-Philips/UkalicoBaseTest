package com.philips.tasy.core;

import br.com.ukalico.core.core.BaseTest;
import br.com.ukalico.core.core.Propriedades;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.com.ukalico.core.core.DriverFactory.getDriver;

public class BaseTestCoreTasy extends BaseTest {


    @Override
    @Before
    public void inicializa(){
        /**Endereco do sistema a ser testado */
        pageTasy.acessarTelaInicial("https://dev.tasy.whebdc.com.br/");
        pageTasy.autorizar();
        pageTasy.processaAutorizacao();

        pageTasy.setLoginUsername("usilva");
        pageTasy.setLoginPassword("Philips#3001");
        pageTasy.loginDatabase("WTASY");
        pageTasy.entrar();


    }

    @Override
    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testName.getMethodName() + ".jpg"));

        if(Propriedades.FECHAR_BROWSER) {
         //  killDriver();
        }
    }
}
