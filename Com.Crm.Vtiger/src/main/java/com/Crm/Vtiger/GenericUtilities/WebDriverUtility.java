package com.Crm.Vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.collections4.FactoryUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void wait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.implicitwaitDuration));
	}
	public void visibilityOfElementLocatedWait(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitwaitDuration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void presenceOfElementLocatedWait(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitwaitDuration));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public void textToBePresentInElementLocatedWait(WebDriver driver,By locator,String text) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitwaitDuration));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	public void textToBePresentInElementLocatedWait(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitwaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void alertIsPresentWait(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitwaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void alertIsPresentWait(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitwaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	public void selectDropdown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void selectDropdown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void selectDropdown(String visibleText,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}
	/**
	 * this  under methods will help us to handle Action class
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();	
   }
	/**
	 * By usiong this method we r perform rightclick action on particular WebElement in the webpage
	 * @param driver
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();	
   }
	/**
	 * By using this method we r perform rightclick action anywhere in the webpage
	 * @param driver
	 */
	public void rightClickAnyWhere(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * By usiong this method we r perform doubleclick action on particular Webelement in the Webpage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();	
   }
	/**
	 * By using this method we r perform doubleclick action anywhere in the webpage
	 * @param driver
	 */
	public void doubleClickAnyWhere(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick();
	}
	/**
	 * By using this method we can perform drag and drop action on WebElement
	 * @param driver
	 * 
	 */
	public void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement destElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement,destElement).perform();
	}
	/**
	 * By using this method we can scroll the webpage upto element
	 * @param driver
	 * @param element
	 * @param y
	 */
	public void srollThePageToElement(WebDriver driver,WebElement element,int y) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		y =element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+");",element);
  }	
	/**
	 * By using this method we can scroll the webpage
	 * @param driver
	 */
	public void srollTheWebPage(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
  }	
	/**
	 * By using this method we can switch one window to required window by comparing titles
	 * @param driver
	 * @param partialTitle
	 */
	public void windowHandling(WebDriver driver,String partialTitle) {
		//capture all window ids
		Set<String> id=driver.getWindowHandles();
		
		//navigate to each window capture the title
		for(String wid : id) {
			String currentTitle=driver.switchTo().window(wid).getTitle();
			//compare the title with the required window title
			if(currentTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	/**
	 * By using this method we can handle Frames
	 * @param driver
	 * @param element
	 */
	public void frame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void frame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void frame(WebDriver driver,String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	/**
	 * this method help us to return back to parent frame
	 * @param driver
	 */
	public void parentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * this method help us to return back to the main page
	 * @param driver
	 */
	public void mainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * this method will help us to hanldle Alert pop ups
	 * @param driver
	 * @param msg
	 */
	public void passmsgtoAlert(WebDriver driver,String msg) {
		driver.switchTo().alert().sendKeys(msg);
	}
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void fetchAlertMsg(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	/**
	 * this method will take the screenshot of WebPage
	 * @param driver
	 * @param sreenshotName
	 * @return
	 * @throws Throwable
	 */
	public String getScreenshot(WebDriver driver,String sreenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);//outputtype is a enum
		
		JavaUtility ju=new JavaUtility();
		String currentDate=ju.sysdateTime();
		
		//LocalDateTime local=LocalDateTime.now();
		//String date=local.toString().replace("-", "_").replace(":", "_");
		
		File dest=new File("./Screenshot/"+currentDate+sreenshotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();//Extent report
	}
	/**
	 * this method will take the screenshot of Particular WebElement
	 * @param driver
	 * @param sreenshotName
	 * @return
	 * @throws Throwable
	 */
	public String getScreenshot(WebElement element,String sreenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)element;
		File src=ts.getScreenshotAs(OutputType.FILE);//OutputType is a enum
	
		JavaUtility ju=new JavaUtility();
		String currentDate=ju.sysdateTime();
		
		//LocalDateTime local=LocalDateTime.now();
		//String date=local.toString().replace("-", "_").replace(":", "_");
		
		File dest=new File("./Screenshot/"+currentDate+sreenshotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();//Extent report
	}
	/**
	 * this method can hanadle FileUpload
	 * @param path
	 * @param element
	 */
	public void fileUpload(String path,WebElement element) {
		File f=new File(path);
		String abspath=f.getAbsolutePath();
		element.sendKeys(abspath);
	}

}
