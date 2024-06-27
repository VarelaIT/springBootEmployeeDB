package com.varelait.springEmployeeDB.service.payment;

import com.varelait.springEmployeeDB.persistence.IPaymentRepository;
import com.varelait.springEmployeeDB.service.employee.EmployeeService;
import com.varelait.springEmployeeDB.service.employee.IEmployeeService;
import com.varelait.springEmployeeDB.service.entities.Employee;
import com.varelait.springEmployeeDB.service.entities.Payment;
import com.varelait.springEmployeeDB.service.entities.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.text.ParseException;
import java.util.Optional;

public class PaymentService implements IPaymentService{
    private final IPaymentRepository paymentRepository;
    private final IEmployeeService employeeService;
    @Autowired
    public PaymentService(IPaymentRepository paymentRepository, EmployeeService employeeService){
        this.paymentRepository = paymentRepository;
        this.employeeService = employeeService;
    }

    @Override
    public Payment create(PaymentDTO paymentDTO) {
        Employee employee = null;
        if (paymentDTO != null && paymentDTO.employeeId > 0){
            employee = employeeService.getOne(paymentDTO.employeeId);
            Payment payment = new Payment(
                    paymentDTO.date,
                    paymentDTO.salary,
                    paymentDTO.amount,
                    employee
            );
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public Payment update(Long id, PaymentDTO paymentDTO) {
        Optional<Payment> persistedPayment = paymentRepository.findById(id);
        if (persistedPayment.isPresent()) {
            Payment payment = persistedPayment.get();
            payment.setDate(paymentDTO.date);
            payment.setSalary(paymentDTO.salary);
            payment.setAmount(paymentDTO.amount);
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public Payment delete(Long id) {
        Optional<Payment> persistedPayment = paymentRepository.findById(id);
        if (persistedPayment.isPresent()){
            paymentRepository.deleteById(id);
            return persistedPayment.get();
        }
        return null;
    }

    @Override
    public Payment getOne(Long id) {
        Optional<Payment> persistedPayment = paymentRepository.findById(id);
        return persistedPayment.orElse(null);
    }

    @Override
    public Page<Payment> get(Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }

    @Override
    public Page<Payment> get(Pageable pageable, int employeeId) {
        return paymentRepository.findByEmployeeId(employeeId, pageable);
    }

    @Override
    public Page<Payment> get(Pageable pageable, String dateString) throws ParseException {
        Date date = new Date(PaymentDTO.formatter.parse(dateString).getTime());
        return paymentRepository.findByDateContaining(date, pageable);
    }
}
