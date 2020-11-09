package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The CRUD Repository connecting Customer to rest of the application.
 */
public interface CustomersRepository
    extends CrudRepository<Customer, Long>
{
    List<Customer> findByCustnameContainingIgnoringCase(String name);
}
