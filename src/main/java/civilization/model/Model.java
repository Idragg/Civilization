package civilization.model;


import civilization.model.map.Map;

public class Model {
    private Map map;

    public  Model() {
        map = new Map(20,15);
    }

    public Map getMap() {
        return map;
    }
}
