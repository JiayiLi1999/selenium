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

package com.thoughtworks.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WebsiteCookieTest extends InternalSelenseTestBase {
  @Test
  public void testAddCookie() {
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com");
    driver.manage().addCookie(new Cookie("key", "value"));
    Cookie cookie1 = driver.manage().getCookieNamed("key");
    Assert.assertEquals("get correct cookie", cookie1.getValue(), "value");
  }

  @Test
  public void testGetAllCookie() {
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com");
    driver.manage().addCookie(new Cookie("key1", "value1"));
    driver.manage().addCookie(new Cookie("key2", "value2"));
    Set<Cookie> cookies = driver.manage().getCookies();
    Assert.assertEquals("get correct cookie size", cookies.size(), 2);
  }

  @Test
  public void testDeleteCookie() {
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com");
    driver.manage().addCookie(new Cookie("key", "value"));
    driver.manage().deleteCookieNamed("key");
    Assert.assertNull("cookie deleted",driver.manage().getCookieNamed("key"));
  }

  @Test
  public void testDeleteAllCookie() {
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com");
    driver.manage().addCookie(new Cookie("test1", "cookie1"));
    driver.manage().addCookie(new Cookie("test2", "cookie2"));
    // deletes all cookies
    driver.manage().deleteAllCookies();
    Assert.assertNull("cookie deleted 1",driver.manage().getCookieNamed("test1"));
    Assert.assertNull("cookie deleted 2",driver.manage().getCookieNamed("test2"));
  }

}
