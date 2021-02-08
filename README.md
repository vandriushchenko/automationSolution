**Test the checkout functionality of this site https://www.saucedemo.com/**   

**Setup on OS X:**
1. Install Homebrew package manager if not installed (https://brew.sh/)
2. Install JDK 8 or higher via Homebrew   
`brew cask install java`  
3. Verify that JDK was installed  
`java -version`
4. Install Maven via Homebrew  
`brew install maven`
5. Verify that Maven was installed  
`mvn -version`
6. Make sure you have Chrome browser installed   
**Note:** Chromedriver will be installed automatically via **webdrivermanager**


**To Run tests from command line:**  
`mvn clean test`  

**View Allure HTML report:**    
`mvn allure:serve`  