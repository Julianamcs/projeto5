/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.Date;
import org.springframework.data.repository.Repository;

/**
 *
 * @author JulianaMCS
 */
public interface SemEndereco {
    
   String getNome();  
   Integer getldade();
   Date getotCadastro();

    
}
