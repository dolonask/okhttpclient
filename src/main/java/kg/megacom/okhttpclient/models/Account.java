package kg.megacom.okhttpclient.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    Long id;
    String login;
    String password;
    boolean active;

}
