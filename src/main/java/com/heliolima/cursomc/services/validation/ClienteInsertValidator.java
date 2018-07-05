package com.heliolima.cursomc.services.validation;

import com.heliolima.cursomc.domain.enums.TipoCliente;
import com.heliolima.cursomc.dto.ClienteNewDTO;
import com.heliolima.cursomc.resources.exceptions.FieldMessage;
import com.heliolima.cursomc.services.validation.utils.BR;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Helio
 */
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO>{
    
    @Override
    public void initialize(ClienteInsert ann){
    }
    
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context){
        List<FieldMessage> list = new ArrayList<>();
        
        if(objDto.getTipo() == null) 
            list.add(new FieldMessage("Tipo", "Tipo não pode ser nulo"));
        
        if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj()))
            list.add(new FieldMessage("CpfOuCnpj", "CPF inválido"));
        
        if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj()))
            list.add(new FieldMessage("CpfOuCnpj", "CNPJ inválido"));
        
        list.forEach((e) -> {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        });
        return list.isEmpty();
    }
}
