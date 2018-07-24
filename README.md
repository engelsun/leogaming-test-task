# Test Task for LeoGaming
Installing:
#### 1. Download the archive and then unzip
#### 2. Open the unziped folder in your IDE
#### 3. Run the Main class:
```
src\main\java\com\engelsun\leogamingtesttask\Main.java
```
#### - Then you will see in the console an output like this snippet three times:
![screenshot_5](https://user-images.githubusercontent.com/26378027/43102106-e03bc172-8ed2-11e8-816e-92c8730c1a8a.png)

#### 4. If you want more tests, you will may send a POST requests via apps like [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop/related) on the url:
###
```
https://localhost:8443/test/accept
```
    Note! If you will use Postman, i recomented a version for Chrome, because i tested with it. 
- For first you must go to above url in Chrome and click on "ADVANCED" options, then click on "Proceed to localhost (unsafe)"
- then open Postman and you should add the header:
#
```
content-type = application/xml
```
- then choose the raw Radio Button on the Body Tab and paste some xml to input area
- then finally click on the Send Button. You will see something like this:
![screenshot_3](https://user-images.githubusercontent.com/26378027/43097446-ca5e3532-8ec4-11e8-9df8-4d8ba527f9e6.png)

#### 5. Optional: install [Lombok plugin](https://projectlombok.org/setup/overview) to integrate lombok features for your IDE, such as builder(), which is used in the TestData class 
