package example.nerdery.supportlibrarydemo.models;

/**
 * Created by sbastin on 10/15/15.
 */
public class Spicoli {
    private Boolean coolBuzz;
    private Boolean tastyWaves;
    private Boolean isFine;

    public Spicoli(Boolean isBuzzed, Boolean isCurrentlyShreddingTastyWaves){
        this.coolBuzz = isBuzzed;
        this.tastyWaves = isCurrentlyShreddingTastyWaves;
        this.isFine = isSpicoliFine();
    }

    public Boolean getCoolBuzz() {
        return coolBuzz;
    }

    public void setCoolBuzz(Boolean coolBuzz) {
        this.coolBuzz = coolBuzz;
    }

    public Boolean getTastyWaves() {
        return tastyWaves;
    }

    public void setTastyWaves(Boolean tastyWaves) {
        this.tastyWaves = tastyWaves;
    }

    public Boolean getIsFine(){
        return isFine;
    }

    private boolean isSpicoliFine() {
        return tastyWaves && coolBuzz;
    }
}
