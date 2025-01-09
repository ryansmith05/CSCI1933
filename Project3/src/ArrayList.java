public class ArrayList<T extends Comparable<T>> implements List<T>{

    private T[] a; // an array of objects
    private boolean isSorted; // tells us if the list is sorted
    private int howMany; // tells us how many non-null elements are in the list

    public ArrayList() {
        a = (T[]) new Comparable[2];
        howMany = 0;
        isSorted = true;
    }

    @Override
    public boolean add(T element) {
        if (element == null) { // checks if the element is null
            return false;
        }
        if (howMany == a.length) { // if the array is full, double the size of the array
            T[] biggerArray = (T[]) new Comparable[a.length * 2];
            System.arraycopy(a, 0, biggerArray, 0, a.length);
            a = biggerArray;
        }
        a[howMany++] = element;
        isSorted = checkIfSorted(); // checks if the element that is added breaks the sorted order
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (element == null || index < 0 || index > howMany) { // checks if the index is in the bounds or if the element is null
            return false;
        }
        if (howMany == a.length) { // if the array is full, double the size of the array
            T[] biggerArray = (T[]) new Comparable[a.length * 2];
            System.arraycopy(a, 0, biggerArray, 0, a.length);
            a = biggerArray;
        }
        if (index < howMany) { // shift all elements to the right starting at the end
            for (int i = howMany - 1; i >= index; i--) {
                a[i + 1] = a[i];
            }
        }
        a[index] = element;
        howMany++;
        isSorted = checkIfSorted();
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < a.length; i++) { // set all indices to null
            a[i] = null;
        }
        isSorted = true;
        howMany = 0;
        a = (T[]) new Comparable[2];
    }

    @Override
    public T get(int index) {
        if ((index < 0) || (index > howMany - 1)) { // Check if the index is in the bounds but not checking the null items of the list
            return null;
        }
        else {
            return a[index];
        }
    }

    @Override
    public int indexOf(T element) {
        if (element == null) { // checks if the element is null
            return -1;
        }
        for (int i = 0; i < a.length; i++) { // loop through the list and returns the index of the desired element
                if (a[i] == element) {
                    return i;
                }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if (howMany == 0) { // check if the list is empty
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int size() {
        return howMany; // returns how many elements are in the list, not the length of the list
    }

    @Override
    public void sort() {
        if (isSorted) { // checks if it is already sorted
            return;
        }
        for (int i = 1; i < howMany; i++) { // uses insertion sort to sort the list
            T key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        isSorted = true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= howMany) { // checks if index is in the bounds
            return null;
        }
        T temp = a[index]; // a pointer/temporary variable to keep track of to the value that is being removed before it is set to null
        a[index] = null;
        for (int i = index; i < a.length - 1; i++) { // shifts all the elements to the right starting at the index to fill in the null value
            a[i] = a[i + 1];
        }
        howMany--;
        isSorted = checkIfSorted();
        return temp;
    }

    @Override
    public void equalTo(T element) {
        if (element == null) { // checks if the element is null
            return;
        }
        int rightIndex = 0;
        for (int i = 0; i < howMany; i++) { // loops through the list and removes all the elements not equal to a specific element
            if (a[i] == element) {
                if (rightIndex != i) {
                    a[rightIndex] = a[i];
                }
                rightIndex++;
            }
        }
        howMany = rightIndex;
        isSorted = true;
    }

    @Override
    public void reverse() {
        for (int i = 0; i < howMany/2; i++){ // loops through half the elements and swaps the elements order reversing the list
            T temp = a[i];
            a[i] = a[howMany - i - 1];
            a[howMany - i - 1] = temp;
        }
        isSorted = checkIfSorted();
    }

    @Override
    public void merge(List<T> otherList) {
        if (otherList == null) { // If otherList is null, do not attempt to merge
            return;
        }
        ArrayList<T> other = (ArrayList<T>) otherList; // Cast otherList to either ArrayList<T> or LinkedList<T>
        this.sort(); // Sort the list
        other.sort(); // Sort the other list

        // Merge the two sorted lists using a merge algorithm
        int i = 0;
        int j = 0;
        T[] tempArray = (T[]) new Comparable[this.size() + other.size()];
        int k = 0;
        while (i < this.size() && j < other.size()) {
            if (this.get(i).compareTo(other.get(j)) < 0) {
                tempArray[k] = this.get(i);
                i++;
            }
            else {
                tempArray[k] = other.get(j);
                j++;
            }
            k++;
        }
        while (i < this.size()) {
            tempArray[k] = this.get(i);
            i++;
            k++;
        }
        while (j < other.size()) {
            tempArray[k] = other.get(j);
            j++;
            k++;
        }
        a = tempArray;
        this.howMany = k;
        isSorted = checkIfSorted();
    }

    @Override
    public boolean rotate(int n) {
        if (n <= 0 || howMany <= 1) { // makes sure n > 0 and the list length is > 1
            return false;
        }
        int rotations = n % howMany; // simplifies down the number of rotations
        if (rotations == 0){
            return true;
        }
        for (int i = 0; i < rotations; i++) { //loops through the list and rotates it by n
           T lastElement = a[howMany - 1];
           for (int j = howMany -1; j > 0; j--) {
               a[j] = a[j - 1];
           }
           a[0] = lastElement;
        }
        isSorted = checkIfSorted();
        return true;
    }

    public boolean checkIfSorted() { // loops through all the elements in the list and checks if the array list is in a sorted order
        isSorted = true;
        for (int i = 0; i < howMany - 1; i++) {
            if (a[i].compareTo(a[i +1]) > 0) {
                isSorted = false;
            }
        }
        return isSorted;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < howMany; i++) {
            sb.append(a[i].toString()).append("\n");
        }
        return sb.toString();
    }
    @Override
    public boolean isSorted() {
        return isSorted;
    }

}
