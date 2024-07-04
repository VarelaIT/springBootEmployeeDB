package com.varelait.springEmployeeDB.service.payment;

import com.varelait.springEmployeeDB.service.entities.Payment;
import com.varelait.springEmployeeDB.service.entities.PaymentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

public interface IPaymentService {
    Payment create(PaymentDTO paymentDTO);
    Payment update(Long id, PaymentDTO paymentDTO);
    Payment delete(Long id);
    Payment getOne(Long id);
    Page<Payment> get(Pageable pageable);
    Page<Payment> get(Pageable pageable, int employeeId);
    Page<Payment> get(Pageable pageable, String date);
}
