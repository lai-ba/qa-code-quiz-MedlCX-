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
public class LoginWithoutEmail {
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
        WebElement pass=driver.findElement(By.cssSelector("[placeholder='password']"));
        pass.sendKeys("123456");
        WebElement submitbutton=driver.findElement(By.cssSelector(".sc-bZQynM.cGmBje"));
        submitbutton.click();
        WebElement validation_message=driver.findElement(By.xpath("//div[text()='Enter username]"));
        String Expected_alert="Enter user name";
        String Actual_alert=validation_message.getText();
        Assertions.assertEquals(Expected_alert,Actual_alert);
    }
}
