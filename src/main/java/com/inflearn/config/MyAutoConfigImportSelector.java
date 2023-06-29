package com.inflearn.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.inflearn.config.autoconfig.DispatcherServletConfig",
                "com.inflearn.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
