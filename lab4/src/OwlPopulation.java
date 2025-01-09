import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);

        //TODO: Populate the data with owls constructed from the lines of the file given
        int i = 0;
        while(scanner.hasNextLine() && i < numLines){
            String[] values = scanner.nextLine().split(",");
            String name = values[0];
            int age = Integer.parseInt(values[1]);
            double w = Double.parseDouble(values[2]);

            data[i] = new Owl(name,age,w);
            i++;
        }return i;
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        //TODO: Populate the class variables in OwlPopulation
        this.fileName = fileName;
        populateData();
    }

    public double averageAge(){
        double sumOfAges = 0;
        for (int i = 0; i < data.length; i++){
            sumOfAges += data[i].getAge();
        }
        return sumOfAges/data.length;
    }

    public Owl getYoungest(){
        int min = 10000000;
        int index = 99999;
        for(int i=0; i< data.length;i++) {
            if(data[i].getAge() < min ) {
                min = data[i].getAge();
                index = i;
            }
        }
        if(index != 99999) {
            return data[index];
        }else {
            return null;
        }
    }

    public Owl getHeaviest(){
        double heavy = -1;
        int index = 999999;

        for(int i=0; i<data.length;i++) {
            if(data[i].getWeight() > heavy ) {
                heavy = data[i].getWeight();
                index = i;
            }
        }
        if(index != 999999) {
            return data[index];
        } else {
            return null;
        }
    }

    public String toString(){
        Owl youngest = this.getYoungest();
        Owl heaviest = this.getHeaviest();
        String output = "";

        output += "The youngest owl is " + youngest.getName() + " which is " + youngest.getAge() + " years old" + "\n";
        output += "The heaviest owl is " + heaviest.getName() + " , which weighs  " + heaviest.getWeight() + "\n";
        output += "The Average age of the population is " + averageAge() + "\n";

        return output;
    }

    public boolean containsOwl(Owl other){
        for(Owl each : this.data) {
            if(each.getAge() == other.getAge()  && each.getWeight() == other.getWeight() && each.getName().equals(other.getName())) {
                return true;
            }
        }
        return false;
    }
	
    public void merge(OwlPopulation other){
        //TODO: a brief overview of what you can do to implement this method is given below:

        //1) determine (and store) the distinct owls in the other population.

        //2) make a new data array to hold the correct number of owls for the merged population

        //3) copy over the distinct owls from each population to the data array

        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)
        Owl[] tempDistinctOwls = new Owl[data.length + other.popSize()];
        int distinctOwlCount = 0;
        int duplicateCount = 0;

        for(int i = 0; i < data.length; i++){
            tempDistinctOwls[distinctOwlCount] = data[i];
            distinctOwlCount++;
        }
        for(int a = 0; a < other.popSize(); a++) {
            for (int i = 0; i < data.length; i++) {
                if (data[i].getWeight() == other.data[a].getWeight() && data[i].getName().equals(other.data[a].getName()) && data[i].getAge() == other.data[a].getAge()) {
                    duplicateCount++;
                }
            }if(duplicateCount == 0){
                tempDistinctOwls[distinctOwlCount] = data[a];
                distinctOwlCount++;
            }
            duplicateCount = 0;
        }
        Owl[] distinctOwls = new Owl[distinctOwlCount];

        for (int k = 0; k < distinctOwlCount; k++){
            distinctOwls[k] = tempDistinctOwls[k];
        }
        this.data = distinctOwls;
    }

    public int popSize(){
        return data.length;
    }
	
    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1);
            System.out.println(pop1.popSize());

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());

            pop1.merge(pop2);
            System.out.println(pop1);
            System.out.println(pop1.popSize());
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }


}
