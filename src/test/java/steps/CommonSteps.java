package steps;

import com.microsoft.playwright.*;
import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.util.Map;
import static hooks.Hooks.getPage;

public class CommonSteps {

    @Given("user is logged into OrangeHRM page with following credentials:")
    public void userLogsIn(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        Page page = getPage();

        page.navigate("https://opensource-demo.orangehrmlive.com/");
        page.fill("input[name='username']", data.get("Username"));
        page.fill("input[name='password']", data.get("Password"));
        page.click("button[type='submit']");
    }

    @And("user selects PIM module")
    public void userSelectsPimModule() {
        Page page = Hooks.getPage();
        page.click("text=PIM");
    }
}