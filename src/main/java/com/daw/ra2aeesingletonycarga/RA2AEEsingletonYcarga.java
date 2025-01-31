/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.daw.ra2aeesingletonycarga;

/**
 *
 * @author DAW2
 */
public class RA2AEEsingletonYcarga {

    public static void main(String[] args) {
        // Primer acceso a UsuarioManager (carga los datos)
        System.out.println("Primer acceso:");
        UsuarioManager usuarioManager1 = UsuarioManager.getInstance();
        usuarioManager1.getUsuarios().forEach(System.out::println);

        // Segundo acceso a UsuarioManager (no debería cargar los datos nuevamente)
        System.out.println("\nSegundo acceso:");
        UsuarioManager usuarioManager2 = UsuarioManager.getInstance();
        usuarioManager2.getUsuarios().forEach(System.out::println);
    }
}
