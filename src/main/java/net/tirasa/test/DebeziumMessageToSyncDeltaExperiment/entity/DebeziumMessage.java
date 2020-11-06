package net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity;


public class DebeziumMessage {
    
    private MasterSchema schema;
    
    private Payload payload;
    
    
    public DebeziumMessage() {
    }
    
    public DebeziumMessage(Payload payload) {
        this.payload = payload;
    }

    
    
    public MasterSchema getSchema() {
        return schema;
    }

    public void setSchema(MasterSchema schema) {
        this.schema = schema;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "DebeziumMessage{" + "schema=" + schema + ", payload=" + payload + '}';
    }

   

   
    
    

    
}
