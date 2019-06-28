import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Gmail {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.gmail.com";
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("ermiyas10080@gmail.com");
        driver.findElement(By.id("identifierNext")).click();

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys("#########");
        driver.findElement(By.id("passwordNext")).click();

        Thread.sleep(30000L);

        List<WebElement> unreadEmailsElements =  driver.findElement(By.className("Cp")).findElement(By.tagName("table")).findElements(By.className("zE"));
        printSubject(unreadEmailsElements);
    }

    public static void printSubject(List<WebElement> element){
        System.out.println();
        System.out.println("The No of your Unread Emails is: " + element.size());
        System.out.println();

        for (int i = 0; i < element.size(); i++){
            System.out.println("=> Subject " + (i + 1) + ": " + element.get(i).findElement(By.className("y6")).getText());
        }
        System.out.println();
    }
}
