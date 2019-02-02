

public class MatrixMethods
{
  //works for square matrices only
  //inverse  = 1/det(A) * adj(A), where adj(A) = C^T
  public double[][] invert(double[][] matrix)
  {
    int dim = matrix.length;
		double det = determinant(matrix);
    double[][] cfMatrix = new double[dim][dim];
    for(int i=0;i<dim;i++)
    {
      for(int j=0;j<dim;j++)
      {
        Cofactor cf = new Cofactor(matrix[i][j],i,j);
        cfMatrix[j][i] = Math.pow(-1,i+j)*determinant(submatrix(matrix,cf)) / det;
      }
    }
    System.out.println();
    return cfMatrix;
  }

  public double[][] multiply(double[][] M, double[][] A)
  {
    double sum = 0;
    int dim = M.length;
    double multiply[][] = new double[dim][dim];
    for (int c = 0; c < dim; c++)
    {
      for (int d = 0; d < dim; d++)
      {  
          for (int k = 0; k < dim; k++)
          {
            sum = sum + M[c][k]*A[k][d];
          }
          multiply[c][d] = sum;
          sum = 0;
      }
    }
    return multiply;
  }

  //works for square matrices only
  public double determinant(double[][] matrix)
  {
    Cofactor cf = new Cofactor(matrix[0][0],0,0);
    double det = detRecurse(matrix, cf);
    return det;
  }

  public double detRecurse(double[][] matrix, Cofactor cf)
  {
    int dims = matrix[0].length;
    double det = 0;
    if(dims==2)
      return det2(matrix);
    else
    {
      for(int i=0;i<dims;i++)
      {
        Cofactor newCf = new Cofactor(matrix[0][i],0,i);
        double[][] newmatrix = submatrix(matrix, newCf);
        //System.out.println("Cofactor: " + newCf.value);
        det += newCf.value() * detRecurse(newmatrix, newCf);
      }
      return det;
    }
  }

  public double det2(double[][] matrix)
  {
    return (matrix[1][1]*matrix[0][0] - matrix[0][1]*matrix[1][0]);
  }

  //determines the submatrix of int[][] matrix using Cofactor cf (original matrix excluding the i-th row and j-th column)
  //does so by adding these elements to an internal array in order, then using helper method fillMatrix() to populate a new int[][] to return.
  public double[][] submatrix(double[][] matrix, Cofactor cf)
  {
    int dim = matrix.length - 1;
    double[] values = new double[dim*dim];
    int i=0;
    //System.out.print("\nSubmatrix:");
    for(int r=0;r<=dim;r++)
    {
      for(int c=0;c<=dim;c++)
      {
        if(r!=cf.row() && c!=cf.col())
        {
          //System.out.print(matrix[r][c] + " ");
          values[i++] = matrix[r][c];
        }
      }
      //System.out.println();
    }
    double[][] newMatrix = fillMatrix(values, dim);
    return newMatrix;
  }

  public double[][] fillMatrix(double[] values, int dim)
  {
    double[][] matrix = new double[dim][dim];
    int i=0;
    for(int r=0;r<dim;r++)
    {
      for(int c=0;c<dim;c++)
      {
        matrix[r][c] = values[i++];
      }
    }
    return matrix;
  }

  public void printMatrix(double[][] matrix)
  {
    for(double[] row:matrix)
    {
      System.out.print("|");
      for(double col:row)
        System.out.format("%12.8f ",col);
      System.out.println("|");
    }
  }
}
