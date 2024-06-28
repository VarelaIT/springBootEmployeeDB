package com.varelait.springEmployeeDB.presentation.payment;

import com.varelait.springEmployeeDB.presentation.StatusEval;
import com.varelait.springEmployeeDB.service.entities.Payment;
import com.varelait.springEmployeeDB.service.entities.PaymentDTO;
import com.varelait.springEmployeeDB.service.payment.IPaymentService;
import com.varelait.springEmployeeDB.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/payment")
public class PaymentEndpoint {
    IPaymentService paymentService;
    @Autowired
    public PaymentEndpoint(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO){
        Payment payment = paymentService.update(id, paymentDTO);
        HttpStatus status = StatusEval.object(payment);
        return new ResponseEntity<>(payment, status);
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody PaymentDTO paymentDTO){
        Payment payment = paymentService.create(paymentDTO);
        HttpStatus status = StatusEval.object(payment);
        return new ResponseEntity<>(payment, status);
    }

    @GetMapping
    public ResponseEntity<Page<Payment>> getPayment(Pageable pageRequest){
        Page<Payment> payments = paymentService.get(pageRequest);
        HttpStatus status = StatusEval.object(payments);
        return new ResponseEntity<>(payments, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id){
        Payment payment = paymentService.getOne(id);
        HttpStatus status = StatusEval.object(payment);
        return new ResponseEntity<>(payment, status);
    }

    @GetMapping("/by-employee/{id}")
    public ResponseEntity<Page<Payment>> getPaymentByEmployee(@PathVariable int id, Pageable pageRequest){
        Page<Payment> payments = paymentService.get(pageRequest, id);
        HttpStatus status = StatusEval.object(payments);
        return new ResponseEntity<>(payments, status);
    }

    @GetMapping("/by-date/{date}")
    public ResponseEntity<Page<Payment>> getPaymentByDate(@PathVariable String date, Pageable pageRequest){
        Page<Payment> payments = paymentService.get(pageRequest, date);
        HttpStatus status = StatusEval.object(payments);
        return new ResponseEntity<>(payments, status);
    }

}
