/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Endereco;
import java.util.List;
import org.springframework.data.domain.Page;


/**
 *
 * @author JulianaMCS
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
    List<Endereco> buscarTodos() ;

    Page<Endereco> paginaResultados() ;
   
}
