class Main 
{
  static double[][] matrixM = {  {10,5,20,6,21}, {5,12,3,1,14},
            {20,13,5,12,20}, {19,20,5,5,12}, {2,5,1,13,19} };

  static double[][] matrixA = {  {20,8,-5,25,-1}, {18,5,20,-1,11},
            {9,14,7,15,-22}, {-5,18,-4,1,-8}, {-18,0,0,0,0} };

  public static void main(String[] args) 
  {
    MatrixMethods m = new MatrixMethods();
    System.out.println("Message:\n\nJETFUELCANTMELTSTEELBEAMS\n");
    System.out.println("Message Matrix M:");
    m.printMatrix(matrixM);
    System.out.println("\nInvertible Matrix A:");
    m.printMatrix(matrixA);
    double det = m.determinant(matrixA);
    System.out.println("\nDeterminant |A| = " + det);
    System.out.println("Invertible?: " + (det!=0));
    System.out.println("\nEncrypted matrix Mc (M x A): ");
    double[][] MxA = m.multiply(matrixM,matrixA);
    m.printMatrix(MxA);
    System.out.println("\nInverted Matrix A^(-1):");
    double[][] Ai = m.invert(matrixA);
    m.printMatrix(Ai);
    System.out.println("\nDecrypted matrix Mc x A^(-1): ");
    double[][] MxAxAi = m.multiply(MxA,Ai);
    m.printMatrix(MxAxAi);
  }
}
