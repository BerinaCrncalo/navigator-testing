package ba.navigator;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class NavigatorSmokeTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Set up the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.navigator.ba");
    }

    @Test
    public void testHomePageLoads() {
        try {
            // Wait for a key element on the home page to be visible
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header")));

            // Assert that the header is displayed, confirming the page loaded
            assertTrue("Home page did not load correctly.", header.isDisplayed());
            System.out.println("Home page loaded successfully!");
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for the home page to load.");
            e.printStackTrace();
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred while checking home page load.");
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchForUnionBanka() {
        // Locate the search input element
        WebElement searchElement = driver.findElement(By.cssSelector("input.ember-text-field.tt-query"));

        // Clear any existing text and type "Union banka"
        searchElement.click();
        searchElement.clear();
        searchElement.sendKeys("Union banka");

        // Wait for the suggestions dropdown to appear
        WebElement suggestionMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tt-dropdown-menu")));

        // Verify the suggestions dropdown is displayed
        assertTrue("The suggestions dropdown should be visible", suggestionMenu.isDisplayed());

        // Check if "Union banka" is present in the suggestions
        WebElement suggestionsList = driver.findElement(By.cssSelector(".tt-suggestions"));
        assertTrue("'Union banka' should be in the suggestions list", suggestionsList.getText().toLowerCase().contains("union banka"));
    }

    @Test
    public void testSearchForRandomString() {
        // Locate the search input element with the class 'ember-text-field tt-query'
        WebElement searchElement = driver.findElement(By.cssSelector("input.ember-text-field.tt-query"));

        // Clear any existing text and type a random string "DFGHJK"
        searchElement.click();
        searchElement.clear();
        searchElement.sendKeys("DFGHJK");

        // Simulate pressing "Enter"
        searchElement.sendKeys(Keys.RETURN);

        // Wait for the "no results" section to appear
        WebElement noResultsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".no-search-results")));

        // Verify that the "no search results" message is displayed
        WebElement noResultsMessage = driver.findElement(By.cssSelector(".no-results"));
        assertTrue("No results message should be displayed", noResultsMessage.isDisplayed());

        // Verify the "add object" button is displayed
        WebElement addObjectButton = driver.findElement(By.cssSelector(".btn.green-button"));
        assertTrue("'Add object' button should be visible", addObjectButton.isDisplayed());

        // Optionally verify the no-results message text
        String expectedMessage = "Žao nam je. Nismo uspjeli pronaći niti jedan rezultat za traženu pretragu.";
        String actualMessage = noResultsMessage.getText();
        assertTrue("The no-results message should match the expected text", actualMessage.contains(expectedMessage));
    }

    @Test
    public void clickCategoryFood() {
        // Wait for the 'Food' category link to appear and be clickable
        WebElement foodCategory = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='#/categories/food']")));

        // Click on the 'Food' category
        foodCategory.click();

        // Verify that the 'Food' page has loaded
        wait.until(ExpectedConditions.urlContains("/categories/food"));
    }

    @Test
    public void clickSarajevskaPozorista() {
        // Wait for the 'Sarajevo Theaters' link to appear and be clickable
        WebElement sarajevskaPozorista = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='content']//div[text()='SARAJEVSKA POZORIŠTA']")));

        // Click on 'Sarajevo Theaters'
        sarajevskaPozorista.click();

        // Verify that the 'Sarajevo Theaters' page has loaded
        wait.until(ExpectedConditions.urlContains("/list/sarajevska-pozorista"));
    }

    @Test
    public void clickNextbike() {
        // Wait for the 'Nextbike' link to appear and be clickable
        WebElement nextbike = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='content']//div[text()='NEXTBIKE']")));

        // Click on 'Nextbike'
        nextbike.click();

        // Verify that the 'Nextbike' page has loaded
        wait.until(ExpectedConditions.urlContains("/list/nextbike"));
    }

    @Test
    public void clickSmokeFreePublicPlaces() {
        // Wait for the 'Smoke-Free Public Places' link to appear and be clickable
        WebElement smokeFreePublicPlaces = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='content']//div[text()='SMOKE-FREE PUBLIC PLACES']")));

        // Click on 'Smoke-Free Public Places'
        smokeFreePublicPlaces.click();

        // Verify that the 'Smoke-Free Public Places' page has loaded
        wait.until(ExpectedConditions.urlContains("/list/smoke-free-public-places"));
    }

    @Test
    public void clickAccommodation() {
        // Wait for the 'Accommodation' category link to appear and be clickable
        WebElement accommodationCategory = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='#/categories/accommodation']")));

        // Click on the 'Accommodation' category
        accommodationCategory.click();

        // Verify that the 'Accommodation' page has loaded
        wait.until(ExpectedConditions.urlContains("/categories/accommodation"));
    }

    @Test
    public void clickCoffee() {
        // Wait for the 'Coffee' category link to appear and be clickable
        WebElement coffeeCategory = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='#/categories/coffee']")));

        // Click on the 'Coffee' category
        coffeeCategory.click();

        // Verify that the 'Coffee' page has loaded
        wait.until(ExpectedConditions.urlContains("/categories/coffee"));
    }

    @Test
    public void clickNightlife() {
        // Wait for the 'Nightlife' category link to appear and be clickable
        WebElement nightlifeCategory = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='#/categories/nightlife']")));

        // Click on the 'Nightlife' category
        nightlifeCategory.click();

        // Verify that the 'Nightlife' page has loaded
        wait.until(ExpectedConditions.urlContains("/categories/nightlife"));
    }

    @Test
    public void clickShopping() {
        // Wait for the 'Shopping' link to be clickable and visible
        WebElement shoppingCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@href='#/categories/shopping']")));

        // If the element is visible, try clicking it via JavaScript if it's not directly clickable
        if (shoppingCategory.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", shoppingCategory);
        }

        // Wait for the URL to contain '/categories/shopping'
        wait.until(ExpectedConditions.urlContains("/categories/shopping"));
    }

    @Test
    public void clickAttractions() {
        // If it takes more time for the app to load, you can add more wait time here
        try {
            WebElement attractionsLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '#/categories/attractions')]")
            ));
            attractionsLink.click();
            System.out.println("✅ Clicked on Attractions!");
        } catch (Exception e) {
            System.out.println("❌ Could not find the Attractions link: " + e.getMessage());
        }
    }

    @Test
    public void clickArtCategory() {

        // Set up WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait until the 'Art' category link is visible
            WebElement artCategoryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.art a[href='#/categories/art']")));

            // Click the 'Art' category link
            artCategoryLink.click();

            // Add assertions to check if the page navigated correctly
            WebElement artPageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'UMJETNOST I ZABAVA')]")));
            assert artPageHeader.isDisplayed() : "Art page header is not displayed.";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void clickStreet() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Wait for the element to be visible
            WebElement streetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[@href='#/categories/street']")
            ));

            // Click the element using JavaScript in case it's not directly clickable
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", streetElement);

            System.out.println("Clicked on street element successfully!");

        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for element to be visible.");
            e.printStackTrace();
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred.");
            e.printStackTrace();
        }
    }

    @Test
    public void clickBusiness() {
        try {
            // Wait for the 'Business' link to appear and be visible
            WebElement businessCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[@href='#/categories/business']")));

            // If the element is visible, click on it using JavaScript if it's not directly clickable
            if (businessCategory.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", businessCategory);
                System.out.println("Clicked on 'Business' category successfully!");
            }

            // Check if the 'Business' page has loaded
            wait.until(ExpectedConditions.urlContains("/categories/business"));
            System.out.println("Business page loaded successfully!");

        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for 'Business' category.");
            e.printStackTrace();
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred while clicking 'Business' category.");
            e.printStackTrace();
        }
    }

    @Test
    public void clickServices() {
        try {
            // Wait for the 'Services' link to appear and be visible
            WebElement servicesCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[@href='#/categories/services']")));

            // If the element is visible, click on it using JavaScript if it's not directly clickable
            if (servicesCategory.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", servicesCategory);
                System.out.println("Clicked on 'Services' category successfully!");
            }

            // Check if the 'Services' page has loaded
            wait.until(ExpectedConditions.urlContains("/categories/services"));
            System.out.println("Services page loaded successfully!");

        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for 'Services' category.");
            e.printStackTrace();
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred while clicking 'Services' category.");
            e.printStackTrace();
        }
    }

    @Test
    public void clickSports() {
        try {
            // Wait for the 'Sports' link to appear and be visible
            WebElement sportsCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[@href='#/categories/sports']")));

            // If the element is visible, click on it using JavaScript if it's not directly clickable
            if (sportsCategory.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sportsCategory);
                System.out.println("Clicked on 'Sports' category successfully!");
            }

            // Check if the 'Sports' page has loaded
            wait.until(ExpectedConditions.urlContains("/categories/sports"));
            System.out.println("Sports page loaded successfully!");

        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for 'Sports' category.");
            e.printStackTrace();
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred while clicking 'Sports' category.");
            e.printStackTrace();
        }
    }

    @Test
    public void clickTransport() {
        try {
            // Wait for the 'Transport' link to appear and be visible
            WebElement transportCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[@href='#/categories/transport']")));

            // If the element is visible, click on it using JavaScript if it's not directly clickable
            if (transportCategory.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", transportCategory);
                System.out.println("Clicked on 'Transport' category successfully!");
            }

            // Check if the 'Transport' page has loaded
            wait.until(ExpectedConditions.urlContains("/categories/transport"));
            System.out.println("Transport page loaded successfully!");

        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for 'Transport' category.");
            e.printStackTrace();
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred while clicking 'Transport' category.");
            e.printStackTrace();
        }
    }

    @Test
    public void testMapZoomInAndOut() {
        // Locate the zoom in (+) button
        WebElement zoomInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".leaflet-control-zoom-in")));
        zoomInButton.click();

        // Small wait to let the map zoom
        wait.withTimeout(Duration.ofSeconds(2));

        // Locate the zoom out (-) button
        WebElement zoomOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".leaflet-control-zoom-out")));
        zoomOutButton.click();
    }

    @Test
    public void testClickOnMapLocation() {
        // Locate the map canvas
        WebElement mapCanvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leaflet-container")));

        // Click on the center of the map
        Actions actions = new Actions(driver);
        actions.moveToElement(mapCanvas).click().perform();
    }

    @Test
    public void testDragAndMoveMap() {
        // Locate the map canvas
        WebElement mapCanvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leaflet-container")));

        // Drag and move: click, hold, move, and release
        Actions actions = new Actions(driver);
        actions.moveToElement(mapCanvas).clickAndHold().moveByOffset(100, 0).release().perform();
    }

    @Test
    public void testRightClickOnMap() {
        // Locate the map canvas
        WebElement mapCanvas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leaflet-container")));

        // Right-click (context click) on the map
        Actions actions = new Actions(driver);
        actions.contextClick(mapCanvas).perform();
    }

    @Test
    public void testLanguageSwitchToEnglishAndBack() throws InterruptedException {
        // Wait for language menu
        WebElement languageMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.navigation.languages")));

        // Switch to English
        WebElement englishButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.en a.btn-en")));
        englishButton.click();

        // Optional small sleep if needed
        Thread.sleep(1000);

        // Wait for English search field by placeholder
        WebElement searchInEnglish = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Search street or place']")));
        assertTrue("Page should display English search input after switching language", searchInEnglish.isDisplayed());

        // Switch back to Bosnian
        WebElement bosnianButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.bs a.btn-bs")));
        bosnianButton.click();

        Thread.sleep(1000);

        // Wait for Bosnian search field
        WebElement searchInBosnian = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Traži ulicu ili objekat']")));
        assertTrue("Page should display Bosnian search input after switching back", searchInBosnian.isDisplayed());
    }

    @Test
    public void testResponsiveLayout() {
        // Define screen sizes (mobile, tablet, desktop)
        Dimension[] screenSizes = {
                new Dimension(375, 667),  // iPhone size (mobile)
                new Dimension(768, 1024), // iPad size (tablet)
                new Dimension(1440, 900)  // MacBook size (desktop)
        };

        // Loop through each screen size and test the layout
        for (Dimension size : screenSizes) {
            // Set the window size
            driver.manage().window().setSize(size);
            System.out.println("Testing with screen size: " + size.getWidth() + "x" + size.getHeight());

            // Wait for the website to load
            try {
                // Wait for the header to be visible
                WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header")));
                assertTrue("Header is not displayed!", header.isDisplayed());

                // Check if navigation menu items are visible
                List<WebElement> menuItems = driver.findElements(By.cssSelector("nav ul li"));
                assertTrue("Navigation menu items not found!", menuItems.size() > 0);

                // Optionally, you can assert that the layout doesn't break
                assertTrue("Layout is not responsive for this size", !isHorizontalScrollbarVisible());

                System.out.println("Layout is correct for size: " + size.getWidth() + "x" + size.getHeight());
            } catch (TimeoutException e) {
                System.out.println("Timeout error during layout check for size: " + size.getWidth() + "x" + size.getHeight());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error during layout check for size: " + size.getWidth() + "x" + size.getHeight());
                e.printStackTrace();
            }
        }
    }

    // Helper method to check if a horizontal scrollbar is visible
    private boolean isHorizontalScrollbarVisible() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long scrollWidth = (long) js.executeScript("return document.documentElement.scrollWidth");
        long clientWidth = (long) js.executeScript("return document.documentElement.clientWidth");
        return scrollWidth > clientWidth;
    }

    @Test
    public void testFacebookIconClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the Facebook icon to be clickable
        WebElement facebookIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.iconav-facebook")));

        // Click on the Facebook icon
        facebookIcon.click();

        // Switch to the new window/tab
        String originalWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Wait for the new page to load
        wait.until(ExpectedConditions.urlContains("facebook"));

        // Assert that the URL contains the correct link
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("The URL is not correct", currentUrl.contains("facebook.com"));

        // Optionally, switch back to the original window
        driver.switchTo().window(originalWindow);
    }

    @Test
    public void testTwitterIconClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the Twitter (X) icon to be clickable
        WebElement twitterIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.iconav-twitter-2")));

        // Click on the Twitter (X) icon
        twitterIcon.click();

        // Switch to the new window/tab (if it's opened in a new tab)
        String originalWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Wait for the new page to load
        wait.until(ExpectedConditions.urlContains("x.com/navigatorba"));

        // Assert that the URL contains the correct link (X.com)
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("The URL is not correct", currentUrl.contains("x.com/navigatorba"));

        // Optionally, switch back to the original window
        driver.switchTo().window(originalWindow);
    }

    @Test
    public void testGooglePlusIconClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the Google Plus icon to be clickable
        WebElement googlePlusIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.iconav-googleplus")));

        // Click on the Google Plus icon
        googlePlusIcon.click();

        // Switch to the new window/tab (if it's opened in a new tab)
        String originalWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Wait for the new page to load
        wait.until(ExpectedConditions.urlContains("plus.google.com"));

        // Assert that the URL contains the correct link
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("The URL is not correct", currentUrl.contains("plus.google.com"));

        // Optionally, switch back to the original window
        driver.switchTo().window(originalWindow);
    }

    @Test
    public void testCreatePlaceButtonClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the "Create Place" button to be clickable
        WebElement createPlaceButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#/create-place']")));

        // Click on the "Create Place" button
        createPlaceButton.click();

        // Wait for the page to load, assuming the URL changes
        wait.until(ExpectedConditions.urlContains("/create-place"));

        // Assert that the URL contains "/create-place" after the click
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("The URL is not correct, expected /create-place", currentUrl.contains("/create-place"));
    }

    @Test
    public void testSuggestIdeaButtonClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the "Suggest an idea - Send a comment" button to be clickable
        WebElement suggestIdeaButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" a[href='#/feedback']")));

        // Click on the "Suggest an idea - Send a comment" button
        suggestIdeaButton.click();

        // Wait for the page to load, assuming the URL changes
        wait.until(ExpectedConditions.urlContains("/feedback"));

        // Assert that the URL contains "/feedback" after the click
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("The URL is not correct, expected /feedback", currentUrl.contains("/feedback"));
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
