package com.chenk.insertrecord.repo;

import com.chenk.insertrecord.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
