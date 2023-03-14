package com.jobboard.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "career")
public class Career implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //TODO: Podria tener la lista de estudiantes que asisten a una carrera para que el recruiter pueda solicitarlos
}
