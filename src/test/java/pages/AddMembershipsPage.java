package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddMembershipsPage extends CommonMethods {

    @FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")
    public WebElement Id;

    @FindBy(xpath="//*[@id=\"sidenav\"]/li[11]/a")
    public WebElement membershipsButton;

    @FindBy(xpath = "//*[@id=\"btnAddMembershipDetail\"]")
    public WebElement addMembershipsButton;

    @FindBy(xpath = "//*[@id=\"membership_membership\"]")
    public WebElement membershipDropdown;

    @FindBy(xpath = "//*[@id=\"membership_subscriptionPaidBy\"]")
    public WebElement subscriptionPaidByDropdown;

    @FindBy(xpath = "//*[@id=\"membership_subscriptionAmount\"]")
    public WebElement subscriptionAmountField;

    @FindBy(xpath = "//*[@id=\"membership_currency\"]")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//*[@id=\"frmEmpMembership\"]/fieldset/ol/li[5]/img")
    public WebElement subscriptionCommenceDate;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")
    public WebElement CommenceDateMonth;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")
    public WebElement CommenceDateYear;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td")
    public WebElement CommenceDateDay;

    @FindBy(xpath = "//*[@id=\"frmEmpMembership\"]/fieldset/ol/li[6]/img")
    public WebElement subscriptionRenewalDate;

    @FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")
    public WebElement RenewalDateMonth;

    @FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")
    public WebElement RenewalDateYear;

    @FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td")
    public WebElement RenewalDateDay;

    @FindBy(xpath = "//*[@id=\"btnSaveMembership\"]")
    public WebElement saveButton;



    public AddMembershipsPage(){
        PageFactory.initElements(driver, this);
    }

}
