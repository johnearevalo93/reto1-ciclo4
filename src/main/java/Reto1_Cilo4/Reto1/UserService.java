/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto1_Cilo4.Reto1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author john
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<user> getAll() {
        return userRepository.getAll();
    }

    public Optional<user> getUser(int id) {
        return userRepository.getUser(id);
    }

    public user registrar(user user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public user autenticarUsuario(String email, String password) {
        Optional<user> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new user(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
