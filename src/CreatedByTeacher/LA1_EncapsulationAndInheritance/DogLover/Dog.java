package CreatedByTeacher.LA1_EncapsulationAndInheritance.DogLover;

public class Dog {

    private String breed;
    private char gender;
    private String color;

    public Dog(char gender, String color){
        setGender(gender);
        setColor(color);
        this.breed = "Golden Retriever";
    }

    public String getBreed(){
        return breed;
    }

    public char getGender(){
        return gender;
    }

    public String getColor(){
        return color;
    }

    public void setGender(char gender){
        if(gender == 'f'){
            this.gender = 'f';
        }else{
            this.gender = 'm';
        }
    }

    public void setColor(String color){
        if(color.equals("brown")){
            this.color = "brown";
        }else if(color.equals("gold")){
            this.color = "gold";
        }else{
            this.color = "gold";
        }
    }

    public String toString(){
        return (gender == 'f') ? String.format("My female, %s Golden Retriever", getColor()) : String.format("My male, %s Golden Retriever", getColor());
    }

    public void bark(int n){
        for(int i = 0; i < n; i++){
            System.out.println("Woof");
        }
    }
}
