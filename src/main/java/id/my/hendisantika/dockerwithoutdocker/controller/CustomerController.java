package id.my.hendisantika.dockerwithoutdocker.controller;

import id.my.hendisantika.dockerwithoutdocker.mock.MockData;
import id.my.hendisantika.dockerwithoutdocker.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-docker-without-docker
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/03/25
 * Time: 07.41
 * To change this template use File | Settings | File Templates.
 */
// testing
@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {
    @GetMapping
    public List<Customer> getAllCustomers() throws Exception {
        List<Customer> customerList = MockData.getCustomers();
        return customerList;
    }

    @GetMapping("/male")
    public List<Customer> getMaleCustomers() throws Exception {
        List<Customer> customerList = MockData.getCustomers();
        Predicate<Customer> customerPredicate = customer -> customer.getGender().equals("Male");

        return customerList.stream()
                .filter(customerPredicate)
                .collect(Collectors.toList());
    }
}
