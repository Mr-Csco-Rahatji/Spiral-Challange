import java.util.Scanner;
import building_blocks.Grid;

/**
 * @author Frans Csco Rahatji
 */

public class Main {
	public static void main(String[] args) {
		System.out.println("Please enter size");
		Scanner sc=new Scanner(System.in);
		int nSize=sc.nextInt();
		Grid grid=new Grid(nSize);
		System.out.println();
		grid.ShowGrid();
		sc.close();
	}
}
