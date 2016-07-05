package com.example.rest;

import org.wildfly.swarm.swagger.SwaggerArchive;
import org.wildfly.swarm.swagger.internal.SwaggerArchiveImpl;

import javax.enterprise.inject.spi.Bean;
import javax.inject.Inject;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;


@ApplicationPath("/rest")
public class RestApplication extends Application {

}