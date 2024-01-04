package org.example.streams;

import lombok.*;

import java.time.LocalDate;

@Data
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    //@EqualsAndHashCode.Include
    private int id;
    private String clientName;
    private String job;
    private LocalDate time;
    private double salary;
    private String country;

}
