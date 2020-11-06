package net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity;

import java.util.List;
import java.util.Objects;


public class MasterSchema {
    
    private String type;
    
    private List<MessageSchema> fields;
    
    private boolean optional;
    
    private String name;

    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MessageSchema> getFields() {
        return fields;
    }

    public void setFields(List<MessageSchema> fields) {
        this.fields = fields;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final MasterSchema other = (MasterSchema) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.fields, other.fields)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MasterSchema{" + "type=" + type + ", fields=" + fields + ", optional=" + optional + ", name=" + name + '}';
    }
    
    
    
}
