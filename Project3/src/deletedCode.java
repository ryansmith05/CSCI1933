public class deletedCode {
    //add method
    //        if (element == null) {
//            return false;
//        }
//        else if (howMany == a.length){
//            //a.doubleArraySize();
//            T[] biggerArray;
//            biggerArray = (T[]) new Comparable[a.length * 2 + 1]; // +1 in case the array size is set to 0
//            System.arraycopy(a, 0, biggerArray, 0, howMany);
//            a = biggerArray;
//            for (int i = 0; i < a.length; i++){
//                howMany = 0;
//                if (a[i] != null){
//                    howMany++;
//                }
//            }
//        }else {
//            for (int i = 0; i < a.length; i++){
//                if (a[i] == null){
//                    a[i] = element;
//                    howMany++;
//                    //break;
//                    return true;
//                }
//            }
//            //return true;
//        }
//        return false;

    //doubleArray size
    //    public void doubleArraySize (){ //helper function for the add methods to increase the size of the array
//        T[] biggerArray;
//        biggerArray = (T[]) new Comparable[a.length * 2 + 1]; // +1 in case the array size is set to 0
//        System.arraycopy(a, 0, biggerArray, 0, howMany);
//        a = biggerArray;
//        for (int i = 0; i < a.length; i++){
//            howMany = 0;
//            if (a[i] != null){
//                howMany++;
//            }
//        }
//    }

    //add index function
    //        if (element == null || ((index < 0) || (index > a.length))) {
//            return false;
//        }
//        else if (howMany == a.length) {
//            //a.doubleArraySize();
//            T[] biggerArray;
//            biggerArray = (T[]) new Comparable[a.length * 2 + 1]; // +1 in case the array size is set to 0
//            System.arraycopy(a, 0, biggerArray, 0, howMany);
//            a = biggerArray;
//            for (int i = 0; i < a.length; i++){
//                howMany = 0;
//                if (a[i] != null){
//                    howMany++;
//                }
//            }
//        }
//        else if (a[index] != null){
//            for (int i = index; i < a.length-1; i++){
//                a[i + 1] = a[i];
//            }
//            a[index] = element;
//            howMany++;
//            return true;
//        }
//        else if (a[index] == null){
//            a[index] = element;
//            howMany++;
//            return true;
//        }
////        if (a.isSorted() == false){
////            isSorted = false;
////        }
//        return false;

    //indexOf
    //        if (element == null) {
//            return -1;
//        }
//        else if (element != null) {
//            for (int i = 0; i < a.length; i++)
//                if(a[i] != element) {
//                    return -1;
//                }
//        }
//        else {
//            for (int i = 0; i < a.length; i++) {
//                if (a[i] == element) {
//                    return i;
//                }
//            }
//        }
//        return -1;

    //isEmpty
    //        for (int i = 0; i < a.length; i++){
//            if (a[i] == null){
//                return true;
//            }
//        }

    //equalTo
    //for (int i = 0; i < a.length; i++){
    //if (a[i] != null && a[i] != element){
    //a[i] = null;
    //}
    //}

    //rotate
    //        else {
//            for (int i = 0; i < a.length; i++){
//                a[i + n] = a[i];
//            }
//            return true;
//        }

    //sort
    //        if (isSorted){
//            return;
//        }
//        int i, j;
//        T n;
//        //int counter = 0;
//        for (i = 1; i < a.length; i++) {
//            n = a[i];
//            for (j = i - 1; j >= 0 && n.compareTo(a[j]) < 0; j--) {
//                //counter++;
//                a[j+1] = a[j];
//            }
//            a[j+1] = n;
//        }
//        isSorted = true;

    //merge sort
    // Check if the merged list is sorted
//        boolean isMergedSorted = true;
//        for (int l = 1; l < this.howMany; l++) {
//            if (this.a[l].compareTo(this.a[l - 1]) < 0) {
//                isMergedSorted = false;
//                break;
//            }
//        }
//        if (isMergedSorted) {
//            this.isSorted = true;
//        } else {
//            this.isSorted = false;
//        }

}
