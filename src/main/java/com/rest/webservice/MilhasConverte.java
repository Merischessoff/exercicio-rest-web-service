package com.rest.webservice;

import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
Quilômetro por hora para milhas por hora (1=0.621371) – esse método deve trabalhar 
responder por POST e receber/enviar dados em form-encoded.
Nós para quilometro por hora (1=1.852) – esse método deve trabalhar responder 
por POST e receber/enviar dados em JSON.
 */
@Path("/milha/{valor}")
@Singleton
public class MilhasConverte {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public Quilometro quilometoHoraParaMilhasHora(@PathParam("valor") double valor) {
        double valorConvertido = valor / 1.609;
        Quilometro q = new Quilometro();
        q.setValorConvertido(valorConvertido);
        return q;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("valor") String valor) {
        Quilometro q = new Quilometro();
        q.setValorConvertido(Double.parseDouble(valor));
        return String.valueOf(q.getValorConvertido());
    }
    
}
