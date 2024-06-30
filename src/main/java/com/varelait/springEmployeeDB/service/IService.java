package com.varelait.springEmployeeDB.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IService<T, D, I> {
    Optional<T> update(I id, D element);
    Page<T> list(Pageable pageable);
    Optional<T> get(I id);
    Optional<T> delete(I id);
}
