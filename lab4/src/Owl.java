public class Owl {
    private String name;
    private int age;
    private double weight;

    public Owl(String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
    public boolean equals(Owl other){
       if (this.getAge() == other.getAge() &&
               this.getName() == other.getName() &&
               this.getWeight() == other.getWeight()){
           return true;
       }else{
           return false;
       }
    }
}
