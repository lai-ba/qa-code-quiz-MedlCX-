import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginWithoutPass {
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
        WebElement username=driver.findElement(By.cssSelector("[placeholder='Enter Username']"));;
        username.sendKeys("abc@gmail.com");
        WebElement submitbutton=driver.findElement(By.cssSelector(".sc-bZQynM.cGmBje"));
        submitbutton.click();
        //Assuming the website is showing validation message
        WebElement validation_message=driver.findElement(By.xpath("//div[text()='Enter username]"));
        String Expected_alert="Enter password";
        String Actual_alert=validation_message.getText();
        Assertions.assertEquals(Expected_alert,Actual_alert);
    }
}
