/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto1_Cilo4.Reto1;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author john
 */
public interface UserCrudRepository extends CrudRepository <user, Integer> {
    Optional<user> findByEmail(String email);
    Optional<user> findByEmailAndPassword(String email,String password);
    
}
