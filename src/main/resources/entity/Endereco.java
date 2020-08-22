package entity;



import javax.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author JulianaMCS
 */
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractPersistable<Long> {
       
    public enum TipoEndereco{
            RESIDENCIAL,  COMERCIAL
    }

   @Column(name = "tipo", length = 32, nullable = false)
   @Enumerated(EnumType.STRING)
   private TipoEndereco tipoEndereco;

   @Column(name = "logradouro", length = 64, nullable = false) 
   private String logradouro;

   @Column(name = "cidade", length = 64, nullable = false) 
   private String cidade;

   @Column(name = "estado", length = 2, nullable = false) 
   private String estado;

   @Override
   public void setId(Long id) {
      super.setId(id);
   }

    /**
     * @return the tipoEndereco
     */
    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    /**
     * @param tipoEndereco the tipoEndereco to set
     */
    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
