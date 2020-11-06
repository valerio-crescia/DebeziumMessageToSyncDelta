package net.tirasa.test.DebeziumMessageToSyncDeltaExperiment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity.DebeziumMessage;
import net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity.MasterSchema;
import net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity.MessageSchema;
import net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity.Operation;
import net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity.Payload;
import net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity.Source;

/**
 *
 * @author valerio
 */
public class Utils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static DebeziumMessage deserializeDebeziuMessage(final String url) {

        DebeziumMessage debeziuMessage = new DebeziumMessage(new Payload());

        try {
            JsonNode message = MAPPER.readTree(new File(url));

            if (message != null) {
                JsonNode payload = message.get("payload");
                JsonNode schema = message.get("schema");
               // System.out.println("XXXXXXXXXXX\n" + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(payload));
                
                //Get Schema info
                JsonNode fields = schema.get("fields");
                
                JsonNode  schemaBefore = fields.get(0);
                JsonNode  schemaAfter = fields.get(1);
                
                List<MessageSchema> schemas = new ArrayList<>();
                
                schemas.add(MAPPER.treeToValue(schemaBefore, MessageSchema.class));
                
                schemas.add(MAPPER.treeToValue(schemaAfter, MessageSchema.class));
               
                debeziuMessage.setSchema(new MasterSchema());
                   
                debeziuMessage.getSchema().setFields(schemas);
                
                
                
                
                //End Scheme info
                
                
                //Get paload info
               
                
                
                
                addInformation(payload, "before", debeziuMessage.getPayload().getBefore());
                addInformation(payload, "after", debeziuMessage.getPayload().getAfter());

                debeziuMessage.getPayload().setOperation(Operation.fromOp(payload.get("op").asText()));
                debeziuMessage.getPayload().setSource(MAPPER.treeToValue(payload.get("source"), Source.class));
                //END Payload info
            }

        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, "Errore lettura file: {}", ex);
        }

        return debeziuMessage;
    }

    private static void addInformation(JsonNode payload, String label, Map<String, Object> map)
            throws JsonProcessingException {

        if (payload.has(label)) {
            if (!(payload.get(label) instanceof NullNode)) {
                ObjectNode info = (ObjectNode) payload.get(label);

                for (Iterator<Map.Entry<String, JsonNode>> itor = info.fields(); itor.hasNext();) {
                    Map.Entry<String, JsonNode> entry = itor.next();
                    map.put(entry.getKey(), MAPPER.treeToValue(entry.getValue(), Object.class));
                }
            }

        }
    }

}
