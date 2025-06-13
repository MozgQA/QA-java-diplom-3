package generator;

import com.github.javafaker.Faker;
import model.User;

import java.util.Locale;

public class UserGenerator {

    public static User getRandom() {
        Faker faker = new Faker(Locale.forLanguageTag("ru"));
        return new User(faker.internet().emailAddress(),
                faker.internet().password(),
                faker.name().firstName());
    }
}