package org.example.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private int id;
    private String clientName;
    private String job;
    private LocalDate time;
    private double salary;
    private String country;



}
