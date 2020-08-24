
import javax.persistence.Entity;
import javax.persistence.StoredProcedureParameter;

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
@NamedStoredProcureedQuery( 
   name = "Usuario.soma",
   procedureName = "procedure_soma",
   parameters = { 
      @StoredProcedureParameter( 
         mode = ParameterMode.IN, 
         name = "arg",
         type = Integer.class),
      @StoredProcedureParameter(
         mode = ParameterMode.OUT, 
         name = "res",
         type = Integer.class)
   })
public class Usuario {
    
}
