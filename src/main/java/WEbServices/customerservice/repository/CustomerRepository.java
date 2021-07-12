package WEbServices.customerservice.repository;

import WEbServices.customerservice.dto.Customer;
import WEbServices.customerservice.dto.Region;
import WEbServices.customerservice.dto.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getCustomers(){
       return jdbcTemplate.query("SELECT * FROM customer", new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public Customer getCustomer(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id = "+id+";", new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public RespuestaApi createCustomer(Customer customer){
        jdbcTemplate.update("INSERT INTO customer (nombre, apellidos, rfc, correo, id_region) VALUES("
                + "'" + customer.getNombre() + "',"
                + "'" + customer.getApellidos() + "',"
                + "'" + customer.getRfc() + "',"
                + "'" + customer.getCorreo() + "',"
                +  " " + customer.getIdRegion()
                + ");");
        return new RespuestaApi("El cliente ha sido registrado");
    }

    public RespuestaApi updateCustomer(Customer customer, int id){
        jdbcTemplate.update("UPDATE customer SET "
                + "nombre = '" + customer.getNombre() + "',"
                + "apellidos = '" + customer.getApellidos() + "',"
                + "rfc = '" + customer.getRfc() + "',"
                + "correo = '" + customer.getCorreo() + "',"
                + "id_region = " + customer.getIdRegion()
                + " WHERE id = " + id + ";");
        return new RespuestaApi("El cliente ha sido actualizado");
    }

    public RespuestaApi deleteCustomer(int id){
        jdbcTemplate.update("DELETE FROM customer WHERE id = " + id + ";");
        return new RespuestaApi("El cliente ha sido eliminado");
    }
}
