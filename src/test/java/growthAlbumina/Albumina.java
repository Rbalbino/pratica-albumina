//1 - Nome do pacote
package growthAlbumina;

// 2 - Bibliotecas
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

// 3 - Classes
public class Albumina {

    //3.1 - Atributos
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

   // 3.2 Métodos ou funções
    @Before // Antes do teste
    public void setUp() {
        //apontar onde está o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/92/chromedriver92.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    @After // Depois do teste
    public void tearDown() {
        driver.quit();
    }

    @Test // O teste
    public void albumina() {
        driver.get("https://www.gsuplementos.com.br/");
       // driver.manage().window().setSize(new Dimension(1346, 708));
        driver.findElement(By.name("busca")).click();
        driver.findElement(By.name("busca")).sendKeys("albumina");
        driver.findElement(By.name("busca")).sendKeys(Keys.ENTER);
        {
            WebElement element = driver.findElement(By.cssSelector(".flex-child-auto:nth-child(5) > .menu-itemComSub"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".columns:nth-child(1) > .flex-container .lazy")).click();
        js.executeScript("window.scrollTo(0,36)");
        js.executeScript("window.scrollTo(0,337)");
        driver.findElement(By.cssSelector(".boxAtributoSimples:nth-child(11) > .nice-select")).click();
        driver.findElement(By.cssSelector(".medium-6 > img")).click();
        driver.findElement(By.cssSelector(".topoDetalhe-boxRight:nth-child(1) > .topoDetalhe-boxRight-nome")).click();
        assertThat(driver.findElement(By.cssSelector(".topoDetalhe-boxRight:nth-child(1) > .topoDetalhe-boxRight-nome")).getText(), is("ALBUMINA 1KG - GROWTH SUPPLEMENTS"));
    }
}
