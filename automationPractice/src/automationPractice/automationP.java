package automationPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class automationP {
	
	WebDriver driver;
	
	@Test
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sagarika\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sagarikanayak0605@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("sagarika1");	
		driver.findElement(By.xpath("//i[@class='icon-lock left']")).click();
		
		//JavascriptExecutor is used for clik on object , fetch teh details like after launch the site fetch teh URl of sit, domain name,titile name of teh sit,
		//also used for scroll down
		//script has return type  of String, List,WebElement,Boolean,Long
		//it has two methods executeScript and executeAsynscript
		
			JavascriptExecutor js= (JavascriptExecutor)driver; //using javascript click on button 
		//		
		//		WebElement button =driver.findElement(By.xpath("//i[@class='icon-lock left']"));
		//		 js.executeScript("arguments[0].click();", button);
			
				
				//to generate the alert window using javascriptExecutor and display the alert message
				
		//		JavascriptExecutor js= (JavascriptExecutor)driver;
		//		js.executeScript("alert('welocome to automationpractice');");
		
		
		//fetch the details of site
		
		String url= js.executeScript("return document.URL;").toString();
		System.out.println(url);
		
		String domain= js.executeScript("return document.domainname;").toString();
		System.out.println(domain);
		
		String titlename= js.executeScript("return document.title;").toString();
		System.out.println(titlename);
		
		
		
		//click on dresses
		driver.navigate().to("http://automationpractice.com/index.php?id_category=8&controller=category");
		
		//click on image you want to add
		driver.findElement(By.xpath("//img[@class='replace-2x img-responsive']")).click();

		//click on add to cart
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		
		//window handle
		
		String win= driver.getWindowHandle();//main window i.e current window
		System.out.println(win);
		
		
		Set<String> allwindows= driver.getWindowHandles();  //child windows
		Iterator<String> itr=allwindows.iterator();
		while(itr.hasNext())
		{
			String childwin=itr.next();
			System.out.println(driver.switchTo().window(childwin));
			driver.findElement(By.xpath("(//div[@class='clearfix'])[1]")); //xpath for child window
			driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click(); //click on proceed to checkout
						
		}
		
		//again click on proceed to checkout
		driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
		driver.findElement(By.xpath("//input[@id='cgv']")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]")).click();
		
		//verification to capture the text of dress name
		
		//driver.findElement(By.xpath("//div[@id='order-detail-content']']"));
		//count rows &col
		
		List<WebElement> col= driver.findElements(By.xpath("//div[@id='order-detail-content']/table/thead/tr/th"));
		
		System.out.println(col.size());
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='order-detail-content']/table/tbody/tr/td"));
		System.out.println(rows.size());
		
		String des = null;
		
		
		for(int i=1;i<rows.size();i++)
		{
			 des=driver.findElement(By.xpath("//table[@id=\"cart_summary\"]/tbody/child::tr [\" + (i+1) + \"]/td[2]/p")).getText();
			//table[@id=\"cart_summary\"]/tbody/tr[" + (i+1) + "]/td[2]/child::p
			
				
			
		}
		
		System.out.println(des);
		
		//click on cart mouse hover using Actions
		
		Actions builder = new Actions(driver);
		
		WebElement element=driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		
			
		builder.moveToElement(element).build().perform();
		
		String bgcolor=element.getCssValue("background-color");
		System.out.println(bgcolor);
		
		//click on Women
		
		driver.navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");
		
		//click on Tops + sign
		driver.findElement(By.xpath("(//span[@class='grower CLOSE'])[1]")).click();
		
		//click on T-Shirts
		driver.navigate().to("http://automationpractice.com/index.php?id_category=5&controller=category");
		
		//click on Size M
		
		driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_2']")).click();
		
		//click on color orange
		driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_13']")).click();
		
		
		//scroll down handling vertical scroll bar
		//creating JavascriptExecutor interface obj by type casting
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,600)");
		
		
		//mMve the slide drag n drop price Range
		
		Actions builder1 = new Actions(driver);
		
		WebElement price = driver.findElement(By.xpath("//div[@id='layered_price_slider']/a"));
		
		builder1.dragAndDropBy(price, 30, 0).build().perform();
		//sysou
		//automation
		
		
		
		
		
	}

}
