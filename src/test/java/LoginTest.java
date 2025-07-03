import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {

    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void visitURL(){
        driver.get("http://localhost:8080/");
        String ActualTitle= driver.getTitle();
        String ExpectedTitle="Document";
        Assertions.assertTrue(ActualTitle.contains(ExpectedTitle));
        WebElement PageHeading= driver.findElement(By.cssSelector(".sc-bdVaJa.cCkHTg>div"));
        String expectedHeading="qa.code-quiz.dev";
        String actualheading=PageHeading.getText();
        Assertions.assertEquals(expectedHeading,actualheading);
        WebElement FooterMessage=driver.findElement(By.xpath("//div[text()='If you do not have an account, contact an admin']"));
        String ExpectedFooter="If you do not have an account, contact an admin";
        String ActualFooter=FooterMessage.getText();
        Assertions.assertEquals(ExpectedFooter,ActualFooter);

    }
    @Test

    public void Login() throws InterruptedException {
        driver.get("http://localhost:8080/");
        Thread.sleep(10);
        WebElement username=driver.findElement(By.cssSelector("[placeholder='Enter Username']"));
        Thread.sleep(10);
        username.sendKeys("farialaiba@yahoo.com");
        Thread.sleep(10);
        WebElement password=driver.findElement(By.cssSelector("[placeholder='password']"));
        password.sendKeys("123456");
        WebElement submitbutton=driver.findElement(By.cssSelector(".sc-bZQynM.cGmBje"));
        submitbutton.click();
        driver.quit();





    }
}
