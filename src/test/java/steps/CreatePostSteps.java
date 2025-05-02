package steps;

import io.cucumber.java.en.*;
import pages.CreatePostPage;
import static hooks.Hooks.getPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatePostSteps {
    private final CreatePostPage createPost = new CreatePostPage(getPage());

    @And("user selects Buzz module")
    public void userClicksBuzzModule() {
        createPost.clickBuzzModule();
    }

    @When("user populate 'What's on your mind? field with space value")
    public void userFillsEmptyPost() {
        createPost.fillEmptyPost();
    }

    @And("clicks the Post button")
    public void userClicksButton() {
        createPost.clickPostButton();
    }

    @Then("an error message for empty post is displayed")
    public void checkError() {
        String expectedResults = "Invalid Post";
        boolean isVisible = createPost.emptyPostError(expectedResults);
        assertTrue(isVisible);
    }
}
