public class Cofactor
{
    private int row, col;
    private double value;

    public Cofactor(double value, int row, int col) {
      this.row=row;
      this.col=col;
      this.value=sign(value);
    }

    private double sign(double value) {   return Math.pow(-1, row+col)*value;  }
    public double value()  {   return value;   }
    public int row()  {   return row;   }
    public int col()  {   return col;   }
}
