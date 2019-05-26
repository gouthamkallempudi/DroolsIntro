package com.taxdrools.taxdrools.Config;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DrollsBeanFactory {
    public static final String RULES_PATH = "rules";
    private KieServices kieServices = KieServices.Factory.get();


    private KieFileSystem getKieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        List<String> rules = Arrays.asList("hike.drl"); //"BackwardChaining.drl",,"Product_rules.xls"
        for (String rule : rules) {
            kieFileSystem.write(ResourceFactory.newClassPathResource(rule));
        }
        return kieFileSystem;
    }

    public KieContainer getKieContainer() throws IOException {

        getKieRepository();
        KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
        kb.buildAll();

        KieModule kieModule = kb.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        return kieContainer;
    }

    private void getKieRepository() {
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }

    public KieSession getKieSession() {
        getKieRepository();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        // kieFileSystem.write(ResourceFactory.newClassPathResource("com/goutham/drools/rules/BackwardChaining.drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("rules/hike.drl"));
        //kieFileSystem.write(ResourceFactory.newClassPathResource("com/goutham/drools/rules/Product_rules.xls"));


        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();

        KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        return kContainer.newKieSession();

    }

}

