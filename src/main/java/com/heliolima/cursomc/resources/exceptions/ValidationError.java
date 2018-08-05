
package com.heliolima.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helio Lima
 */
public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<FieldMessage>();

    public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);
    }
    
    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }

    
    
}
