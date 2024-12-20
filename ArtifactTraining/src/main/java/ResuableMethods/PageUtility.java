package ResuableMethods;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PageUtility {
	
	public AppiumDriver driver;

	public static synchronized String readProperty(String key) {
		String value = null;
		try {
			FileInputStream stream = new FileInputStream(".//ProjectSetting.properties");
			Properties pro = new Properties();
			pro.load(stream);
			value = pro.getProperty(key);
		} catch (Exception e) {

		}
		return value;
	}

	// Mobile Application Utilities

	public synchronized void quit_Driver(AppiumDriver<MobileElement> driver) {
		
		driver.quit();
		
	}

	public synchronized MobileElement get_AppiumElement(AppiumDriver<MobileElement> driver, By locator) {
		MobileElement ele = null;
		try {
			ele = driver.findElement(locator);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ele;
	}

	public synchronized void Click(AppiumDriver<MobileElement> driver, By locator, int timeToWait) throws Exception {
		int my_time = 0;
		while (my_time < timeToWait) {
			my_time = my_time + 1;
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(1))   // Total wait time
		            .pollingEvery(Duration.ofMillis(500))           // Poll every 500ms
		            .ignoring(NoSuchElementException.class);
			MobileElement ele = null;
			try {
				ele = get_AppiumElement(driver, locator);
				if (ele != null) {
					if (ele.isEnabled()) {
						ele.click();
						break;

					}else {
						ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
					}
				}else {
					ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				}
				
			}catch (NoSuchElementException e) {
		        // Log the error and throw a custom exception if element isn't found
		        System.out.println("Element not found after waiting for " + my_time + " seconds.");
//		        throw new Exception("Element not found after waiting for " + my_time + " seconds: " + locator);
		    }catch(Exception e) {	
				System.out.println("Exception in catch block");
				Thread.sleep(1000);
			}finally {
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
		}
//		if (my_time > timeToWait) {
//			ThrowException(MethodName, driver, locator);
//
//		}
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public synchronized void Tap_On_Element(String MethodName, AppiumDriver<MobileElement> driver, By locator,
			int timeToWait) throws Exception {
		int my_time = 0;
		while (my_time < timeToWait) {
			my_time = my_time + 1;
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(1))   // Total wait time
		            .pollingEvery(Duration.ofMillis(500))           // Poll every 500ms
		            .ignoring(NoSuchElementException.class);
			MobileElement ele = null;
			try {
				ele = get_AppiumElement(driver, locator);
				if (ele != null) {
					if (ele.isEnabled()) {
						ele.click();
						break;

					} else {
						ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
					}
				}else {
					ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				}
				
			}catch (NoSuchElementException e) {
		        // Log the error and throw a custom exception if element isn't found
		        System.out.println("Element not found after waiting for " + my_time + " seconds.");
//		        throw new Exception("Element not found after waiting for " + my_time + " seconds: " + locator);
		    }catch(Exception e) {	
				System.out.println("Exception in catch block");
				Thread.sleep(1000);
			}finally {
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
		}
		if (my_time > timeToWait) {
			ThrowException(MethodName, driver, locator);

		}
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public boolean Contains_Text(String MethodName, AppiumDriver<MobileElement> driver, By locator,
			String Expected_Text, int timeToWait) throws Exception {
		int my_time = 0;
		boolean flag = false;
		while (my_time < timeToWait) {
			my_time = my_time + 1;
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(1))   // Total wait time
		            .pollingEvery(Duration.ofMillis(500))           // Poll every 500ms
		            .ignoring(NoSuchElementException.class);
			MobileElement ele = null;
			try {
				ele = get_AppiumElement(driver, locator);
				if (ele != null) {
					if (ele.isEnabled()) {
						String Text = ele.getText();
						if (Text != null) {
							if (!Text.trim().isEmpty()) {
								if (Text.trim().contains(Expected_Text)) {
									flag = true;
								}
							}
						}
						break;

					} else {
						ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
					}
				}else {
					ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				}
				
			}catch (NoSuchElementException e) {
		        // Log the error and throw a custom exception if element isn't found
		        System.out.println("Element not found after waiting for " + my_time + " seconds.");
//		        throw new Exception("Element not found after waiting for " + my_time + " seconds: " + locator);
		    }catch(Exception e) {	
				System.out.println("Exception in catch block");
				Thread.sleep(1000);
			}finally {
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
		}
		if (my_time > timeToWait) {
			ThrowException(MethodName, driver, locator);
		}
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return flag;
	}
	

	public synchronized void Sendkeys(String MethodName, AppiumDriver<MobileElement> driver, By locator, String data,
			int timeToWait) throws Exception {
		int my_time = 0;
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		while (my_time < timeToWait) {
			my_time = my_time + 1;
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(1))   // Total wait time
		            .pollingEvery(Duration.ofMillis(500))           // Poll every 500ms
		            .ignoring(NoSuchElementException.class);
			MobileElement ele = null;
			try {
				ele = get_AppiumElement(driver, locator);
				if (ele != null) {
					if (ele.isEnabled()) {
						ele.click();
						Thread.sleep(100);
						ele.clear();
						Thread.sleep(100);
						ele.sendKeys(data);
						break;
					} else {
						ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
					}
				}else {
					ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				}
				
			}catch (NoSuchElementException e) {
		        // Log the error and throw a custom exception if element isn't found
		        System.out.println("Element not found after waiting for " + my_time + " seconds.");
//		        throw new Exception("Element not found after waiting for " + my_time + " seconds: " + locator);
		    }catch(Exception e) {	
				System.out.println("Exception in catch block");
				Thread.sleep(1000);
			}finally {
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
		}

		if (my_time > timeToWait) {
			ThrowException(MethodName, driver, locator);
		}
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	

	public synchronized void wait_for_Element(String MethodName, AppiumDriver<MobileElement> driver, By locator,
			int timeToWait) throws Exception {
		int my_time = 0;
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		while (my_time < timeToWait) {
			my_time = my_time + 1;
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(1))   // Total wait time
		            .pollingEvery(Duration.ofMillis(500))           // Poll every 500ms
		            .ignoring(NoSuchElementException.class);
			MobileElement ele = null;
			try {
				ele = get_AppiumElement(driver, locator);
				if (ele != null) {
					if (ele.isEnabled()) {
						break;

					}else {
							ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
						}
					}else {
						ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
					}
					
				}catch (NoSuchElementException e) {
			        // Log the error and throw a custom exception if element isn't found
			        System.out.println("Element not found after waiting for " + my_time + " seconds.");
//			        throw new Exception("Element not found after waiting for " + my_time + " seconds: " + locator);
			    }catch(Exception e) {	
					System.out.println("Exception in catch block");
					Thread.sleep(1000);
				}finally {
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				}
			}
		if (my_time >= timeToWait) {
			ThrowException(MethodName, driver, locator);

		}
	}
	
	public synchronized void wait_for_Element_isDisplayed(String MethodName, AppiumDriver<MobileElement> driver,By locator, int timeToWait) throws Exception {
		int my_time = 0;
			while(my_time<timeToWait) {
				my_time = my_time+1;
				Thread.sleep(1000);
				Wait<AppiumDriver<MobileElement>> wait = new FluentWait<>(driver)
			            .withTimeout(Duration.ofSeconds(1))   // Total wait time
			            .pollingEvery(Duration.ofMillis(500))           // Poll every 500ms
			            .ignoring(NoSuchElementException.class);
				MobileElement ele = null;
				try {
					ele = get_AppiumElement(driver, locator);
					if(ele!=null) {
						if(ele.isDisplayed()) {
							break;
							
						}else {
							ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
						}
					}else {
						ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
					}
					
				}catch (NoSuchElementException e) {
			        // Log the error and throw a custom exception if element isn't found
			        System.out.println("Element not found after waiting for " + my_time + " seconds.");
//			        throw new Exception("Element not found after waiting for " + my_time + " seconds: " + locator);
			    }catch(Exception e) {	
					System.out.println("Exception in catch block");
					Thread.sleep(1000);
				}finally {
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				}
			}
			
			if(my_time>timeToWait) {
				ThrowException(MethodName, driver, locator);
				
			}
			
			
	}
	
	public synchronized String getText(AppiumDriver<MobileElement> driver, By locator) throws Exception {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String Data = "";
		MobileElement ele = null;
		try {
			ele = get_AppiumElement(driver, locator);
			if (ele != null) {
				if (ele.isEnabled()) {
					String text = ele.getText();
					if (text != null) {
						if (!text.trim().isEmpty()) {
							Data = text.trim();
						}
					}

				}
			}

		} catch (Exception e) {
			driver.quit();
			throw new Exception();

		}

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return Data;
	}
	
	//changes has to be done

	public synchronized void wait_for_Element_WithOutThrowing_Exception(AppiumDriver<MobileElement> driver, By locator,
			int timeToWait) throws Exception {
		int my_time = 0;
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		while (my_time < timeToWait) {
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(1))   // Total wait time
		            .pollingEvery(Duration.ofMillis(500))           // Poll every 500ms
		            .ignoring(NoSuchElementException.class);
			my_time = my_time + 1;
			MobileElement ele = null;
			try {
				ele = get_AppiumElement(driver, locator);
				if (ele != null) {
					if (ele.isEnabled()) {
						break;

					} else {
						ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
					}
				}else {
					ele = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				}

			} catch (NoSuchElementException e) {
		        // Log the error and throw a custom exception if element isn't found
		        System.out.println("Element not found after waiting for " + my_time + " seconds.");
//		        throw new Exception("Element not found after waiting for " + my_time + " seconds: " + locator);
		    }catch(Exception e) {	
				System.out.println("Exception in catch block");
				Thread.sleep(1000);
			}finally {
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
		}
	}

	public synchronized boolean isDisplayed(AppiumDriver<MobileElement> driver, By locator)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		boolean flag = false;
		MobileElement ele = null;
		try {
			ele = get_AppiumElement(driver, locator);
			if (ele != null) {
				if (ele.isDisplayed()) {
					flag = true;
				}
			}

		} catch (Exception e) {

		}

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return flag;
	}

	public synchronized void Scroll_With_Coordinates(AppiumDriver<MobileElement> driver, String DeviceType, int startx,
			int starty, int endx, int endy) throws Exception {
		try {
			if (DeviceType.equals("ANDROID_MOB")) {
				new TouchAction<>(driver).press(new PointOption<>().withCoordinates(startx, starty))
						.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(5)))
						.moveTo(new PointOption<>().withCoordinates(endx, endy)).release().perform();

			} else if (DeviceType.equals("IOS_MOB")) {
				new TouchAction<>(driver).press(new PointOption<>().withCoordinates(startx, starty))
						.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(5)))
						.moveTo(new PointOption<>().withCoordinates(endx, endy)).release().perform();
			}

		} catch (Exception e) {
			driver.quit();
			throw new Exception();

		}

	}

	public void ThrowException(String MethodName, AppiumDriver<MobileElement> driver, By locator) throws Exception {
		System.out.println("Exception is in throw block"); 
		throw new Exception();

	}

}
