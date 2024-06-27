package com.varelait.springEmployeeDB.persistence;

import com.varelait.springEmployeeDB.service.entities.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    Page<Payment> findByEmployeeId(int id, Pageable pageable);
    Page<Payment> findByDateContaining(Date date, Pageable pageable);
}
