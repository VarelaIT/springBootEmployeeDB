package com.varelait.springEmployeeDB.service;

import com.varelait.springEmployeeDB.LoggerBase;
import com.varelait.springEmployeeDB.persistence.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public class Service<T, D, I> extends LoggerBase implements IService<T, D, I>{
    public IRepository<T, I> repository;

    @Override
    public Optional<T> update(I id, D element) {
        T result = null;
        Optional<T> storedElement = repository.findById(id);
        if (storedElement.isPresent()){
            result = repository.save(storedElement.get());
        }
        return Optional.ofNullable(result);
    }

    @Override
    public Page<T> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<T> get(I id) {
        return repository.findById(id);
    }

    @Override
    public Optional<T> delete(I id) {
        var element = repository.findById(id);
        if (element.isPresent())
            repository.deleteById(id);
        return element;
    }
}
