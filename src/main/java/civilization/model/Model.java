package civilization.model;


import civilization.model.map.Map;

public class Model {
    private Map map;

    public  Model() {
        map = new Map(Settings.WIDTHMAP,Settings.HEIGHTMAP);
    }

    public Map getMap() {
        return map;
    }
}
