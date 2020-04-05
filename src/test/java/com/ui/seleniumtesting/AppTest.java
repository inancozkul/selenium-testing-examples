package com.ui.seleniumtesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public class AppTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/Users/ext02d20664/Documents/chromedriverdonotdelete/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        run(driver);

    }

    public static void run(WebDriver driver) {
        keyPress(driver, "keypress");
        autoComplete(driver, "autocomplete");
        scrolltoElement(driver, "scroll");
        switchWindow(driver, "switch-window");
        alertButton(driver, "switch-window");
        modal(driver, "modal");
        DragandDrop(driver, "dragdrop");
        differenceDeclearing(driver, "modal");
        radioButton(driver, "radiobutton");
        checkBox(driver, "checkbox");
        datePicker(driver, "datepicker");
        dropDown(driver, "dropdown");
        fileUpload(driver, "fileupload");
        form(driver, "form");
        formwithPagination(driver, "form");
        kill(driver);
    }
    public static void maximixeScreen(WebDriver driver) {
        /* Change screen: from minimized to maximize*/
        driver.manage().window().maximize();
    }
    public static void keyPress(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Key Press Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        //driver.navigate().to("https://formy-project.herokuapp.com/keypress");
        maximixeScreen(driver);
        WebElement input = driver.findElement(By.id("name"));
        //WebElement name = driver.findElement(By.xpath("//input[@class='form-control'][@id='name'][@placeholder='Enter full name']"));
        input.click();
        input.sendKeys("Inanc Ozkul");
        WebElement button = driver.findElement(By.id("button"));
        //WebElement button = driver.findElement(By.xpath("//button[@type='button'][@class='btn btn-primary btn-lg'][@id='button']"));
        button.click();
    }
    public static void autoComplete(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Auto Complete Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement input = driver.findElement(By.id("autocomplete"));
        //WebElement input = driver.findElement(By.xpath("//input[@id='autocomplete'][@placeholder='Enter address']"));
        input.sendKeys("155 Park Blvd, Palo Alto, Kaliforniya, Amerika Birleşik Devletler");
        delayy(1);
        WebElement autocompleteResults = driver.findElement(By.className("pac-item"));
        //WebElement autocompleteResults = driver.findElement(By.xpath("//div[@class='pac-item']"));
        autocompleteResults.click();
    }

    public static void scrolltoElement(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Scroll Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement input = driver.findElement(By.id("name"));
        //WebElement input = driver.findElement(By.xpath("//input[@id='name'][@placeholder='Full name']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(input);
        input.sendKeys("Inanc Ozkul");
        WebElement date = driver.findElement(By.id("date"));
        //WebElement date = driver.findElement(By.xpath("//input[@id='date'][@placeholder='MM/DD/YYYY']"));
        date.sendKeys("04/04/2020");
    }
    public static void switchWindow(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Switch Window Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        //WebElement newTabButton = driver.findElement(By.xpath("//button[@type='button'][@onclick=\"window.open('https://formy-project.herokuapp.com/');\"]"));
        newTabButton.click();
        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        implicitlyWait(driver);
        driver.switchTo().window(originalHandle);
    }

    public static void alertButton(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Alert Button Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement alertButton = driver.findElement(By.id("alert-button"));
        //WebElement alertButton = driver.findElement(By.xpath("//button[@id='alert-button'][@onclick=\"myFunction()\"]"));
        alertButton.click();
        delayy(1);
        Alert alert = driver.switchTo().alert();
        delayy(1);
        alert.accept();
    }
    public static void modal(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Modal Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement modalButton = driver.findElement(By.id("modal-button"));
        //WebElement alertButton = driver.findElement(By.xpath("//button[@id='modal-button'][@data-target="#exampleModal"]"));
        modalButton.click();
        delayy(1);
        WebElement closeButton = driver.findElement(By.id("close-button"));
        //WebElement closeButton = driver.findElement(By.xpath("//button[@type='button'][@id='close-button']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeButton);
        delayy(1);
        modalButton.click();
        implicitlyWait(driver);
        WebElement okButton = driver.findElement(By.id("ok-button"));
        //WebElement okButton = driver.findElement(By.xpath("//button[@type='button'][@id='ok-button']"));
        js.executeScript("arguments[0].click();", okButton);
        /* There isn't any event on ok Button so i add close Button below */
        js.executeScript("arguments[0].click();", closeButton);
    }
    public static void DragandDrop(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Drag & Drop Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement image = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));
        Actions action = new Actions(driver);
        action.dragAndDrop(image, box).build().perform();
    }
    public static void differenceDeclearing(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Other Different Decleares Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        implicitlyWait(driver);
        System.out.println("Find element with ID");
        WebElement id_button = driver.findElement(By.cssSelector("#modal-button"));
        System.out.println("Find element with ID#2");
        WebElement id_button2 = driver.findElement(By.cssSelector("button#modal-button"));
        System.out.println("Find element with Class");
        WebElement class_button = driver.findElement(By.cssSelector(".btn.btn-primary"));
        System.out.println("Find element with Class#2");
        WebElement class_button2 = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        System.out.println("Find element with Prefix");
        WebElement prefix_button = driver.findElement(By.cssSelector("button[id^='modal-bu']"));
        System.out.println("Find element with Suffix");
        WebElement suffix_button = driver.findElement(By.cssSelector("button[id$='utton']"));
        System.out.println("Find element with Substring");
        WebElement substring_button = driver.findElement(By.cssSelector("button[id*='-butt']"));
        System.out.println("Find element with Chield-Parent relationship");
        driver.findElement(By.xpath("//form[.//button[@data-target='#exampleModal']]"));
    }
    public static void radioButton(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Radio Button Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        radioButton1.click();
        implicitlyWait(driver);
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        radioButton2.click();
        WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
        radioButton3.click();
    }
    public static void checkBox(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Checkbox Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement checkBox1 = driver.findElement(By.id("checkbox-1"));
        checkBox1.click();
        implicitlyWait(driver);
        WebElement checkBox2 = driver.findElement(By.cssSelector("input[value='checkbox-2']"));
        checkBox2.click();
        WebElement checkBox3 = driver.findElement(By.xpath("//*[@id=\"checkbox-3\"]"));
        checkBox3.click();
    }
    public static void datePicker(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Date Picker Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("04/04/2020");
        dateField.sendKeys(Keys.RETURN);
    }
    public static void dropDown(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Drop Down Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement dropdownMenu = driver.findElement(By.id("dropdownMenuButton"));
        dropdownMenu.click();
        WebElement autoComplete = driver.findElement(By.id("autocomplete"));
        autoComplete.click();
        implicitlyWait(driver);
        driver.get("https://formy-project.herokuapp.com/" + url);
        WebElement dropdownMenu2 = driver.findElement(By.id("dropdownMenuButton"));
        dropdownMenu2.click();
        WebElement buttons = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[@href='/buttons']"));
        implicitlyWait(driver);
        buttons.click();
    }
    public static void fileUpload(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("File Upload Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        WebElement fileUpload = driver.findElement(By.id("file-upload-field"));
        fileUpload.sendKeys("C:\\Users\\User_Name\\Desktop\\test.jpeg");
    }
    public static void form(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Form Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        driver.findElement(By.id("first-name")).sendKeys("İnanç");
        driver.findElement(By.id("last-name")).sendKeys("Özkul");
        driver.findElement(By.id("job-title")).sendKeys("Software Test Engineer");
        driver.findElement(By.id("radio-button-1")).click();
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("07/31/1996");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
        delayy(1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alert = wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("alert"))));
        delayy(2);
        String alertText = alert.getText();
        System.out.println("Expected = " + alertText);
        if (alertText.equals("The form was successfully submitted!")) System.out.println("OK");
        else System.out.println("NOK");
    }
    public static void formwithPagination(WebDriver driver, String url) {
        System.out.println("*******");
        System.out.println("Form With Pagination Example");
        System.out.println("*******");
        driver.get("https://formy-project.herokuapp.com/" + url);
        maximixeScreen(driver);
        FormPage formPage = new FormPage();
        formPage.submitForm(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.waitForAlertBanner(driver);
        assertEquals("The form was successfully submitted!", confirmationPage.getAlertBannerText(driver));
    }
    public static void implicitlyWait(WebDriver driver) {
        /* Using delay with webdriver agaisnt Thread.sleep() */
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public static void delayy(int number) {
        /* Waiting command*/
        try {
            Thread.sleep(1000 * number);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
    public static void kill(WebDriver driver) {
        driver.quit();
    }
}
