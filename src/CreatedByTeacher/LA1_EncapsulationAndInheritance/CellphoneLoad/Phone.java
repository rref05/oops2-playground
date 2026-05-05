package CreatedByTeacher.LA1_EncapsulationAndInheritance.CellphoneLoad;

public class Phone {

    private boolean hasUnlimitedCalls;
    private boolean hasUnlimitedTexts;
    private int internetMB;

    public Phone(){
        this.hasUnlimitedCalls = false;
        this.hasUnlimitedTexts = false;
        this.internetMB = 0;
    }

    public void setHasUnlimitedCalls(boolean hasUnlimitedCalls){
        this.hasUnlimitedCalls = hasUnlimitedCalls;
    }

    public void setHasUnlimitedTexts(boolean hasUnlimitedTexts){
        this.hasUnlimitedTexts = hasUnlimitedTexts;
    }

    public void setInternetMB(int internetMB){
        this.internetMB = internetMB;
    }

    public void load(CellphoneLoad load){
        setInternetMB(load.getInternetMB() + this.internetMB);
        setHasUnlimitedCalls(load.hasUnlimitedCalls());
        setHasUnlimitedTexts(load.hasUnlimitedTexts());
    }

    public String toString(){
        return String.format("Has unlimited calls = %b, Has unlimited texts = %b, Internet MB = %d", hasUnlimitedCalls, hasUnlimitedTexts, internetMB);
    }

}
