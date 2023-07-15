package com.Ankit.Student_model_with_mappings.repository;

import com.Ankit.Student_model_with_mappings.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book,Long> {
}
