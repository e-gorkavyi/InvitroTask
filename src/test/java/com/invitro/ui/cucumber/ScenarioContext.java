package com.invitro.ui.cucumber;

import java.util.HashMap;
import java.util.Map;
import com.invitro.ui.enums.Context;

public class ScenarioContext {
    private static ScenarioContext INSTANCE;
    private Map<String, Object> scenarioContext = new HashMap<>();

    private ScenarioContext(){
    }

    public static ScenarioContext getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ScenarioContext();
        return INSTANCE;
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }
}
