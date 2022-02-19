package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EmployeeListPage;
import utils.CommonMethods;

public class EmployeeLicensesSteps extends CommonMethods {

    @When("user clicks on Qualification button")
    public void user_clicks_on_qualification_button() throws InterruptedException {
        Thread.sleep(5000);
        click(employeeListPage.qualificationButton);
    }


    @Then("Qualification page is displayed")
    public void qualification_page_is_displayed() {
        System.out.println("Qualification page is displayed");
    }
}
