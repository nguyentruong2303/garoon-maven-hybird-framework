package utilities;

import net.datafaker.Faker;

import java.util.Locale;

public class DataFakerConfig {
    Faker fake = new Faker(new Locale("en-US"));

    public static DataFakerConfig getFakerConfig() {
        return new DataFakerConfig();
    }

    public String getFirstName() {
        return fake.name().firstName();
    }

    public String getLastName() {
        return fake.name().lastName();
    }
    public String getEmail() {
        return fake.internet().emailAddress();
    }

    public String getPassword() {
        return fake.internet().password();
    }

    public String getSubjectAppointment() {
        return  "Appointment" + fake.lorem().sentence(3);
    }

    public String getNote() {
        return  "Note" + fake.lorem().sentence(3);
    }

}
