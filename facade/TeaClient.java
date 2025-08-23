package facade;

public class TeaClient {
    public static void main(String[] args) {
        TeaFacade teaMaker = new TeaFacade("Earl Grey");
        teaMaker.makeTea();
    }
}