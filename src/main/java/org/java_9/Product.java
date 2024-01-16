package org.java_9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements ProductService{

    private int id;
    private String name;
    private boolean status;

}
