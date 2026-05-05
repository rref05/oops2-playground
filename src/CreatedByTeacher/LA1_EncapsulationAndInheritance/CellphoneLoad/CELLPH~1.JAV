package CreatedByTeacher.LA1_EncapsulationAndInheritance.CellphoneLoad;

public class CellphoneLoad {

    private boolean hasUnlimitedCalls;
    private boolean hasUnlimitedTexts;
    private int internetMB;

    public CellphoneLoad(boolean hasUnlimitedCalls, boolean hasUnlimitedTexts, int internetMB){
        this.hasUnlimitedCalls = hasUnlimitedCalls;
        this.hasUnlimitedTexts = hasUnlimitedTexts;
        this.internetMB = internetMB;

    }

    public boolean hasUnlimitedCalls(){
        return hasUnlimitedCalls;
    }

    public boolean hasUnlimitedTexts(){
        return hasUnlimitedTexts;
    }

    public int getInternetMB(){
        return internetMB;
    }
}
