// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.thoughtworks.selenium.webdriven;import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class FiniteStateTest {
  WebDriver driver;

  @Before
  public void Setup(){
    System.setProperty("webdriver.chrome.driver" ,  "../../../chromedriver");
    driver = new ChromeDriver();

  }

  @Test
  public void testAlertExist() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See an example alert")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
  }

  @Test
  public void testAlertText() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See an example alert")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    //Wait for the alert to be displayed and store it in a variable
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

    //Store the alert text in a variable
    String text = alert.getText();
    Assert.assertEquals(text,"Sample alert");
  }

  @Test
  public void testAlertClick() throws IOException, InterruptedException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See an example alert")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    //Wait for the alert to be displayed and store it in a variable
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.accept();
    WebDriverWait w = new WebDriverWait(driver, 2);
    boolean thrown = false;
    try {
      w.until(ExpectedConditions.alertIsPresent());
    } catch (TimeoutException e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);
  }




  @Test
  public void testConfirmExist() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See a sample confirm")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
  }

  @Test
  public void testConfirmText() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See a sample confirm")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    //Wait for the alert to be displayed and store it in a variable
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

    //Store the alert text in a variable
    String text = alert.getText();
    Assert.assertEquals(text,"Are you sure?");
  }

  @Test
  public void testConfirmClickYes() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See a sample confirm")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    //Wait for the alert to be displayed and store it in a variable
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.accept();
    WebDriverWait w = new WebDriverWait(driver, 2);
    boolean thrown = false;
    try {
      w.until(ExpectedConditions.alertIsPresent());
    } catch (TimeoutException e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);
  }

  @Test
  public void testConfirmClickNo() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See a sample confirm")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    //Wait for the alert to be displayed and store it in a variable
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.dismiss();
    WebDriverWait w = new WebDriverWait(driver, 4);
    boolean thrown = false;
    try {
      w.until(ExpectedConditions.alertIsPresent());
    } catch (TimeoutException e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);
  }



  @Test
  public void testPromptExist() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See a sample prompt")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    Assert.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
  }

  @Test
  public void testPromptText() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See a sample prompt")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    //Wait for the alert to be displayed and store it in a variable
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

    //Store the alert text in a variable
    String text = alert.getText();
    Assert.assertEquals(text,"What is your tool of choice?");
  }

  @Test
  public void testPromptClickYes() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See a sample prompt")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    //Wait for the alert to be displayed and store it in a variable
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.accept();
    WebDriverWait w = new WebDriverWait(driver, 2);
    boolean thrown = false;
    try {
      w.until(ExpectedConditions.alertIsPresent());
    } catch (TimeoutException e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);
  }

  @Test
  public void testPromptClickNo() throws IOException {
    String url = "https://www.selenium.dev/documentation/webdriver/browser/alerts/";
    driver.navigate().to(url);
    driver.findElement(By.linkText("See a sample prompt")).click();
    WebDriverWait wait = new WebDriverWait(driver, 4 /*timeout in seconds*/);

    //Wait for the alert to be displayed and store it in a variable
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.dismiss();
    WebDriverWait w = new WebDriverWait(driver, 2);
    boolean thrown = false;
    try {
      w.until(ExpectedConditions.alertIsPresent());
    } catch (TimeoutException e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);
  }

  @After
  public void end(){
    driver.quit();
  }
}
