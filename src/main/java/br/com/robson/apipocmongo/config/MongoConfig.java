package br.com.robson.apipocmongo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

/*
 * @Slf4j
 * 
 * @Configuration public class MongoConfig extends
 * AbstractMongoClientConfiguration {
 * 
 * @Value("${spring.data.mongodb.uri}") private String mongoUri;
 * 
 * @Override protected String getDatabaseName() { return "api"; }
 * 
 * @Bean
 * 
 * @Override public MongoClient mongoClient() { ConnectionString
 * connectionString = new ConnectionString(mongoUri); MongoClientSettings
 * mongoClientSettings = MongoClientSettings.builder()
 * .applyConnectionString(connectionString) .build(); MongoClient client =
 * MongoClients.create(mongoClientSettings);
 * log.info("MongoClient criado com sucesso."); return client; }
 * 
 * }
 */