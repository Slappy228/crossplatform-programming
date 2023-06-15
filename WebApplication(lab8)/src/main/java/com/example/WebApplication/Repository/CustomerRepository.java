package com.example.WebApplication.Repository;

import com.example.WebApplication.Entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface CustomerRepository extends Repository<Customer, Integer> {


    void save(Customer Customer);

    @Query("SELECT customer FROM Customer customer WHERE customer.id =:id")
    Customer findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "INSERT INTO Customers (id, first_name, last_name, address, city, telephone) VALUES (default, :firstName, :lastName, :address, :city, :telephone)", nativeQuery = true)
    @Transactional
    void insertUser(@Param("firstName") String firstName,
                    @Param("lastName") String lastName,
                    @Param("address") String address,
                    @Param("city") String city,
                    @Param("telephone") String telephone);


    @Query("UPDATE Customer customer set customer.firstName=:firstName, customer.lastName=:lastName, customer.address=:address, customer.city=:city, customer.telephone=:telephone WHERE customer.id =:id")
    void updateById(@Param("id") Integer id,
                    @Param("firstName") String firstName,
                    @Param("lastName") String lastName,
                    @Param("address") String address,
                    @Param("city") String city,
                    @Param("telephone") String telephone);
    @Query("DELETE FROM Customer customer WHERE customer.id=:id")
    void delById(@Param("id") Integer id);

}
