package building_blocks;
/**
 * @author Frans Csco Rahatji
 */

public class Cell {
	private int value;
	private int row,col;
	
	public Cell(int row,int col) {
		this.value=-1;
		this.col=col;
		this.row=row;
	}
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}
