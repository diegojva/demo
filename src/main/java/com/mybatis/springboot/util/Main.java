package com.mybatis.springboot.util;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Juan", 20));
        usuarios.add(new Usuario("Pedro", 30));
        usuarios.add(new Usuario("Maria", 40));
        usuarios.add(new Usuario("Jose", 50));
        usuarios.add(new Usuario("Luis", 10));
        usuarios.add(new Usuario("Ana", 15));
        usuarios.add(new Usuario("Luisa", 25));
        usuarios.add(new Usuario("Luis", 14));
        usuarios.add(new Usuario("Luis", 16));

        int result = (int) usuarios.stream()
                        .filter(u -> u.getAge() > 18)
                                .filter(u -> u.getUsername().startsWith("L"))
                                        .count();

        System.out.println("Cantidad de usuarios: " + result);
    }
}
