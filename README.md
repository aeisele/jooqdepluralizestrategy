# jooq depluralize naming strategy

## Why?

Some people prefer table names to be in pluralized form which can lead to semantically strange code when using jooq
codegen for POJOs and DAOs.

```java
Customers customer = CustomersDao.fetchOneById(4711);
```

This strategy can be used to turn plural table terms into singular terms for code generation

```java
Customer customer = CustomerDao.fetchOneById(4711);
```

## How

Add a plugin repository to use jitpack.io
```xml
<pluginRepository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</pluginRepository>
```

Add dependency to this artifact to your jooq maven plugin config
```xml
<plugin>
    <groupId>org.jooq</groupId>
    <artifactId>jooq-codegen-maven</artifactId>
    ...
    <dependencies>
        <dependency>
            <groupId>com.github.aeisele</groupId>
            <artifactId>jooqdepluralizestrategy</artifactId>
            <version>1.0</version>
        </dependency>
    </dependencies>
    <configuration>
        ...
        <generator>
            <strategy>
                <name>com.andreaseisele.jooq.strategy.DepluralizeNamingStrategy</name>
            </strategy>
        ...
        </generator>
    </configuration>
</plugin>
``` 