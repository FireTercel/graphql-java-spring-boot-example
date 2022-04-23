package com.example.DemoGraphQL.resolver;

import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Grade;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.GradeRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private GradeRepository gradeRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository, GradeRepository gradeRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.gradeRepository = gradeRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public Iterable<Grade> findAllGrades() {
        return gradeRepository.findAll();
    }

    public long countGrades() {
        return gradeRepository.count();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
