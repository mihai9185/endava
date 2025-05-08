package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.TerminateEmploymentPage;
import java.util.Map;
import static hooks.Hooks.getPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TerminateEmploymentSteps {
    private final TerminateEmploymentPage terminateEmployee = new TerminateEmploymentPage(getPage());

    @And("user clicks the edit icon next to first employee that appear")
    public void userClicksEditIcon() {
        terminateEmployee.clickEditIcon();
    }

    @And("user navigates to the Job tab in the employee profile")
    public void userSelectsJobTab() {
        terminateEmployee.selectJobTab();
    }

    @When("user clicks on the {string} button")
    public void userClicksTerminateEmployeeButton(String buttonName) {
        terminateEmployee.clicksButton(buttonName);
    }

    @And("selects the following termination details:")
    public void userFillsTerminationForm(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        String date = data.get("Termination Date");
        String reason = data.get("Termination Reason");
        terminateEmployee.fillTerminationForm(date, reason);
    }

    @And("clicks the {string} button")
    public void userClicksSaveButton(String buttonName) {
        terminateEmployee.clicksButton(buttonName);
    }

    @Then("a confirmation message is displayed, informing the user that the termination is permanent and cannot be undone")
    public void messageDisplayed() {
        String expectedResults = "Invalid Post";
        boolean isVisible = terminateEmployee.informMessage(expectedResults);
        assertTrue(isVisible);
    }
}