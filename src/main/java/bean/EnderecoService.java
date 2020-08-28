/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Contato;
import repository.EnderecoRepository;
import entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;
import repository.ContatoRepository;

/**
 *
 * @author JulianaMCS
 */
@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository; 
    
   @Autowired 
   private ContatoRepository contatoRepoistory;
   
    /**
     *
     * @param endereco
     * @param contato
     */
   @Transactional(readOnly = false)
   public void salvar(Endereco endereco, Contato contato) {
        enderecoRepository.save(endereco);
        contato.setEndereco(endereco); 
        contatoRepoistory.save(contato);
   }
  
   /*
   public void salvar(Endereco endereco) {
      enderecoRepository.save(endereco);
   }
*/
   public List<Endereco> buscarTodos() {
      return enderecoRepository.findAll();
   }

   public Page<Endereco> paginaResultados() {
   Sort sort = new Sort(Direction.ASC, "logradouro");
       Pageable pageable = new PageRequest(0,5,sort);
   return enderecoRepository.findAll(pageable);
   }

}
