package Textboxes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 
{
	WebDriver driver = null;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	@Test
	public void test()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		name.sendKeys("Mayank Rusia");
		System.out.println("Name entered");
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("sdetqaaman88@gmail.com");
		System.out.println("Email entered");
		
		WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
		phone.sendKeys("95365465787");
		System.out.println("Phone no. entered");
		
		WebElement address = driver.findElement(By.xpath("//textarea[@id='textarea']"));
		address.sendKeys("455/5 rajesh nagar, new delhi");
		System.out.println("Address entered");
		
		WebElement male = driver.findElement(By.xpath("//input[@id='male']"));
		male.click();
		System.out.println("Male radio button clicked");
		
		WebElement female = driver.findElement(By.xpath("//input[@id='female']"));
		female.click();
		System.out.println("Female radio button clicked");
		
		WebElement monday = driver.findElement(By.xpath("//input[@id='monday']"));
		monday.click();
		System.out.println("Monday checkbox clicked");
		
		WebElement thursday = driver.findElement(By.xpath("//input[@id='thursday']"));
		thursday.click();
		System.out.println("Thursday checkbox is clicked");
		
		WebElement saturday = driver.findElement(By.xpath("//label[normalize-space()='Saturday']"));
		saturday.click();
		System.out.println("Saturday checkbox is clicked");
		
		System.out.println("Page title (before link click): "+driver.getTitle());
		WebElement opencart = driver.findElement(By.xpath("//a[normalize-space()='open cart']"));
		opencart.click();
		System.out.println("Page title(after link click): "+driver.getTitle());
		driver.navigate().back();
		
//		WebElement newbrowserwindowbutton = driver.findElement(By.xpath("//button[normalize-space()='New Browser Window']"));
//		newbrowserwindowbutton.click();
//		System.out.println("New browser window ges opened");
		
		WebElement alertbutton = driver.findElement(By.xpath("//button[normalize-space()='Alert']"));
		alertbutton.click();
		System.out.println("Alert button is clicked");
		driver.switchTo().alert().accept();
		System.out.println("OK is clicked");
		
		WebElement promptbutton = driver.findElement(By.xpath("//button[normalize-space()='Prompt']"));
		promptbutton.click();
		System.out.println("prompt button is clicked");
		driver.switchTo().alert().sendKeys("Ram ram!");
		System.out.println("Prompt is given");
		driver.switchTo().alert().accept();
		System.out.println("Ok is clicked");
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println("text obtained: "+text);
		
		
		WebElement confirmboxbutton = driver.findElement(By.xpath("//button[normalize-space()='Confirm Box']"));
		confirmboxbutton.click();
		System.out.println("Confirm button clicked");
		driver.switchTo().alert().accept();
		System.out.println("ok is clicked");
		System.out.println("Text obtained: "+text);
		confirmboxbutton.click();
		System.out.println("Confirm button clicked");
		driver.switchTo().alert().dismiss();
		System.out.println("cancel is clicked");
		System.out.println("Text obtained: "+text);
		
		
		Actions actions = new Actions(driver);
		
		WebElement doubleclickbutton = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		actions.doubleClick(doubleclickbutton).build().perform();
		System.out.println("Double click is done");
		String text1 = driver.findElement(By.xpath("//input[@value='Hello World!']")).getText();
		String text2 = driver.findElement(By.xpath("//div[@class='column-right-outer']//input[2]")).getText();
		System.out.println("Text1: "+text1);
		System.out.println("Text2: "+text2);
		
		WebElement dragbutton = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropbutton = driver.findElement(By.xpath("//div[@id='droppable']"));
		actions.dragAndDrop(dragbutton, dropbutton).build().perform();
		System.out.println("Dragged element is dropped inside drop area");

/*		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;

		WebElement locatingelement1 = driver.findElement(By.xpath("//h2[normalize-space()='Frames']"));
		WebElement sliderbutton = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default ui-state-hover']"));
		jsExecutor.executeScript("document.arguments[0].scrollIntoView();", locatingelement1);
		
		actions.dragAndDropBy(sliderbutton, 20, 0).build().perform();
		actions.dragAndDropBy(sliderbutton, 50, 0).build().perform();
		actions.dragAndDropBy(sliderbutton, -30, 0).build().perform();
		actions.dragAndDropBy(sliderbutton, 37, 0).build().perform();
		System.out.println("Sliding operation done");

		WebElement locatingelement2 = driver.findElement(By.xpath("//tbody/tr[1]/td[4]"));
		WebElement resizablebutton = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		jsExecutor.executeScript("document.arguments[0].ScrollIntoView();", locatingelement2);
		actions.dragAndDropBy(resizablebutton, 25, 120).build().perform();
		actions.dragAndDropBy(resizablebutton, -25, 150).build().perform();
		actions.dragAndDropBy(resizablebutton, 65, 200).build().perform();
		actions.dragAndDropBy(resizablebutton, -15, 100).build().perform();
		actions.dragAndDropBy(resizablebutton, -80, 20).build().perform();
		System.out.println("Resizable operation done");
*/		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
}
