# Grakn Examples

This repository includes examples that showcase usage of Grakn Clients in reading from and writing to a Grakn knowledge graph.

## Explore Client Examples

Grakn officially supports development of clients for Java, Node.js and Python. Learn more about [Grakn Clients](http://dev.grakn.ai/docs/client-api/overview).

### Client Java Examples
- [Phone Calls: Migrate and perform expressive queries using Client Java](phone_calls/java/)

### Client Node.js Examples
- [Phone Calls: Migrate and perform expressive queries using Client Node.js](phone_calls/nodejs/)

### Client Python Examples
- [Tube Network: Migrate and perform analytical queries on the London tube network](tube_network/)
- [Phone Calls: Migrate and perform expressive queries using Client Python](phone_calls/python/)

## Explore Use Cases
- Migrate data to Grakn:
    - serialised:
        - Java: [CSV](phone_calls/java/CSVMigration.java) | [JSON](phone_calls/java/JSONMigration.java) | [XML](phone_calls/java/XMLMigration.java)
        - Node.js: [CSV](phone_calls/nodejs/migrateCSV.js) | [JSON](phone_calls/nodejs/migrateJSON.js) | [XML](phone_calls/nodejs/migrateXML.js)
        - Python: [CSV](phone_calls/python/migrate_csv.py) | [JSON](phone_calls/python/migrate_json.py) | [XML](phone_calls/python/migrate_xml.py)
    - concurrent:
        - Python: [JSON](tube_network/src/migration.py)
- Perform expressive queries:
    - [Java](phone_calls/java/Queries.java)
    - [Node.js](phone_calls/nodejs/queries.js)
    - [Python](phone_calls/python/queries.py)
- Perform statistical and analytical queries:
    - Python: [statistical](tube_network/src/statistics.py) | [shortest path](tube_network/src/journey_planner.py) | [centrality](tube_network/src/app.py)

## Explore Schemas
- [Phone Calls](schemas/phone-calls-schema.gql)
- [Tube Network](schemas/tube-network-schema.gql)
- [Social Network](schemas/social-network-schema.gql)