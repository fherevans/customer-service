package WEbServices.customerservice.service;

import WEbServices.customerservice.dto.Customer;
import WEbServices.customerservice.dto.RespuestaApi;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer getCustomer(int id);

    public RespuestaApi createCustomer(Customer customer);

    public RespuestaApi updateCustomer(Customer customer, int id);

    public RespuestaApi deleteCustomer(int id);

}
