
# Tame Your Spring Microservices With GraphQL Stitching Using Lilo

This repo was created by watching the following video: [Tame Your Spring Microservices With GraphQL Stitching Using Lilo](https://www.youtube.com/watch?v=5GQpxqORlr0)

## Testing

Launch the three projects in the following order:

1. `cd server1 && mvn org.springframework.boot:spring-boot-maven-plugin:run`
1. `cd server2 && mvn org.springframework.boot:spring-boot-maven-plugin:run`
1. `cd router && mvn org.springframework.boot:spring-boot-maven-plugin:run`

You can query the router with: 

```shell
curl -s -X POST -H 'content-type: application/json' -d '{"query": "{ hello1 \n hello2 }", "variables":null}' http://localhost:8080/graphql 
```

Which if you pipe to `jq` to pretty print should give something like: 

```json
{
  "data": {
    "hello1": "Hello from server 1!",
    "hello2": "Hello from server 2"
  }
}
```

The graqhiql playgrounds are available at:

 * server1 [http://localhost:8081/graphiql](http://localhost:8081/graphiql)
 * server2 [http://localhost:8082/graphiql](http://localhost:8082/graphiql)
 * router [http://localhost:8080/graphiql.html](http://localhost:8080/graphiql.html)

Note that the router is the only one that has the `graphiql.html` file. The other two servers only have the `/graphiql` endpoint.
