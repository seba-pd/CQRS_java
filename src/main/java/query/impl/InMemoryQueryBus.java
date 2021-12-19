package query.impl;

import query.Query;
import query.QueryHandler;
import domain.Item;
import query.QueryBus;

import java.util.LinkedList;
import java.util.Map;

public class InMemoryQueryBus implements QueryBus {
    private final Map<String, QueryHandler> handlerMap;
    private final LinkedList<Query> queryQueue;
    private Boolean isHandle = false;

    public InMemoryQueryBus(Map<String, QueryHandler> handlerMap, LinkedList<Query> queryQueue) {
        this.handlerMap = handlerMap;
        this.queryQueue = queryQueue;
    }

    @Override
    public Item execute(Query query) {

        queryQueue.add(query);
        if (isHandle) return null;

            while (!queryQueue.isEmpty()) {
                isHandle = true;
                Query actualHandlingQuery = queryQueue.poll();
                String handlerName = actualHandlingQuery.getClass().getName();
                if(queryQueue.isEmpty()) isHandle = false;
                return handlerMap.get(handlerName).handle(actualHandlingQuery);
            }
            return null;
        }
    }
