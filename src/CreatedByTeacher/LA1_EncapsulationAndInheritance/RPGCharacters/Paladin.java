package CreatedByTeacher.LA1_EncapsulationAndInheritance.RPGCharacters;

public class Paladin extends Swordsman{

    private boolean hasResurrected;

    public Paladin(){
        super();
        this.hasResurrected = false;
    }

    @Override
    public void receiveDamage(int damage){

        damage = (damage % 2 == 0) ? (damage / 2) : (damage * 1);

        int result = damage - getShield();

        if(result < 0){
            result = 0;
        }

        setHealth(getHealth() - result);

        if(getHealth() <= 0) {
            System.out.println("Character has died");
            resurrect();
        }
    }

    public void resurrect(){
        if(hasResurrected == false){
            this.hasResurrected = true;
            setHealth(100);
        }else{
            System.out.println("Paladin has died");
        }
    }
}
