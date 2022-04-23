package com.example.DemoGraphQL.repository;

import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository  extends JpaRepository<Grade, Long> {
}
