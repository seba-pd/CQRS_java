package query.impl;

import query.Query;

import java.util.UUID;

public class GetItemQuery implements Query {

    private UUID id;

    public GetItemQuery(UUID id) {
        setId(id);
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }
}
