# EcommerceAutomationByUsingTestNG
This project involves automating the testing of an online store created with the Selenium Web Driver and the TestNG testing framework.

Key modules and pages that are automated include:

SignUp
Login
Search
Cart
Checkout

# Technology:

Tool: Selenium Webdriver
IDE: Intellij IDEA
Build tool: Gradle
Language: Java
Testing Framework : TestNG

# Prerequisite:

Need to set up gradle, allure, and jdk 11
Set up the environment variables for gradle, allure, and jdk 11
Unzip this project after cloning it.
Double-click "build.gradle" in the project folder after opening it in IntellIJ IDEA.
Permit the initiative to succeed.
Run the automation programs by clicking "Terminal"

# Use the following command to run the automation script:

gradle clean test 

Selenium will open the browser and start automating.
After automation to view allure report , give the following commands:

allure generate allure-results --clean -o allure-report

allure serve allure-results
# AllureOverview

![Allureoverview](https://user-images.githubusercontent.com/61340440/192091670-4a11129e-479a-4656-967b-1074e0277ff1.JPG)

# AllureSuites

![Alluresuites](https://user-images.githubusercontent.com/61340440/192091709-fe9f75fd-0596-493f-ab37-0ce518e877b2.JPG)

# AllureGraph

![alluregraph](https://user-images.githubusercontent.com/61340440/192091722-f84092e1-f7fc-4937-bf83-4324a1047334.JPG)
