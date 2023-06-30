package com.inflearn.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> autoConfig = new ArrayList<>();

//        for(String candidate: ImportCandidates.load(MyAutoConfiguration.class, classLoader)){
//            autoConfig.add(candidate);
//        }

        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfig::add);

        return autoConfig.toArray(new String[0]);
        //        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
        //        //스프링 컨테이너가 빈을 생성하기 위해 빈 클래스를 로딩할때 사용할 classLoader 를 선언하고 생성해야한다.
        //        return StreamSupport.stream(candidates.spliterator(),false).toArray(String[]::new);

    }

}
