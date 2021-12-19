package query;

import domain.Item;

public interface QueryHandler {

    Item handle(Query query);
}
