/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import repository.ContatoRepository;
import entity.Contato;
import entity.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import repository.EnderecoRepository;


/**
 *
 * @author JulianaMCS
 */
@Service
public class ContatoService {
    
   @Autowired
   private ContatoRepository repository;
   
   @Autowired
   private EnderecoRepository enderecoRepository; 
   
  /*
   @Transactional(readOnly = false)
   public void salvar(Endereco endereco, Contato contato) {
        enderecoRepository.save(endereco);
        contato.setEndereco(endereco); 
        repository.save(contato);
   }
   */
   public void saveAll(Contato contato) {
      repository.save(contato);
   }

   public Optional<Contato> findByPorId(Long id) {
      return repository.findById(id);
   }

   public List<Contato> findAll() {
      return repository.findAll();
   }
   
    public List<Contato> findByIdadeQBE(Integer idade){
      Contato contato = new Contato(); 
      contato.setIdade(idade);
       Example<Contato> example = Example.of(contato);
      return repository.findAll(example);
   }  
   
    public List<Contato> findByNomeQBE(String nome) {
      Contato contato = new Contato(); 
      contato.setNome(nome);
        ExampleMatcher matcher = ExampleMatcher
         .matching()
         .withIgnoreCase()
         .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);
      Example<Contato> example = Example.of(contato, matcher);
      return repository.findAll(example);
    }
    
    public List<Contato> findAllByIdadeAsc(){
      Sort sort = new Sort(Direction.ASC, "idade");
      return repository.findAll(sort);
    }
    
    public Page<Contato> findAllPag() {
        Sort sort = new Sort(Direction.ASC, "nome");
        Pageable pageable = new PageRequest(0,5,sort);
        return repository.findAll(pageable);
   }

}
