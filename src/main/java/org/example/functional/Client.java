package org.example.functional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private Integer idCliente;
    private String name;
    private String city;
    private String job;
    private String country;

}
