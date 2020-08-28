/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projection;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JulianaMCS
 */
public interface CidadeTotal {
    
    String getCidade();
   Long getTotal();
    
}
