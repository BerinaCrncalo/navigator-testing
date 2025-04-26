# 🧭 Navigator.ba - Automated Smoke Test Suite

## 📄 Project Overview
This project contains automated smoke tests for the [Navigator.ba](https://www.navigator.ba) application.  
The tests verify critical functionalities like category navigation, map interactions, social media buttons, and language switching.

Automation is done using **Java**, **Selenium WebDriver**, and **JUnit 5**.

---

## 🛠️ Tech Stack

- **Programming Language:** Java
- **Build Tool:** Maven
- **Testing Framework:** JUnit 5
- **Automation Tool:** Selenium WebDriver
- **Browser:** Chrome (via ChromeDriver)

---

## ⚙️ Prerequisites

Make sure you have the following installed before running the tests:

- Java JDK 11 or higher
- Maven
- Google Chrome browser
- ChromeDriver installed and available in your system PATH

If not already installed:
```bash
# Install Maven (if needed)
brew install maven       # on macOS
sudo apt install maven   # on Ubuntu

# Install ChromeDriver (macOS example)
brew install chromedriver
```

**Important:**  
Make sure the **ChromeDriver version** matches your **Chrome browser version**.

---

## 📥 How to Set Up the Project

1. **Clone the repository:**
   ```bash
   git clone https://github.com/BerinaCrncalo/navigator-testing.git
   cd navigator-testing
   ```

2. **Install Maven dependencies:**
   ```bash
   mvn clean install
   ```

   Maven will automatically download necessary libraries (Selenium, JUnit).

---

## 🚀 How to Run the Tests

To execute all automated smoke tests:

```bash
mvn test
```

This command will:
- Launch Google Chrome
- Open [https://www.navigator.ba](https://www.navigator.ba)
- Execute all smoke tests automatically
- Close the browser after tests are completed

---

## 🧪 Tests Included

The smoke tests verify the following functionalities:

| Test Case | Description |
| :-------- | :---------- |
| Click on Categories | Tests navigation to Street, Business, Services, Sports, Transport categories |
| Map Interaction | Zoom in and Zoom out on the map |
| Create Place Button | Test the Create Place functionality (opens correct URL) |
| Suggest an Idea Button | Test the Suggest an Idea functionality |
| Language Switching | Switch between Bosnian and English languages |
| Social Media Icons | Test external links for Facebook, Twitter, Google Plus |
| Responsive Layout | Test page layout on desktop and mobile viewports |

Each test is marked with `@Test` annotation and includes proper waits for element visibility and clickability.

---

## ⚠️ Error Handling

- **Timeouts:** Handled with explicit waits (`ExpectedConditions`).
- **Element Not Clickable:** Handled using JavaScript clicks when necessary.
- **Exceptions:** Caught and logged for debugging purposes.

---

## 📈 Test Reporting

After running `mvn test`, the **test report** is available in:

```
target/surefire-reports/
```

Look for files like:
- `NavigatorTests.txt`
- `NavigatorTests.xml`

These contain detailed results of test execution.

---
🐞 Bug Reports

1. Incorrect Search Behavior for "Mostar"


   Issue:
   When searching for "Mostar", results incorrectly display "Mostar" and "Sarajevo" locations.

   Expected Behavior:
   Only locations from "Mostar" should appear.

   Actual Behavior:
   Additional unrelated locations (e.g., Sarajevo) are shown.

   Steps to Reproduce:
   1. Open Navigator.ba

   2. Use the search bar on the top left header part, click and type "Mostar"

   3. View search results

For reference see photo1 in photoProof folder

   Impact:
   User search experience is confusing; irrelevant results reduce trust in search reliability.
---

2. Mobile Site Limitations Notice During Browsing


   Issue:
   While scrolling through the Coffee category on mobile (small screen), the following message appears:
   "Ova funkcionalnost nije dostupna na mobile web aplikaciji.
   Za korištenje funkcionalnosti koristite nativnu Navigator.ba aplikaciju."

   Expected Behavior:
   Full category browsing should be available on the mobile web if possible, or the restriction should be communicated before scrolling.

   Actual Behavior:
   User encountered an unexpected restriction mid-browsing.

   Steps to Reproduce:
1. Open Navigator.ba on phone browser
2. Click on any category in Sarajevo
3. Scroll down and you will see the message 

For reference see photo2 in photoProof folder, you will see at the bottom of picture the message.

   Impact:
   Interrupts user experience; suggests downloading native app, but no download link is provided.
---

3. Incomplete Address Display for "Digital Service" Location


   Issue:
   The location "Digital Service" has incomplete and placeholder address fields.
   URL:
   https://www.navigator.ba/p/digital-service 

   Steps to Reproduce:
   1. Visit Navigator.ba
   2. Search for "Digital Service" or find it in listings
   3. Open the location detail page

   Expected Result:
   Full address information should be displayed, including:
   Street Name
   Street Number
   City
   Postal Code

   Actual Result:
   Address fields contain incomplete data:
   1234567, 234567

For reference see photo3 in photoProof folder

   Missing proper street name and city information.
   Impact:
   Users may be misinformed about the location. Impacts the platform’s reliability and professionalism.

3. Outdated Google+ Link:
   The “Google Plus” social media icon points to an old Google+ page. 
Since Google+ was officially shut down, clicking the icon results in a broken link or page error. 
This needs to be updated or removed to prevent broken navigation.


Steps to Reproduce:
Navigate to website, top right corner of header, locate an icon with g+ sign and click on it.

---
Positive and Negative Test Cases

•	Positive Test Cases:

Tests that confirm the system behaves as expected when correct inputs are provided.
Examples:

•	Clicking on each category (Street, Business, Services, Sports, Transport) loads the correct page.

•	Map zoom in/out buttons work as intended.

•	Language switch to English and back to Bosnian updates placeholders properly.

•	Negative Test Cases:

Tests that confirm the system properly handles incorrect or unexpected inputs.

Examples:
•	Timeout exceptions if elements are not found (e.g., broken links or delayed loading).

•	Checking if layout still holds for very small or large screen sizes.

•	Asserting search placeholders to detect if language switch fails.

---

Smoke Tests

The following tests represent smoke tests (basic functionality checks):

•	Clicking on main categories (Street, Business, Services, Sports, Transport).

•	Switching map zoom in and out.

•	Clicking on social media icons (Facebook, Twitter, Google+).

•	Switching language and verifying it visually.

These tests verify the critical paths of the application are working before deeper testing.

---

## 📝 Additional Notes

- Smoke tests are designed to be **lightweight and fast**.
- Tests are idempotent: they can be run multiple times without affecting the system state.
- No user login is required for these tests since Navigator.ba does not have a login system.
- Browser window size is adjusted for responsive layout testing.

---

## 👩‍💻 Maintainer

- **Author:** Berina
- **Contact:** berinacrncalo@icloud.com

---

# 🎯 Quick Commands Summary

| Action | Command |
| :----- | :------ |
| Install dependencies | `mvn clean install` |
| Run tests | `mvn test` |

