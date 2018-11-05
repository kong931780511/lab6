package com.ups.shipping;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/initiation")
public class ShippingInitiation {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response ping() {
		return Response.ok("Hello, UPS is up and running").build();
	}
	
	@POST
	@Path("/start")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject initiateShipping(JsonObject incomingJson) {
		String organization = incomingJson.getString("Organization");
		int orderRefId = incomingJson.getInt("OrderRefId");
		int numberOfItemsToShip = incomingJson.getInt("ItemsNumber");
		String zip = incomingJson.getString("Zip");
		
		System.out.println("UPS\n===\n" + organization
				+ " requested shipping of " + numberOfItemsToShip
				+ " items to zip " + zip
				+ ", Order Ref: " + orderRefId);
		
		JsonObject responseJson = Json.createObjectBuilder()
				.add("Accepted", true)
				.add("ShippingReferenceNumber", 1005)
				.add("Organization", organization)
				.add("OrderRefId", orderRefId)
				.build();
		
		return responseJson;
		
	}
}
