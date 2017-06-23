package nl.hu.iac.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/statistics")
public class StatisticsRestService {
	@POST
	@Path("/mean")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON})
	public double calculateMean(List<Double> doubleList) {
		return Statistics.getMean(doubleList);
	}

	@POST
	@Path("/variance")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON})
	public double calculateVariance(List<Double> doubleList) {
		return Statistics.getVariance(doubleList);
	}

	@POST
	@Path("/standard-deviation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON})
	public double calculateStandardDeviation(List<Double> doubleList) {
		return Statistics.getStandardDeviation(doubleList);
	}

	@GET
	@Path("/last-result")
	@Produces({MediaType.APPLICATION_JSON})
	public double getLastResult() {
		return Statistics.getLastResult();
	}
}
