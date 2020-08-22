/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Contato;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author JulianaMCS
 */
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    void salvar(Contato contato);

    Optional<Contato> buscaPorId(Long id);

    List<Contato> buscarTodos();

    List<Contato>buscarTodosPorIdadeAsc();

    Page<Contato> paginaRresultados();
    
    List<Contato> findByEnderecoCidade(String cidade);
    
}
