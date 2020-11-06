package net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity;

import java.util.Objects;


public class Field {
    
    private String type;
    
    private boolean optional;
    
    private String field;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.type);
        hash = 19 * hash + Objects.hashCode(this.field);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Field other = (Field) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.field, other.field)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Field{" + "type=" + type + ", optional=" + optional + ", field=" + field + '}';
    }
    
    
    
    
    
}
