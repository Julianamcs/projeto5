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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import projection.CidadeTotal;
import projection.NomeCidade;
import projection.SemEndereco;


/**
 *
 * @author JulianaMCS
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
    List<Endereco> buscarTodos() ;

    Page<Endereco> paginaResultados() ;
    
    SemEndereco findContatoByNome(String nome);
   
    NomeCidade findContatoCidadeByNome(String nome);
    
    @Query("select e.cidade as cidade count(e.cidade) as total"
   + " from Enderecos e"
   + " group by e.cidade")
   List<CidadeTotal> findByCidadeTotal();
   
    /**
     *
     * @param id
     * @return
     */
    @Procedure("proc_endereco")
    String procedureEndereco(Long id);
    
    @Procedure
    String proc_endereco(long id);
    
   @Modifying
   @Query("update Enderecos e set e.cidade = ?1 where e.id = ?2")
   int updateCidadeByld(String cidade, Long id);
   
    /**
     *
     * @param id
     * @return
     */
   @Modifying 
   @Query("delete from Enderecos e where e.id =  ?1")
   int deleteEndereco(Long id);
   
 
   
   

   
}
