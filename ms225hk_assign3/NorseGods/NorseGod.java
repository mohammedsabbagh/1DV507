package ms225hk_assign3.NorseGods;

public class NorseGod {

    private String name;
    private String race;
    private String desc;


    NorseGod(String name, String race, String desc) {
        this.name = name;
        this.race = race;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
