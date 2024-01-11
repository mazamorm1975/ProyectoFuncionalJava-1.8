package org.example.streams;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//la anotación @ToString(onlyExplicitlyIncluded = true) solo permite visualizar los campos que queremos que
//Se visualicen al momento de la impresión
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    //@EqualsAndHashCode.Include
    @ToString.Include
    private int id;
    //@EqualsAndHashCode.Include
    private String clientName;
    @ToString.Include
    private String job;
    private LocalDate time;
    private double salary;
    private String country;

}
