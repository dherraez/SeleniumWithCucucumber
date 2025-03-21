package steps;

import Base.BaseUtil;
import com.aventstack.extentreports.GherkinKeyword;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;

/**
 * Created by Karthik on 21/09/2019.
 */
public class LoginStep extends BaseUtil{

    private  BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        scenarioDef.createNode(new GherkinKeyword("Then"), "I should see the userform page");

        Assert.assertEquals("Its not displayed", base.Driver.findElement(By.id("Initial")).isDisplayed(), true);
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {


        scenarioDef.createNode(new GherkinKeyword("Given"), "I navigate to the login page");
        System.out.println("Navigate Login Page");
        base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }


    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        scenarioDef.createNode(new GherkinKeyword("And"), "I click login button");
        LoginPage page = new LoginPage(base.Driver);
        page.ClickLogin();
    }


    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        scenarioDef.createNode(new GherkinKeyword("And"), "I entere the following for login");
        //Create an ArrayList
        //ArrayList<User> users =  new ArrayList<User>();
        //Store all the users
        //var users = table.asList(String.class);

        LoginPage page = new LoginPage(base.Driver);

//        for (User user: users){
//            page.Login(user.username, user.password);
//        }

        //page.Login(users.get(2).toString(), users.get(3).toString());
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) throws Throwable {
        scenarioDef.createNode(new GherkinKeyword("And"), "I enter username and password");
        System.out.println("UserName is : " + userName);
        System.out.println("Password is : " + password);
    }

    @Then("^I should see the userform page wrongly$")
    public void iShouldSeeTheUserformPageWrongly() throws Throwable {
        scenarioDef.createNode(new GherkinKeyword("Then"), "I should see  the useform page wrongly");
        //Assert.assertEquals("Its not displayed", base.Driver.findElement(By.id("sdfgdsfsd")).isDisplayed(), true);
    }


    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username= userName;
            password = passWord;
        }
    }

}
