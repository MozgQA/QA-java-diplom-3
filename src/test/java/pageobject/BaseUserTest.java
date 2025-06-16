package pageobject;

import client.UserClient;
import generator.UserGenerator;
import model.User;
import model.UserCredentials;
import org.junit.After;
import org.junit.Before;


public class BaseUserTest extends BaseTest {

    protected UserClient userClient;
    protected User user;
    protected String accessToken;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        user = UserGenerator.getRandom();
        userClient = new UserClient();
        userClient.create(user);
        accessToken = userClient.login(UserCredentials.from(user))
                .extract().path("accessToken");
    }

    @Override
    @After
    public void tearDown() {
        super.tearDown();
        if (accessToken != null) {
            userClient.delete(accessToken, UserCredentials.from(user));
        }
    }

}
