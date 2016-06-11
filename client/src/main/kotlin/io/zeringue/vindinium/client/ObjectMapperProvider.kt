package io.zeringue.vindinium.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import javax.ws.rs.ext.ContextResolver
import javax.ws.rs.ext.Provider

@Provider
internal class ObjectMapperProvider : ContextResolver<ObjectMapper> {

    override fun getContext(type: Class<*>): ObjectMapper {
        return ObjectMapper().registerKotlinModule()
    }

}