package train;

import train.resources.IndexResource;
import train.resources.NamedEntitiesResource;
import train.resources.ReferencesResource;
import train.resources.TokSentencesResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DemoApplication extends Application<DemoConfiguration> {
    public static void main(String[] args) throws Exception{
        new DemoApplication().run(args);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void initialize(Bootstrap<DemoConfiguration> bootstrap) {
    }

    @Override
    public void run(DemoConfiguration configuration, Environment environment) throws Exception {
        NamedEntitiesResource namedEntitiesResource = new NamedEntitiesResource();
        ReferencesResource referencesResource = new ReferencesResource();
        IndexResource indexResource = new IndexResource();
        environment.jersey().register(namedEntitiesResource);
        environment.jersey().register(referencesResource);
        environment.jersey().register(TokSentencesResource.class);
        environment.jersey().register(indexResource);
    }
}
