import com.google.common.base.Verify;
import org.junit.Assert;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestSuite extends BaseTest{
    String baseUrl="https://www.amazon.co.uk/";

    @Test
    public void dellLaptop() {
        // 1.opening browser
        openBrowser(baseUrl);
        //click on accept cookies
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
      //  2. Type "Dell Laptop" in the search box and press enter or click on search button
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Dell laptop");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
      //  3. Click on the checkbox brand dell on the left side.
        driver.findElement(By.xpath("//li[@id='p_89/Dell']/descendant::i")).click();
       // 4. Verify that the  30(May be different) products are displayed on the page.
        List<WebElement>productLists=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        int actualSize=productLists.size();
        int expectedsize=30;
        Assert.assertEquals("verify product size:", expectedsize,actualSize);
      //  5. Print all product names in the console.
        for (WebElement productListName:productLists) {
            System.out.println(productListName.getText());
        }
      //  5. Close the Browser.
        closeBrowser();

    }

    }

