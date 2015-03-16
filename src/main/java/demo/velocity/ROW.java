package demo.velocity;

import java.util.ArrayList;
import java.util.List;

public class ROW {
	private List<ROWJQM> rowjqms = new ArrayList<ROWJQM>();
	private String GSXX01;
	private String KCLX;
	public List<ROWJQM> getRowjqms() {
		return rowjqms;
	}
	public void setRowjqms(List<ROWJQM> rowjqms) {
		this.rowjqms = rowjqms;
	}
	public void addRowjqm(ROWJQM rowjqm){
		this.rowjqms.add(rowjqm);
	}
	public String getGSXX01() {
		return GSXX01;
	}
	public void setGSXX01(String gSXX01) {
		GSXX01 = gSXX01;
	}
	public String getKCLX() {
		return KCLX;
	}
	public void setKCLX(String kCLX) {
		KCLX = kCLX;
	}
}


class ROWJQM {
	private List<ROWJQMMX> rowjqmmxs = new ArrayList<ROWJQMMX>();
	private String JLID;
	private String GSXX01;
	public List<ROWJQMMX> getRowjqmmxs() {
		return rowjqmmxs;
	}
	public void setRowjqmmxs(List<ROWJQMMX> rowjqmmxs) {
		this.rowjqmmxs = rowjqmmxs;
	}
	public void addRowjqmmx(ROWJQMMX rowjqmmx){
		this.rowjqmmxs.add(rowjqmmx);
	}
	public String getJLID() {
		return JLID;
	}
	public void setJLID(String jLID) {
		JLID = jLID;
	}
	public String getGSXX01() {
		return GSXX01;
	}
	public void setGSXX01(String gSXX01) {
		GSXX01 = gSXX01;
	}
}

class ROWJQMMX {
	private String JLID;
	private String JQM01;
	public String getJLID() {
		return JLID;
	}
	public void setJLID(String jLID) {
		JLID = jLID;
	}
	public String getJQM01() {
		return JQM01;
	}
	public void setJQM01(String jQM01) {
		JQM01 = jQM01;
	}
	
}