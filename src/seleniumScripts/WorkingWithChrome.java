package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithChrome {

	
	ChromeDriver driver;
	
	String baseUrl = "https://www.geantdrive.tn/azur-city/";
	
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ines\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(baseUrl);
	}
	

	public String getTitleforTest() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public void getTitle() {
		String pageTitle = driver.getTitle();
		System.out.println("final result: "+ pageTitle);
	}

	public void closeDriver() {
		driver.close();
	}
	

    void goToPage(String page){
        WebElement elem = driver.findElement(By.linkText(page));
        elem.click();
    }
    
    void login(String username, String password){

        driver.findElement(By.id("_desktop_user_info")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Identifiez-vous']"))).click();
        
        // fill out the login form with data
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.id("submit-login")).click();

    }

    void logout(){
        driver.findElement(By.id("_desktop_user_info")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Voir mon compte client']"))).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div/a")).click();
    }
    
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    void search(String product) {
    	driver.findElement(By.id("search_toggle")).click();
    	driver.findElement(By.id("search_query_top")).sendKeys(product);
    	driver.findElement(By.name("submit_search")).click();	
    }
    
      
     void changePersonalInfo(String name , String Surname , String cin) {
    	 driver.findElement(By.id("_desktop_user_info")).click();
         new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Voir mon compte client']"))).click();
    	 driver.findElement(By.id("identity-link")).click();
    	 WebElement firstName = driver.findElement(By.name("firstname"));
         WebElement lastName = driver.findElement(By.name("lastname"));
         WebElement ciin = driver.findElement(By.name("num_cin"));
         
         firstName.clear();
         firstName.sendKeys(name);

         lastName.clear();
         lastName.sendKeys(Surname);

         ciin.clear();
         ciin.sendKeys(cin);
         
     	driver.findElementByXPath("//*[@id=\"customer-form\"]/footer/button").click();
     	
    	 
     } 
	
/*	
	public static void main(String [] args) {
		
		WorkingWithChrome connection = new WorkingWithChrome();
		connection.invokeBrowser();
		connection.getTitle();
		connection.closeDriver();
		
	}
*/	
	
}
