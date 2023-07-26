Intro:<br>
This is a testautomation testsuite for the homepage and onlineshop for the band "Mandragora Thuringia". <br>
Technologies used:<br>
 → Java 17<br>
 → Neodymium (https://github.com/Xceptance/neodymium-library/)<br>
 → Selenide (https://github.com/selenide/selenide)<br>
 → Selenium Webdriver<br>

Explanation:<br>
This Testsuite was initially a sandbox-playground to fiddle around with new ideas for automated E2E-Tests. By now it has grown to a productive Testsuite for the Bandshop of my Band "Mandragora Thuringia"<br>
It is developed by only myself except the Mailhog-API. Credits herefor go to Marcel Pfotenhauer who helped me building the API.<br>
There are two contributing accounts but both are mine. One I used during work downtime and my private account. <br>
<br>
<br>


Setup (local usage):<br>
→ Download the Chromedriver from https://chromedriver.chromium.org/downloads<br>
→ Clone repo and create a new file in "config" called "dev-neodymium.properties" the prefix "dev-" overwrites the regular neodymium.properties.<br>
<div style="text-indent:10px;">Within this file every Key from the parent property file can be changed for local usage.</div><br>


→ Add neodymium.webDriver.chrome.pathToDriverServer =  [path to chromedriver.exe]<br>
→ Add #neodymium.webDriver.chrome.pathToBrowser = [path to Chrome Browser ]<br><br>

→ Execute any Test from /**/tests either through IDE or via "mvn clean test -DTest=[Testname]<br>
→ For Allure reports ad "allure:serve"

