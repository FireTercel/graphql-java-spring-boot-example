package com.example.DemoGraphQL.model;

import lombok.*;

import javax.persistence.*;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Grade {
    @Id
    @Column(name="grade_id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="grade_name", nullable = false)
    private String name;
    @Column(name="grade_code", nullable = false)
    private String code;
    @Column(name="grade_level", nullable = false)
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "author_id",
            nullable = false, updatable = false)
    private Author author;
}
