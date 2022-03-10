package com.company;

import com.company.domain.Bill;
import com.company.domain.Category;
import com.company.domain.Person;
import com.company.domain.Purchase;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person(
                1L,
                "Fernando Vieira",
                "21 12345678",
                "fernando@email.com"
        );

        Person p2 = new Person(
                2L,
                "Gbariel Henrique",
                "21 87654321",
                "gabriel@email.com"
        );


        Category c1 = new Category(
                1L,
                "Lazer"
        );

        Category c2 = new Category(
                2L,
                "Transporte"
        );

        Purchase purchase1 = new Purchase(
                1L,
                LocalDate.of(2022, 2,2),
                27.90,
                "99app",
                1,
                false,
                c2
        );
        c2.getPurchaseSet().add(purchase1);
        purchase1.getPersonSet().add(p1);
        p1.getPurchaseSet().add(purchase1);

        Purchase purchase2 = new Purchase(
                2L,
                LocalDate.of(2022, 2,3),
                10.88,
                "Ingresso Cinema",
                1,
                false,
                c1
        );
        c1.getPurchaseSet().add(purchase2);
        purchase2.getPersonSet().add(p2);
        p2.getPurchaseSet().add(purchase2);

        Bill b1 = new Bill(
                1L,
                LocalDate.of(2022, 3,1)
        );
        b1.setPerson(p1);
        p1.getBillSet().add(b1);
        b1.getPurchaseSet().add(purchase1);
        purchase1.getBillSet().add(b1);

        Bill b2 = new Bill(
                2L,
                LocalDate.of(2022, 3,1)
        );
        b2.setPerson(p2);
        p2.getBillSet().add(b2);
        b2.getPurchaseSet().add(purchase2);
        purchase2.getBillSet().add(b2);

        System.out.println(p1);
        p1.printBills();
        System.out.println();
        System.out.println(p2);
        p2.printBills();
        System.out.println();

        System.out.println(b1);
        System.out.println(b2);
        System.out.println();

        System.out.println(purchase1);
        System.out.println(purchase2);
        System.out.println();

        System.out.println(c1);
        System.out.println(c2);

    }
}
