/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.ra2aeesingletonycarga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private static UsuarioManager instance;
    private List<Usuario> usuarios;
    private static final String URL = "jdbc:mysql://localhost:3306/ra2_aee_singletonycarga";  // Cambia la URL si es necesario
    private static final String USER = "root";  // Cambia estos valores según tu configuración
    private static final String PASSWORD = "";  // Cambia la contraseña

    // Constructor privado para implementar Singleton
    private UsuarioManager() {
        usuarios = new ArrayList<>();  // Aseguramos que la lista esté inicializada
    }

    // Método que devuelve la única instancia de la clase (Singleton)
    public static UsuarioManager getInstance() {
        if (instance == null) {
            synchronized (UsuarioManager.class) {
                if (instance == null) {
                    instance = new UsuarioManager();
                    instance.cargarUsuarios();  // Cargar los usuarios cuando se accede por primera vez
                }
            }
        }
        return instance;
    }

    // Método privado para cargar los usuarios desde la base de datos
    private void cargarUsuarios() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                usuarios.add(new Usuario(id, nombre, email));  // Añadir usuario a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para acceder a la lista de usuarios cargados
    public List<Usuario> getUsuarios() {
        return usuarios;  // Aseguramos que devuelva la lista de usuarios
    }
}
