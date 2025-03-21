package id.my.hendisantika.dockerwithoutdocker.mock;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import id.my.hendisantika.dockerwithoutdocker.model.Customer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-docker-without-docker
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/03/25
 * Time: 07.40
 * To change this template use File | Settings | File Templates.
 */
public class MockData {
    public static ImmutableList<Customer> getCustomers() throws IOException {
        InputStream inputStream = Resources.getResource("customers.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Customer>>() {
        }.getType();
        List<Customer> people = new Gson().fromJson(json, listType);
        return ImmutableList.copyOf(people);
    }
}
