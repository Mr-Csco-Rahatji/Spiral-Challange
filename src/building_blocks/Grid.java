package building_blocks;
/**
 * @author Frans Csco Rahatji
 */

public class Grid {
	private int nSize;
	private int nCols,nRows;
	private Cell[][] grid;
	
	public Grid(int nSize) {
		this.nSize=nSize;
		int totalCells=0;
		
		while(totalCells<this.nSize) {
			totalCells=nCols*nRows;
			nCols+=1;
			nRows+=1;
		}
		
		grid=new Cell[nRows][nCols];
		for(int a=0;a<nRows;a++) {
			for(int b=0;b<nCols;b++) {
				grid[a][b]=new Cell(a, b);
				grid[a][b].setValue(-1);
			}
		}
		grid[nRows/2][nCols/2].setValue(1);
		Populate(GoRight(grid[nRows/2][nCols/2]));
	}
	
	public void ShowGrid() {
		for(int a=1;a<nRows;a++) {
			for(int b=0;b<nCols;b++) {
				if(grid[a][b].getValue()==-1) {
					if(b==0) {
						
					}else {
						System.out.print("  "+" "+"  ");
					}
				}else {
					if(grid[a][b].getValue()>99) {
						System.out.print(grid[a][b].getValue()+"  ");
					}else if(grid[a][b].getValue()>9 && grid[a][b].getValue()<100) {
						System.out.print(" "+grid[a][b].getValue()+"  ");
					}else if(grid[a][b].getValue()<10) {
						System.out.print("  "+grid[a][b].getValue()+"  ");
					}
				}
			}
			System.out.println(" ");
		}
		System.out.println("\n\r@author Frans Csco Rahatji");
	}
	
	private void Populate(Cell current) {
		if(current.getValue()==nSize) {
			return;
		}
		if(checkLeft(current)==-1) {
			if(checkUp(current)==-1) {
				if(checkRight(current)==-1) {
					Populate(GoRight(current));
				}else if(checkRight(current)==-2) {
					//don't think it will ever reach this point
				}else {
					Populate(GoUp(current));
				}
			}else if (checkUp(current)==-2) {
				if(checkRight(current)==-1) {
					Populate(GoRight(current));
				}else if(checkRight(current)==-2) {
					//don't think it will ever reach this point
				}else {
					Populate(GoUp(current));
				}
			}else {
				Populate(GoLeft(current));
			}
		}else if(checkLeft(current)==-2) {
			if(checkUp(current)==-1) {
				if(checkRight(current)==-1) {
					Populate(GoRight(current));
				}else if(checkRight(current)==-2) {
					//don't think it will ever reach this point
				}else {
					Populate(GoUp(current));
				}
			}else if (checkUp(current)==-2) {
				if(checkRight(current)==-1) {
					Populate(GoRight(current));
				}else if(checkRight(current)==-2) {
					//don't think it will ever reach this point
				}else {
					Populate(GoUp(current));
				}
			}else {
				Populate(GoLeft(current));
			}
		}else {
			if(checkDown(current)==-1) {
				Populate(GoDown(current));
			}else if(checkDown(current)==-2) {
				return;
			}else {
				if(checkRight(current)==-1) {
					Populate(GoRight(current));
				}else if(checkRight(current)==-2) {
					return;
				}else {
					return;
				}
			}
		}
	}
	
	private int checkLeft(Cell self) {
		if(self.getCol()!=0) {
			return grid[self.getRow()][self.getCol()-1].getValue();
		}else {
			return -2;
		}
	}
	
	private int checkRight(Cell self) {
		if(self.getCol()!=nCols-1) {
			return grid[self.getRow()][self.getCol()+1].getValue();
		}else {
			return -2;
		}
	}
	
	private int checkUp(Cell self) {
		if(self.getRow()!=0) {
			return grid[self.getRow()-1][self.getCol()].getValue();
		}else {
			return -2;
		}
	}
	
	private int checkDown(Cell self) {
		if(self.getRow()!=nRows-1) {
			return grid[self.getRow()+1][self.getCol()].getValue();
		}else {
			return -2;
		}
	}
	
	private Cell GoDown(Cell self) {
		grid[self.getRow()+1][self.getCol()].setValue(self.getValue()+1);
		return grid[self.getRow()+1][self.getCol()];
	}
	
	private Cell GoUp(Cell self) {
		grid[self.getRow()-1][self.getCol()].setValue(self.getValue()+1);
		return grid[self.getRow()-1][self.getCol()];
	}
	
	private Cell GoLeft(Cell self) {
		grid[self.getRow()][self.getCol()-1].setValue(self.getValue()+1);
		return grid[self.getRow()][self.getCol()-1];
	}
	
	private Cell GoRight(Cell self) {
		grid[self.getRow()][self.getCol()+1].setValue(self.getValue()+1);
		return grid[self.getRow()][self.getCol()+1];
	}
}
