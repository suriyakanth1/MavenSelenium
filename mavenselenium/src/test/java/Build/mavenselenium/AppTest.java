package Build.mavenselenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class AppTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to the ChromeDriver executable
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Create a new instance of the ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testExample() {
        // Navigate to Google
        driver.get("https://www.google.co.in");

        // Print success message
        System.out.println("Browser opened successfully.");

        // Enter search query and press Enter
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        System.out.println("Selenium search.");

        // Click on a link containing the word "selenium"
        driver.findElement(By.partialLinkText("selenium")).click();
        System.out.println("Navigated to Selenium page.");

        // Click on the "Download" link
        driver.findElement(By.partialLinkText("Download")).click();
        System.out.println("Clicked on Download link.");

        // Get the title of the page
        String pageTitle = driver.getTitle();

        // Assert the title
        assertEquals("Downloads | Selenium", pageTitle);
    }
}
