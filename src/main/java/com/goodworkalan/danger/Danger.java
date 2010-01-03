package com.goodworkalan.danger;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentMap;

import com.goodworkalan.notice.message.Message;

@SuppressWarnings("serial")
public class Danger extends RuntimeException {
    /** The formatted message. */
    private final Message message;
    
    /** The map of diagnostic data. */
    private final Map<Object, Object> data;
    
    public Danger(ConcurrentMap<String, ResourceBundle> bundles, String messageKey, Throwable cause) {
        super(null, cause);
        this.data = new HashMap<Object, Object>(); 
        this.message = new Message(bundles, getClass().getCanonicalName(), "exceptions", messageKey, this.data);
    }
    
    public Danger put(Object name, Object value) {
        data.put(name, value);
        return this;
    }
    
    public Map<Object, Object> getData() {
        return data;
    }
    
    @Override
    public String getMessage() {
        return message.toString();
    }
}
