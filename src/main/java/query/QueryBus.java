package query;

import domain.Item;

public interface QueryBus {

    Item execute(Query query);
}
