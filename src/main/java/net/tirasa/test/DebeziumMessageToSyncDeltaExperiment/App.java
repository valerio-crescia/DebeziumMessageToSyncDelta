package net.tirasa.test.DebeziumMessageToSyncDeltaExperiment;

import net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity.DebeziumMessage;
import org.identityconnectors.framework.common.objects.SyncDeltaBuilder;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.AttributeBuilder;
import org.identityconnectors.framework.common.objects.ConnectorObject;
import org.identityconnectors.framework.common.objects.Name;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.SyncDelta;
import org.identityconnectors.framework.common.objects.SyncDeltaType;
import org.identityconnectors.framework.common.objects.SyncToken;
import org.identityconnectors.framework.common.objects.Uid;

public class App {

//    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final SyncDeltaBuilder SYNC_DELTA_BUILDER = new SyncDeltaBuilder();
    
    private static final DebeziumMessage DEBEZIUM_MESSAGE = 
            Utils.deserializeDebeziuMessage("/home/valerio/Scrivania/workspace-tirasa/add.json");

    public static void main(final String[] args) throws IOException {
        
        System.err.println(dinamicSyncDelta().toString());

    }

    private static SyncDelta dinamicSyncDelta() {
        SyncToken syncToken = new SyncToken(DEBEZIUM_MESSAGE.getPayload().getSource().getTsMs().toString());

        //Setto il token
        SYNC_DELTA_BUILDER.setToken(syncToken);

        Set<Attribute> attributes = new HashSet<>();

        String name;
        String surname;

        Uid uid;

        switch (DEBEZIUM_MESSAGE.getPayload().getOperation()) {
            case CREATE:
                //Setto il delta type
                SYNC_DELTA_BUILDER.setDeltaType(SyncDeltaType.CREATE);

                getAfterInformation(attributes);

                break;

            case DELETE:
                SYNC_DELTA_BUILDER.setDeltaType(SyncDeltaType.DELETE);
                
                getBeforeInformation(attributes);

                break;

            case UPDATE:
                SYNC_DELTA_BUILDER.setDeltaType(SyncDeltaType.UPDATE);
                getAfterInformation(attributes);
                break;
            default:
                System.out.println("Messaggio Strano");
        }

        System.out.print(attributes);

        //Creo il connector
        ConnectorObject connectorObject = new ConnectorObject(ObjectClass.ACCOUNT, attributes);
        //add Uid nel connecto

        // Setto il connector
        SYNC_DELTA_BUILDER.setObject(connectorObject);

        return SYNC_DELTA_BUILDER.build();
    }
    
    private static Set<Attribute> getBeforeInformation( final Set<Attribute> attributes) {

                //Creo lo UID
                Uid  uid = new Uid(DEBEZIUM_MESSAGE.getPayload().getBefore().get("id").toString());

                //Setto lo Uid
                SYNC_DELTA_BUILDER.setUid(uid);

                //Mello lo uid dentro gli attributi senno sbotta
                attributes.add(uid);

                //Setto il nome
                String name = DEBEZIUM_MESSAGE.getPayload().getBefore().get("first_name").toString();
                String surname = DEBEZIUM_MESSAGE.getPayload().getBefore().get("last_name").toString();
                attributes.add(new Name(name+" " + surname));

                DEBEZIUM_MESSAGE.getPayload().getBefore().forEach((key, value) -> {

                    Attribute attribute = AttributeBuilder.build(key, value);

                    attributes.add(attribute);

                });
                
                return attributes;
    }
    
    
    
    
    private static Set<Attribute> getAfterInformation(final Set<Attribute> attributes) {
               

                //Creo lo UID
                Uid  uid = new Uid(DEBEZIUM_MESSAGE.getPayload().getAfter().get("id").toString());

                //Setto lo Uid
                SYNC_DELTA_BUILDER.setUid(uid);

                //Mello lo uid dentro gli attributi senno sbotta
                attributes.add(uid);

                //Setto il nome
                String name = DEBEZIUM_MESSAGE.getPayload().getAfter().get("first_name").toString();
                String surname = DEBEZIUM_MESSAGE.getPayload().getAfter().get("last_name").toString();
                attributes.add(new Name(name+" " + surname));

                DEBEZIUM_MESSAGE.getPayload().getAfter().forEach((key, value) -> {

                    Attribute attribute = AttributeBuilder.build(key, value);

                    attributes.add(attribute);

                });
                
                return attributes;
    }
    
    
    
    
    
    

    private SyncDelta createStaticSyncDelta(DebeziumMessage debeziumMessage, SyncDeltaBuilder s) {

        SyncToken syncToken = new SyncToken(debeziumMessage.getPayload().getSource().getTsMs().toString());

        //Setto il token
        s.setToken(syncToken);

        //Setto il delta type
        s.setDeltaType(SyncDeltaType.UPDATE);

        //Creo lo UID
        Uid uid = new Uid(debeziumMessage.getPayload().getAfter().get("id").toString());

        //Setto lo Uid
        s.setUid(uid);

        Set<Attribute> attributes = new HashSet<>();

        //Mello lo uid dentro gli attributi senno sbotta
        attributes.add(uid);

        //Vuole per forza un attributo di nome NAME (Forse)
        Attribute name = new Name("mario");
        attributes.add(name);

        System.out.println(name.getName());

        debeziumMessage.getPayload().getAfter().forEach((key, value) -> {

            Attribute attribute = AttributeBuilder.build(key, value);

            attributes.add(attribute);

        });
        System.out.print(attributes);

        //Creo il connector
        ConnectorObject connectorObject = new ConnectorObject(ObjectClass.ACCOUNT, attributes);
        //add Uid nel connecto

        // Setto il connector
        s.setObject(connectorObject);

        return s.build();
    }

}
