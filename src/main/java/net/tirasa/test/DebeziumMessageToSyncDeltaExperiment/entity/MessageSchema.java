
package net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity;


import java.util.ArrayList;


public class MessageSchema {
    
    private String type;
    
    private ArrayList<Field> fields;
    
    private boolean optional;
    
    private String name;
    
    private String field;
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Field> fields) {
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "MessageSchema{" + "type=" + type + ", fields=" + fields + 
                ", optional=" + optional + ", name=" + name + 
                ", field=" + field + '}';
    }
    
    
    
    
}
