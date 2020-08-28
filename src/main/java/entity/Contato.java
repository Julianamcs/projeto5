package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date; 
import javax.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 *
 * @author JulianaMCS
 */
@Entity
@Table(name="CONTATOS")
@NamedQuery(
   name = "Contato.byIdade",
   query = "from Contato c where c.idade = ?1")
@NamedNativeQuery(
   name = "Contato.byNome",
   query = "select * from Contatos where nome like ?1",
   resultClass = Contato.class)
@EntityListeners(AuditingEntityListener.class)
public class Contato extends AbstractPersistable<Long> {
    
   @Column(name = "nome", length = 64, nullable = false)
   private String nome;

   @Column(name = "idade") 
   private Integer idade;

   @Column(name = "data_cadastro") 
   @Temporal(TemporalType.DATE)
   private Date dtCadastro;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "endereco_id", nullable = false) 
   private Endereco endereco;
   
    @Override
    public void setId(Long id) {
      super.setId(id);
    }

   @Column(name = "created_by")
   @CreatedBy
   private String createdBy;
   
   @Column(name = "created_date") 
   @CreatedDate
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date createdDate;
   
   @Column(name = "modified_by") 
   @LastModifiedBy
   private String modifiedBy;
   
   @Column(name = "modified_date")
   @LastModifiedDate
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date modifiedDate;
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idade
     */
    public Integer getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    /**
     * @return the dtCadastro
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * @param dtCadastro the dtCadastro to set
     */
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}
