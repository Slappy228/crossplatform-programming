package com.example.WebApplication.Repository;

import com.example.WebApplication.Entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends Repository<Order, Integer> {

    void save(Order order);

    @Query("SELECT order FROM Order order WHERE order.id =:id")
    Order findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "insert into Orders (id, customer_id, address, city, telephone) VALUES (default, :customerId, :address, :city, :telephone)", nativeQuery = true)
    @Transactional
    void insertUser(@Param("customerId") Integer userId,
                    @Param("address") String address,
                    @Param("city") String city,
                    @Param("telephone") String telephone);

    @Query("UPDATE Order order set order.customerId=:customerId, order.address=:address, order.city=:city, order.telephone=:telephone WHERE order.id =:id")
    void updateById(@Param("id") Integer id,
                   @Param("customerId") Integer customerId,
                   @Param("address") String address,
                   @Param("city") String city,
                   @Param("telephone") String telephone);
    @Query("DELETE FROM Order order WHERE order.id=:id")
    void delById(@Param("id") Integer id);

}
