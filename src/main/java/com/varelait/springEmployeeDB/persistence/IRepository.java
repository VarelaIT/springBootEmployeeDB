package com.varelait.springEmployeeDB.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository<T, I> extends JpaRepository<T, I> {
}
