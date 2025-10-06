import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

