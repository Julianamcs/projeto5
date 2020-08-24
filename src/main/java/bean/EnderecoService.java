/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import repository.EnderecoRepository;
import entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository repository; 
    
  
   public void salvar(Endereco endereco) {
      repository.save(endereco);
   }

   public Optional<Endereco> buscaPorId(Long id) {
      return repository.findById(id);
   }

   public List<Endereco> buscarTodos() {
      return repository.findAll();
   }

   public Page<Endereco> paginaRresultados() {
   Sort sort = new Sort(Direction.ASC, "logradouro");
       Pageable pageable = new PageRequest(0,5,sort);
   return repository.findAll(pageable);
   }

}
