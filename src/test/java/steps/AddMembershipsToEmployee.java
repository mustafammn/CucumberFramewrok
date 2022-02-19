package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;

import java.util.List;

public class AddMembershipsToEmployee extends CommonMethods {

    @When("user clicks on Employee list button")
    public void user_clicks_on_employee_list_button() {
       click(dash.employeeListButton);
    }

    @When("user clicks on any employee")
    public void user_clicks_on_any_employee() {
       click(addMembershipsPage.Id);
    }

    @Then("Personal Details page displayed")
    public void personal_details_page_displayed() {
        System.out.println("Personal Details page displayed");
    }

    @When("user clicks on memberships button")
    public void user_clicks_on_memberships_button() {
       click(addMembershipsPage.membershipsButton);
    }

    @When("user clicks on Add Membership button")
    public void user_clicks_on_add_membership_button() {
        click(addMembershipsPage.addMembershipsButton);
    }

    @Then("Add Membership page is displayed")
    public void add_membership_page_is_displayed() {
        System.out.println("Add Membership page is displayed");
    }

    @When("user clicks on Membership dropdown")
    public void user_clicks_on_membership_dropdown() {
        click(addMembershipsPage.membershipDropdown);
    }

    @Then("dropdown is displayed and user select values from the dropdown")
    public void dropdown_is_displayed_and_user_select_values_from_the_dropdown() {
        selectDropdown(addMembershipsPage.membershipDropdown, "Gym");
    }

    @When("user clicks on Subscription Paid By dropdown")
    public void user_clicks_on_subscription_paid_by_dropdown() {
        click(addMembershipsPage.subscriptionPaidByDropdown);
    }

    @Then("dropdown is displayed and user can select values from the dropdown")
    public void dropdown_is_displayed_and_user_can_select_values_from_the_dropdown() {
        selectDropdown(addMembershipsPage.subscriptionPaidByDropdown, "Company");
    }

    @When("user clicks on Subscription Amount text box")
    public void user_clicks_on_subscription_amount_text_box() {
        click(addMembershipsPage.subscriptionAmountField);
        addMembershipsPage.subscriptionAmountField.clear();

    }

    @Then("text box is displayed and user can enter the amount there")
    public void text_box_is_displayed_and_user_can_enter_the_amount_there() {
        sendText(addMembershipsPage.subscriptionAmountField, "10");
    }

    @When("user clicks on Currency dropdown")
    public void user_clicks_on_currency_dropdown() {
        click(addMembershipsPage.currencyDropdown);
    }

    @Then("dropdown is displayed and user selected values from the dropdown")
    public void dropdown_is_displayed_and_user_selected_values_from_the_dropdown() {
        selectDropdown(addMembershipsPage.currencyDropdown, "United States Dollar");
    }

    @When("user clicks on Subscription Commence Date field")
    public void user_clicks_on_subscription_commence_date_field() {
        click(addMembershipsPage.subscriptionCommenceDate);
    }

    @Then("field is displayed and user can select date from there")
    public void field_is_displayed_and_user_can_select_date_from_there() {
        selectDropdown(addMembershipsPage.CommenceDateMonth, "Mar");
        selectDropdown(addMembershipsPage.CommenceDateYear, "2023");

        List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));
        for (WebElement date:dates){

            String dateText = date.getText();
            if(dateText.equalsIgnoreCase("3")){
                date.click();
            }
        }
    }

    @When("user clicks on Subscription Renewal Date")
    public void user_clicks_on_subscription_renewal_date() {
        click(addMembershipsPage.subscriptionRenewalDate);
    }

    @Then("calendar is displayed and user can pick date from there")
    public void calendar_is_displayed_and_user_can_pick_date_from_there() {
        selectDropdown(addMembershipsPage.RenewalDateMonth, "Jun");
        selectDropdown(addMembershipsPage.RenewalDateYear, "2025");
        List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));
        for (WebElement date:dates){

            String dateText = date.getText();
            if(dateText.equalsIgnoreCase("4")){
                date.click();
            }
        }
    }

    @When("user clicks on save button after all step")
    public void user_clicks_on_save_button_after_all_step() {
        click(addMembershipsPage.saveButton);
    }

    @Then("the membership added to the employee")
    public void the_membership_added_to_the_employee() {
        System.out.println("Test is passed, the membership added to the employee");
    }

}
