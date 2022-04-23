package com.example.DemoGraphQL.resolver;

import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Grade;
import com.example.DemoGraphQL.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;

public class GradeResolver  implements GraphQLResolver<Grade> {

    private AuthorRepository authorRepository;

    public GradeResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor()
                        .getId())
                .orElseThrow(null);
    }
}
