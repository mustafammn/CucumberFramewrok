package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimOption.click();
    }

    @When("user clicks on Add employee button")
    public void user_clicks_on_add_employee_button() {
        WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployeeButton.click();
    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Nammar");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("MS");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added succesfully");
    }

    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {
        WebElement firstNameLoc = driver.findElement(By.id("firstName"));
        firstNameLoc.sendKeys(firstName);
        WebElement lastNameLoc = driver.findElement(By.id("lastName"));
        lastNameLoc.sendKeys(lastName);
        WebElement middleNameLoc = driver.findElement(By.id("middleName"));
        middleNameLoc.sendKeys(middleName);
    }

    @When("user enters direct data {string} {string} and {string}")
    public void user_enters_direct_data_and(String firstName, String middleName, String lastName) {
        WebElement firstNameLoc = driver.findElement(By.id("firstName"));
        firstNameLoc.sendKeys(firstName);
        WebElement lastNameLoc = driver.findElement(By.id("lastName"));
        lastNameLoc.sendKeys(lastName);
        WebElement middleNameLoc = driver.findElement(By.id("middleName"));
        middleNameLoc.sendKeys(middleName);
    }

    @When("user add multiple employees and verify they are added")
    public void user_add_multiple_employees_and_verify_they_are_added(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> emp : employeeNames){
            String firstNameValue = emp.get("firstName");
            String middleNameValue = emp.get("middleName");
            String lastNameValue = emp.get("lastName");

            WebElement firstNameLoc = driver.findElement(By.id("firstName"));
            firstNameLoc.sendKeys(firstNameValue);
            WebElement lastNameLoc = driver.findElement(By.id("lastName"));
            lastNameLoc.sendKeys(lastNameValue);
            WebElement middleNameLoc = driver.findElement(By.id("middleName"));
            middleNameLoc.sendKeys(middleNameValue);

            WebElement saveButton = driver.findElement(By.id("btnSave"));
            saveButton.click();

            //Assertions in Homework
            Thread.sleep(5000);

            //to come back again on add employee screen because hooks and background works just one time
            WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmployeeButton.click();
            Thread.sleep(3000);
        }

    }

    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employee(String sheetName) throws InterruptedException {
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetName);

        Iterator<Map<String, String>> itr = newEmployees.iterator();
        // it check whether we have element or not
        while (itr.hasNext()){
            // it returns the Key and value for employees
            Map<String, String> mapNewEmp = itr.next();

            WebElement firstNameLoc = driver.findElement(By.id("firstName"));
            firstNameLoc.sendKeys(mapNewEmp.get("FirstName"));
            WebElement lastNameLoc = driver.findElement(By.id("lastName"));
            lastNameLoc.sendKeys(mapNewEmp.get("LastName"));
            WebElement middleNameLoc = driver.findElement(By.id("middleName"));
            middleNameLoc.sendKeys(mapNewEmp.get("MiddleName"));

            WebElement photo = driver.findElement(By.id("photofile"));
            photo.sendKeys(mapNewEmp.get("Photograpgh"));

            WebElement checkBox = driver.findElement(By.id("chkLogin"));
            if(!checkBox.isSelected()){
                checkBox.click();
            }

            WebElement username = driver.findElement(By.id("user_name"));
            WebElement password = driver.findElement(By.id("user_password"));
            WebElement confirmPassword = driver.findElement(By.id("re_password"));

            username.sendKeys(mapNewEmp.get("Username"));
            password.sendKeys(mapNewEmp.get("Password"));
            confirmPassword.sendKeys(mapNewEmp.get("Password"));
            WebElement saveButton = driver.findElement(By.id("btnSave"));
            saveButton.click();

            Thread.sleep(5000);

            //Assertions in Homework
            //grab emp id while adding the employee
            //search it in the employee list
            //use for loop to compare the values

            //to come back again on add employee screen because hooks and background works just one time
            WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmployeeButton.click();
            Thread.sleep(3000);

        }


    }

}