
package net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity;


public enum Operation {
        CREATE("c"),
        UPDATE("u"),
        DELETE("d");

        final String op;

        Operation(final String op) {
            this.op = op;
        }

        public static Operation fromOp(final String op) {
            for (Operation value : values()) {
                if (value.op.equals(op)) {
                    return value;
                }
            }
            return null;
        }
    }
