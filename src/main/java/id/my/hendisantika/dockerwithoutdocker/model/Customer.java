package id.my.hendisantika.dockerwithoutdocker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-docker-without-docker
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/03/25
 * Time: 07.37
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class Customer {
    private Long id;
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String dob;
}
