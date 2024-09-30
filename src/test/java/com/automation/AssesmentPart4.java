package com.automation;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AssesmentPart4 extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test login functionality")
    @Epic("Regression Test")
    @Feature("Cart")

    public void addItemToCart() throws InterruptedException {
        openHomePage();
        navigateToLaptopCategory();
        chooseFirstLaptop();
        clickButtonAddToCart();
        clickButtonOk();
        navigateToCartPage();
        validateLaptopAppears();
    }
    public void openHomePage(){
        getDriver().get("https://demoblaze.com/");
    }
    @Step("Navigate to Laptop Category ")
    public void navigateToLaptopCategory() throws InterruptedException {
       boolean visible =  getDriver().findElement(By.cssSelector("[onclick='byCat(\\'notebook\\')']")).isDisplayed();
       if(visible == true){
           getDriver().findElement(By.cssSelector("[onclick='byCat(\\'notebook\\')']")).click();
           Thread.sleep(3000);
       }else{
           System.out.println("The element not found");
       }
    }
    @Step("Choose first laptop")
    public void chooseFirstLaptop() throws InterruptedException {
        boolean visble = getDriver().findElement(By.xpath("//a[.='Sony vaio i5']")).isDisplayed();
        if(visble == true){
            getDriver().findElement(By.xpath("//a[.='Sony vaio i5']")).click();
            Thread.sleep(3000);
        }else {
            System.out.println("The element not found");
        }
    }
    @Step("Click button add to cart  ")
    public void clickButtonAddToCart() throws InterruptedException {
        boolean visible = getDriver().findElement(By.cssSelector(".btn-success")).isDisplayed();
        if (visible == true){
            getDriver().findElement(By.cssSelector(".btn-success")).click();
            Thread.sleep(3000);
        }else {
            System.out.println("The element not found");
        }
    }
    @Step("Click button ok")
    public void clickButtonOk() {
        getDriver().switchTo().alert().accept();
    }
    @Step("Navigate to cart page")
    public void navigateToCartPage() throws InterruptedException {
        boolean visible = getDriver().findElement(By.xpath("//a[.='Cart']")).isDisplayed();
        if (visible == true) {
            getDriver().findElement(By.xpath("//a[.='Cart']")).click();
            Thread.sleep(3000);
        }else {
            System.out.println("The element not found");
        }
    }
    @Step("Validate Laptop Sony vaio i5 Appears")
    public String validateLaptopAppears(){
        String product =getDriver().findElement(By.cssSelector("#tbodyid > tr:nth-of-type(1) > td:nth-of-type(2)")).getText();
        assertTrue(getDriver().findElement(By.cssSelector("#tbodyid > tr:nth-of-type(1) > td:nth-of-type(2)")).isDisplayed());
        return product;
    }
}
