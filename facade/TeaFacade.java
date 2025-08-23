package facade;

public class TeaFacade {
    private Tea tea;
    private TeaInfuser infuser;
    private Water water;
    private TeaCup cup;

    public TeaFacade(String flavor) {
        this.tea = new Tea(flavor);
        this.infuser = new TeaInfuser();
        this.water = new Water();
        this.cup = new TeaCup();
    }

    public void makeTea() {
        water.boilWater();
        infuser.addTea(tea);
        cup.infuseTea(infuser);
        cup.addWater(water);
        cup.steep();
    }
}
