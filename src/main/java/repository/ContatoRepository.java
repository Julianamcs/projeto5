/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Contato;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projection.NomeCidade;
import projection.SemEndereco;


/**
 *
 * @author JulianaMCS
 */
public interface ContatoRepository extends JpaRepository<Contato, Long> {
     
   void saveAll (Contato contato);
   
   Optional<Contato> findByPorId(Long id);
   
   List<Contato> findAll(); 
   
   List<Contato> findByNomeQBE(String nome);

   List<Contato> findAllByIdadeAsc();
   
   Page<Contato> findAllPag();
   
   Contato findByNomeAndIdade(String nome, Integer idade);
   
   List<Contato> findByEnderecoCidade(String cidade);
   
   Contato findTopByOdrerByIdadesAc();
   
   List<Contato> findFirstByOrderByIdadeAsc();
   
   @Query(" select c from Contatos c  where idade >= 18 order by nome asc") 
   List<Contato> findByContatoMaiolrdade();
   
   @Query("select c from Contatos c where c.dtCadastro > ?1")
   List<Contato> findByDtCadastroAfter(Date dataCadastro);

   @Query(value = "select * from Contatos where data_cadastro = ?1", nativeQuery = true)
   List<Contato> findByDataCadastro(Date dataCadastro);
   
   @Query(name = "Contatos.byIdade")
   List<Contato> findByIdade(Integer idade);
   
   @Query(name = "Contatos.byNome") 
   Contato findByNome(String nome);
   
   NomeCidade findContatoCidadeByNome(String nome);
   
    @Query("selcet c from Contatos c "
      + "where idade >= : idade or nome like :nome") 
    List<Contato> findByIdadeOuNome(@Param("idade") Integer idade,
      @Param("nome") String nome);
    
 
}
