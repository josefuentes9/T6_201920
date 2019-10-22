package model.logic;

public class Viaje implements Comparable<Viaje>
{
	private double trimestre;
	private double sourceid;
	private double dstid;
	private double info;
	private double mean_travel_time;
	private double standard_deviation_travel_time;
	
	public Viaje(int _trimestre, String _sourceid, String _dstid, String _info, String _mean_travel_time, String _standard_deviation_travel_time)
	{
		setTrimestre(_trimestre);
		setSourceid(Double.parseDouble(_sourceid));
		setDstid(Double.parseDouble(_dstid));
		setInfo(Double.parseDouble(_info));
		setMean_travel_time(Double.parseDouble(_mean_travel_time));
		setStandard_deviation_travel_time(Double.parseDouble(_standard_deviation_travel_time));
	}

	public double getSourceid() {
		return sourceid;
	}

	public void setSourceid(double sourceid) {
		this.sourceid = sourceid;
	}

	public double getDstid() {
		return dstid;
	}

	public void setDstid(double dstid) {
		this.dstid = dstid;
	}

	public double getInfo() {
		return info;
	}

	public void setInfo(double dow) {
		this.info = dow;
	}

	public double getMean_travel_time() {
		return mean_travel_time;
	}

	public void setMean_travel_time(double mean_travel_time) {
		this.mean_travel_time = mean_travel_time;
	}

	public double getStandard_deviation_travel_time() {
		return standard_deviation_travel_time;
	}

	public void setStandard_deviation_travel_time(double standard_deviation_travel_time) {
		this.standard_deviation_travel_time = standard_deviation_travel_time;
	}

	public double getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(double trimestre) {
		this.trimestre = trimestre;
	}

	@Override
	public int compareTo(Viaje that) {
		// TODO Auto-generated method stub
				if(this.mean_travel_time>that.mean_travel_time)
				{
					return 1;
				}
				else if(this.mean_travel_time>that.mean_travel_time)
				{
					return -1;
				}
				else
				{
					return 0;
				}
	
	}

}