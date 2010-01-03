package com.goodworkalan.danger;

import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentMap;

@SuppressWarnings("serial")
public class CodedDanger extends Danger {
    /** The error code. */
    private final int code;
    
    public CodedDanger(ConcurrentMap<String, ResourceBundle> bundles, int code, Throwable cause) {
        super(bundles, Integer.toString(code), null);
        this.code = code;
    }
    
    /**
     * Get the error code.
     * 
     * @return The error code.
     */
    public int getCode() {
        return code;
    }
}
