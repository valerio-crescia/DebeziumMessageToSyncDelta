

package net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity;

import java.util.HashMap;
import java.util.Map;


public class Payload {
    
    private Source source;

    private Operation operation;
    
    private final Map<String, Object> before = new HashMap<>();

    private final Map<String, Object> after = new HashMap<>();

    
    public Map<String, Object> getBefore() {
        return before;
    }

    public Map<String, Object> getAfter() {
        return after;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(final Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Payload{" + "source=" + source + ", operation=" + operation + ", before=" + before + ", after=" + after + '}';
    }
    
    
    
}
