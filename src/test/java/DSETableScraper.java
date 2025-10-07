import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;

import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class DSETableScraper extends BaseTest{


    @DisplayName("Scrape all table data from DSE website and save to file")
    @Test
        public void scrapeAllTableData1() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        WebElement tableDiv = driver.findElement(By.cssSelector(".table-responsive.inner-scroll"));
        WebElement table = tableDiv.findElement(By.tagName("table"));
        List<WebElement> tbodies = table.findElements(By.tagName("tbody"));

        FileWriter writer = new FileWriter("./src/test/resources/report.txt");
        try {

            for (WebElement tbody : tbodies) {
                List<WebElement> rows = tbody.findElements(By.tagName("tr"));

                for (WebElement row : rows) {
                    List<WebElement> cells = row.findElements(By.tagName("td"));
                    for (WebElement cell : cells) {
                        System.out.print(cell.getText() + " ");
                        writer.write(cell.getText() + " ");
                    }
                    System.out.println();
                    writer.write("\n");
                }
            }
        } finally {
            writer.close();
        }
    }}



