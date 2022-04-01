package interfaccia;

public class VariazioneStrategyFactory {
    private static VariazioneStrategyFactory singleton;

    private VariazioneStrategyFactory(){};
    public static VariazioneStrategyFactory getInstance(){
        if(singleton == null)
            singleton = new VariazioneStrategyFactory();
        else
            System.out.println("Istanza già creata");
        return singleton;
    }

    public VariazioneStrategyInterface getVariazioneStrategy(){
        return new VariazioneStandardStrategy();
    }
}
