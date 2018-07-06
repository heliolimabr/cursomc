package com.heliolima.cursomc.services.validation;

import com.heliolima.cursomc.domain.Cliente;
import com.heliolima.cursomc.domain.enums.TipoCliente;
import com.heliolima.cursomc.dto.ClienteDTO;
import com.heliolima.cursomc.dto.ClienteNewDTO;
import com.heliolima.cursomc.repositories.ClienteRepository;
import com.heliolima.cursomc.resources.exceptions.FieldMessage;
import com.heliolima.cursomc.services.validation.utils.BR;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

/**
 *
 * @author Helio
 */
public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO>{
    
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private ClienteRepository repo;
    
    @Override
    public void initialize(ClienteUpdate ann){
    }
    
    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context){
        
        Map<String, String> map = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));
        
        List<FieldMessage> list = new ArrayList<>();
        
        Cliente cliEmail = repo.findByEmail(objDto.getEmail());
        if(cliEmail != null && !cliEmail.getId().equals(uriId)){
            list.add(new FieldMessage("Email", "E-mail já existente"));
        }
        
        list.forEach((e) -> {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        });
        return list.isEmpty();
    }
}
