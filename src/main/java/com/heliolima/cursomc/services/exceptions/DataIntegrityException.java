
package com.heliolima.cursomc.services.exceptions;

/**
 *
 * @author Helio Lima
 */
public class DataIntegrityException extends RuntimeException{

    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }

    
    
}
