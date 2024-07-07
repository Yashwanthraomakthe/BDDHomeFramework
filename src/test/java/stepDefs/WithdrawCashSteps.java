package stepDefs;

import org.testng.Assert;

import atm.ATM;
import atm.Account;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class WithdrawCashSteps {
    private Account account;
    private ATM atm;
    private double dispensedAmount;

    @Given("I have a balance of $100 in my account")
    public void i_have_a_balance_of_in_my_account() {
        account = new Account(100);
        atm = new ATM(account);
    }

    @When("I request $20")
    public void i_request() {
        atm.withdraw(20);
        dispensedAmount = 20;
    }

    @Then("$20 should be dispensed")
    public void should_be_dispensed() {
        Assert.assertEquals(80, account.getBalance());
        Assert.assertEquals(20, dispensedAmount);
    }
}