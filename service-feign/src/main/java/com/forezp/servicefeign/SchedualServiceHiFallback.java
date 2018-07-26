package com.forezp.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiFallback implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "hello" + name + ",wrong";
    }
}
