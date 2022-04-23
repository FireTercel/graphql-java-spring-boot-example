package com.example.DemoGraphQL.resolver;

import com.example.DemoGraphQL.exception.BookNotFoundException;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Grade;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.GradeRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private GradeRepository gradeRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, GradeRepository gradeRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.gradeRepository =gradeRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Optional<Book> opt = bookRepository.findById(id);
        if (opt.isPresent()) {
            Book book = opt.get();
            book.setPageCount(pageCount);
            bookRepository.save(book);
            return book;
        }
        throw new BookNotFoundException("The book to be updated was found", id);
    }

    public Grade newGrade(String code, String name, Integer level, Long authorId) {
        Grade grade = new Grade();
        grade.setAuthor(new Author(authorId));
        grade.setCode(code);
        grade.setName(name);
        grade.setLevel(level != null ? level : 0);

        gradeRepository.save(grade);

        return grade;
    }

    public boolean deleteGrade(Long id) {
        gradeRepository.deleteById(id);
        return true;
    }

    public Grade updateGradeLevel(Integer level, Long id) {
        Optional<Grade> opt = gradeRepository.findById(id);
        if (opt.isPresent()) {
            Grade grade = opt.get();
            grade.setLevel(level);
            gradeRepository.save(grade);
            return grade;
        }
        throw new BookNotFoundException("The grade to be updated was found", id);
    }
}
