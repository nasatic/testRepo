package HomePageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePage {
    String url = "http://www.valtech.co.uk";
    WebDriver driver;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void assertRecentBlog() {
        try {
            WebElement cookies = driver.findElement(By.xpath(".//*[@id='CybotCookiebotDialogBodyButtonAccept']"));
            if (cookies.isDisplayed()) {
                cookies.click();
                Thread.sleep(3000);
            } else {
                System.out.println("Cookies already accepted");

            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        WebElement blogHeader = driver.findElement(By.xpath(".//*[contains(text(),'recent blogs')]"));
        WebElement blogText = driver.findElement(By.cssSelector(".bloglisting__item__heading.bloglisting__item__heading--big>a"));
        String blogHeaderText = blogHeader.getText();
        Assert.assertEquals(blogHeaderText, "RECENT BLOGS");
        Assert.assertTrue(blogText.isDisplayed());

    }

    @Test(priority = 1)
    public void goToAboutPage() throws InterruptedException {
        WebElement pageToggler = driver.findElement(By.xpath(".//*[@id='menu-toggle-button']//span[1]/i"));
        pageToggler.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='navigationMenuWrapper']//li[1]/a")).click();
        Thread.sleep(2000);
        WebElement aboutTag = driver.findElement(By.xpath(".//*[@id='container']/div[1]/h1"));
        String aboutPageText = aboutTag.getText();
        Assert.assertTrue(aboutPageText.equalsIgnoreCase("About"));
    }

    @Test(priority = 2)
    public void goToServicesPage() throws InterruptedException {
        WebElement pageToggler = driver.findElement(By.xpath(".//*[@id='menu-toggle-button']//span[1]/i"));
        pageToggler.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='navigationMenuWrapper']//li[3]/a")).click();
        Thread.sleep(2000);
        WebElement aboutTag = driver.findElement(By.xpath(".//*[@id='container']/section/header/h1"));
        String aboutPageText = aboutTag.getText();
        Assert.assertTrue(aboutPageText.equalsIgnoreCase("Services"));
    }

    @Test(priority = 3)
    public void goToWorkPage() throws InterruptedException {
        WebElement pageToggler = driver.findElement(By.xpath(".//*[@id='menu-toggle-button']//span[1]/i"));
        pageToggler.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='navigationMenuWrapper']//li[2]/a")).click();
        Thread.sleep(2000);
        WebElement workTag = driver.findElement(By.xpath(".//*[@id='container']/header/h1"));
        String workPageText = workTag.getText();
        Assert.assertTrue(workPageText.equalsIgnoreCase("work"));
    }
    @Test
    public void verifyOfficeCount() throws InterruptedException {
        WebElement pageToggler = driver.findElement(By.xpath(".//*[@id='menu-toggle-button']//span[1]/i"));
        pageToggler.click();
        Thread.sleep(2000);
        WebElement contactPage = driver.findElement(By.xpath(".//*[@id='contacticon']//div[1]/i"));
        contactPage.click();
        Thread.sleep(2000);


    }

    @AfterClass
    public void closeDown(){
        driver.close();
        driver.quit();
    }
}


