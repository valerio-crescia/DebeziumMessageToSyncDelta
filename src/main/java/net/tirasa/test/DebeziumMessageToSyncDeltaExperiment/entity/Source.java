
package net.tirasa.test.DebeziumMessageToSyncDeltaExperiment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


public class Source {

        private String version;

        private String connector;

        private String name;

        @JsonProperty("ts_ms")
        private Date tsMs;

        private String snapshot;

        private String db;

        private String table;

        @JsonProperty("server_id")
        private long serverId;

        private Long gtid;

        private String file;

        private long pos;

        private long row;

        private long thread;

        private String query;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getConnector() {
            return connector;
        }

        public void setConnector(String connector) {
            this.connector = connector;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTsMs() {
            return tsMs;
        }

        public void setTsMs(Date tsMs) {
            this.tsMs = tsMs;
        }

        public String getSnapshot() {
            return snapshot;
        }

        public void setSnapshot(String snapshot) {
            this.snapshot = snapshot;
        }

        public String getDb() {
            return db;
        }

        public void setDb(String db) {
            this.db = db;
        }

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }

        public long getServerId() {
            return serverId;
        }

        public void setServerId(long serverId) {
            this.serverId = serverId;
        }

        public Long getGtid() {
            return gtid;
        }

        public void setGtid(Long gtid) {
            this.gtid = gtid;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public long getPos() {
            return pos;
        }

        public void setPos(long pos) {
            this.pos = pos;
        }

        public long getRow() {
            return row;
        }

        public void setRow(long row) {
            this.row = row;
        }

        public long getThread() {
            return thread;
        }

        public void setThread(long thread) {
            this.thread = thread;
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

    @Override
    public String toString() {
        return "Source{" + "version=" + version + ", connector=" + connector +
                ", name=" + name + ", tsMs=" + tsMs + ", snapshot=" + snapshot + 
                ", db=" + db + ", table=" + table + ", serverId=" + serverId +
                ", gtid=" + gtid + ", file=" + file + ", pos=" + pos +
                ", row=" + row + ", thread=" + thread + ", query=" + query + '}';
    }
        
        
        
    }