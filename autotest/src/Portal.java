import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Portal {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        String url = "https://portal.aait.edu.et/";
        driver.get(url);

        driver.findElement(By.id("UserName")).sendKeys("ATR/5552/09");
        driver.findElement(By.id("Password")).sendKeys("####");
        driver.findElement(By.id("home")).findElement(By.className("btn")).click();
        driver.findElement(By.id("m2")).click();
        driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");

        String value  = driver.findElement(By.className("table")).getText();

        try (PrintWriter out = new PrintWriter("gradeReport.txt")) {
            out.println(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
