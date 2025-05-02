package steps;

import io.cucumber.java.en.*;
import pages.AddEmployeePage;
import java.util.Map;
import static hooks.Hooks.getPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddEmployeeSteps {
    private final AddEmployeePage addEmployeePage = new AddEmployeePage(getPage());

    @And("user clicks the + Add button")
    public void userClicksAddButton() {
        addEmployeePage.clickAddButton();
    }

    @When("user populate Add Employee form with following details:")
    public void userFillsEmployeeForm(Map<String, String> data) {
        addEmployeePage.fillEmployeeForm(data.get("First Name"), data.get("Last Name"), data.get("Employee Id"));
    }

    @And("clicks Save button")
    public void userClicksSave() {
        addEmployeePage.clickSave();
    }

    @Then("an error message for invalid name and employee ID formats is displayed")
    public void checkError() {
        String expectedResults = "Invalid name and employee ID format";
        boolean isVisible = addEmployeePage.errorIsDisplayed(expectedResults);
        assertTrue(isVisible);
    }
}