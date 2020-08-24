/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import repository.ContatoRepository;
import entity.Contato;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;



/**
 *
 * @author JulianaMCS
 */
@Service
public class ContatoService {
    
   @Autowired
   private ContatoRepository repository;

   public void salvar(Contato contato) {
      repository.save(contato);
   }

   public Optional<Contato> buscaPorId(Long id) {
      return repository.findById(id);
   }

   public List<Contato> buscarTodos() {
      return repository.findAll();
   }

   public List<Contato>buscarTodosPorIdadeAsc(){
      Sort sort = new Sort(Direction.ASC, "idade");
      return repository.findAll(sort);
   }

   public Page<Contato> paginaRresultados() {
   Sort sort = new Sort(Direction.ASC, "nome");
       Pageable pageable = new PageRequest(0,8,sort);
   return repository.findAll(pageable);
   }
   
   
}
