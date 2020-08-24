
import org.springframework.beans.factory.annotation.Value;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author JulianaMCS
 */
public interface NomeCidade {
    
   String getNome();
   @Value("#{(target.endereco.cidade)}") 
   String getCidade();

    
}
