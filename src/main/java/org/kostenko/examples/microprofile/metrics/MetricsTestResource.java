package org.kostenko.examples.microprofile.metrics;

import io.smallrye.metrics.exporters.JsonExporter;
import io.smallrye.metrics.exporters.OpenMetricsExporter;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.*;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

@Singleton
@Path("/test")
@ApplicationPath("/")
public class MetricsTestResource extends Application {

    @GET
    @Path("/p")
    @SimplyTimed
    public String prometheus() {
        OpenMetricsExporter ome = new OpenMetricsExporter();
         return   ome.exportAllScopes().toString();
    }

    @Path("/ok")
    public Long json() {
        JsonExporter ome = new JsonExporter();
        return 123l;
    }

}
