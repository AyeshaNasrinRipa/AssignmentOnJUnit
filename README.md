

## 📘 Project Overview

This project contains two JUnit automation test cases developed using **Java**, **Selenium WebDriver**, and **JUnit**.  
Both test cases are designed to demonstrate automation of web elements and data extraction.

---

## 🚀 Task 1: Webform Automation

**URL:** [https://www.digitalunite.com/practice-webform-learners](https://www.digitalunite.com/practice-webform-learners)

### 📝 Description
This automation script fills out all fields in the web form, submits it, and verifies that the registration submission is successful.  
It demonstrates JUnit assertions, form handling, and synchronization in Selenium.

### ⚙️ Steps Performed
1. Opened the practice webform URL.  
2. Entered data into all required fields (name, email, phone, and message).  
3. Clicked the **Submit** button.  
4. Asserted the success message after form submission.  

### 🧾 Report Screenshot
<img width="1338" height="600" alt="image" src="https://github.com/user-attachments/assets/3464c389-b8cf-484b-8da5-8a949fe0009d" />


### 📹 Video Recording
[▶ Watch Webform Automation Video](videos/webform_automation.mp4)

---

## 📊 Task 2: DSEBD Table Data Scraping

**URL:** [https://dsebd.org/latest_share_price_scroll_by_value.php](https://dsebd.org/latest_share_price_scroll_by_value.php)

### 📝 Description
This automation script extracts all stock market table data from the DSEBD website, prints it in the console, and stores the extracted data in a text file.

### ⚙️ Steps Performed
1. Opened the DSEBD share price page.  
2. Located the table element.  
3. Extracted all cell data (row by row).  
4. Printed all table cell values to the console.  
5. Saved the output into a text file inside the **`results/`** folder.  

### 📄 Output File
[📂 Download DSE Data]

### 🧾 Report Screenshot
<img width="1356" height="633" alt="image" src="https://github.com/user-attachments/assets/a8e0113f-46dc-497a-a8cd-88638368596b" />


### 📹 Video Recording
[▶ Watch DSE Scraping Video](videos/dse_scraping.mp4)

---

## 📁 Project Structure
JUnit_WebAutomation
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
├── README.md
├── gradle
│   └── wrapper
│       └── gradle-wrapper.jar
└── src
    └── test
        ├── java
        │   ├── BaseTest.java
        │   ├── DSETableScraper.java
        │   ├── Utils.java
        │   └── WebFormAutomationTest.java
        └── resources
            └── report.txt





