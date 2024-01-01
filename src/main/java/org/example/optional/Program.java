package org.example.optional;

import org.example.functional.Client;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Program {

    private void m1Optional(){
        Optional<Client> op = Optional.of(new Client(1,"Mario","CDMX","Programmer", "Mexico"));
        //Optional<Client> op = Optional.empty();

        /*El Optional no quiere decir que NUNCA se obtenga la excepción de los null pointer exception
        * Solo mitiga la posibilidad de no conseguirlos */

        /*Con un optional de tipo Optional.of(null), se obtendra el nullpointer exception*/
        //Optional<Client> op = Optional.of(null);

        /*Con un optional de tipo Optional.ofNullable(null), se obtendra una instancia con valores nulos
        , pero NO se obtendra el nullpointer exception*/
        //Optional<Client> op = Optional.ofNullable(null);


        //System.out.println(op.orElseGet(Client::new));
        //System.out.println(op.isPresent());
        op.ifPresent(obj -> System.out.println(obj.getCity()));
    }

    public static void main(String[] args){
        Program m1 = new Program();
        m1.m1Optional();

    }
}
