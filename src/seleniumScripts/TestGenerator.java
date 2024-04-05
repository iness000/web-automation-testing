package seleniumScripts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestGenerator {

    public static WorkingWithChrome connection ;

    @BeforeAll
    static void beforeAll() {
    	connection = new WorkingWithChrome();
    	connection.invokeBrowser();
    }

	@AfterAll
	static void afterAll() {
		connection.closeDriver();
	}
	
	@Test
	public void TestWorfklow() {
		this.TestingWebsiteTitle();
		this.TestingLoginFalsePassword();
		this.TestingLogin();
		this.testingSearch();
		this.TestingEditAccount();
		this.TestingLogout();
	}
	
    public void TestingWebsiteTitle() {
    	String actualTitle = connection.getTitleforTest();
    	assertEquals("Azur city Géant Drive : pour vos courses en ligne du quotidien", actualTitle);
    }
    
    public void TestingLoginFalsePassword() {
    	String email ="inesbourouissi@gmail.com";
    	String password ="1234ines";
        connection.login(email, password);
       	WebElement errorBox = connection.driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/ul/li")); 
    	assertTrue(errorBox.isDisplayed());
    }
    
    public void TestingLogin() {
    	String email ="inesbourouissi@gmail.com";
    	String password ="12345ines";
        connection.login(email, password);
        assertEquals("Mon compte", connection.driver.getTitle());
    }
    
    public void TestingLogout() {
        connection.logout();
        assertEquals("Identifiant", connection.driver.getTitle());
    }
    
    
    public void testingSearch() {
    	connection.search("danette");
    	WebElement product = connection.driver.findElementByXPath("//*[@id=\"js-product-list\"]/div/div[1]/article/div/div[3]/div[2]/p");
    	assertEquals("DANETTE",product.getText());
    }
    
    public void TestingEditAccount() {
    	connection.changePersonalInfo("sarah", "jebri", "1234567");
    	WebElement successBox = connection.driver.findElement(By.id("notifications")); 
    	assertTrue(successBox.isDisplayed());
    	
    	
    }
	
}
