public class Matrix {
    private int nrows;
    private int ncols;
    private int[][] matrix;

    public Matrix(int nrows,int ncols){
        this.nrows = nrows;
        this.ncols = ncols;
        matrix = new int[nrows][ncols];
    }
    public Matrix(int [][]arr){
        this.nrows = arr.length;
        this.ncols = arr[0].length;
        this.matrix = new int[nrows][ncols];
        this.matrix = arr;
    }
    //transpose method
    public Matrix transpose(){
        Matrix trns = new Matrix(this.ncols,this.nrows);
        for(int i=0;i<this.nrows;i++) {
            for(int j=0;j<this.ncols;j++) {
                trns.matrix[j][i] = this.matrix[i][j];
            }
        }
        return trns;
    }
    public String toString() {
        String st;
        st = "Matrix: \n";
        for(int i=0;i<this.nrows;i++){
            for(int j=0;j<this.ncols;j++){
                st += this.matrix[i][j]+" ";
            }
            st += "\n";
        }
        return st;
    }
}
