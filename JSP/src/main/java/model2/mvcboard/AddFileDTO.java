package model2.mvcboard;

public class AddFileDTO {
	private int F_idx;
	private int board_idx;
	private String ofile;
	private String sfile;
	
	
	public int getF_idx() {
		return F_idx;
	}
	public void setF_idx(int f_idx) {
		F_idx = f_idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	
	
}
