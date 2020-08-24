/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Endereco;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author JulianaMCS
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
    void salvar(Endereco endereco);
   
    Optional<Endereco> buscaPorId(Long id) ;

    List<Endereco> buscarTodos() ;

    Page<Endereco> paginaRresultados() ;
    
    @Query("select e.cidade as cidade count(e.cidade) as total"
    + " from Enderece e"
    + " group by e.cidade")
    List<CidadeTotal> findByCidadeTotal();

    
    
}
