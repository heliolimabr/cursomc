
package com.heliolima.cursomc.services.exceptions;

/**
 *
 * @author Helio Lima
 */
public class FileException extends RuntimeException{

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    
    
}
