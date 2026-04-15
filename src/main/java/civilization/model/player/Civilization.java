package civilization.model.player;

public class Civilization {
    private String nameCivilization;
    private String nameLeader;

    public Civilization(String nameCivilization, String nameLeader) {
        this.nameCivilization = nameCivilization;
        this.nameLeader = nameLeader;
    }

    public String getNameCivilization() {
        return nameCivilization;
    }

    public String getNameLeader() {
        return nameLeader;
    }

    @Override
    public String toString() {
        return nameCivilization + " (" + nameLeader + ")";
    }
}
