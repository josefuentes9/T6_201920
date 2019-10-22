package model.logic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {
	@SerializedName("cartodb_id")
	@Expose
	private Integer cartodbId;
	@SerializedName("scacodigo")
	@Expose
	private String scacodigo;
	@SerializedName("scatipo")
	@Expose
	private Integer scatipo;
	@SerializedName("scanombre")
	@Expose
	private String scanombre;
	@SerializedName("shape_leng")
	@Expose
	private Double shapeLeng;
	@SerializedName("shape_area")
	@Expose
	private Double shapeArea;
	@SerializedName("MOVEMENT_ID")
	@Expose
	private String MOVEMENTID;
	@SerializedName("DISPLAY_NAME")
	@Expose
	private String DISPLAYNAME;

	public Properties(Integer cartodbId, String scacodigo, Integer scatipo, String scanombre, Double shapeLeng,
			Double shapeArea, String mOVEMENTID, String dISPLAYNAME) {
		super();
		this.cartodbId = cartodbId;
		this.scacodigo = scacodigo;
		this.scatipo = scatipo;
		this.scanombre = scanombre;
		this.shapeLeng = shapeLeng;
		this.shapeArea = shapeArea;
		MOVEMENTID = mOVEMENTID;
		DISPLAYNAME = dISPLAYNAME;
	}

	public Integer getCartodbId() 
	{
	return cartodbId;
	}

	public void setCartodbId(Integer cartodbId) 
	{
	this.cartodbId = cartodbId;
	}

	public String getScacodigo() 
	{
	return scacodigo;
	}

	public void setScacodigo(String scacodigo) 
	{
	this.scacodigo = scacodigo;
	}

	public Integer getScatipo() 
	{
	return scatipo;
	}

	public void setScatipo(Integer scatipo) 
	{
	this.scatipo = scatipo;
	}

	public String getScanombre() 
	{
	return scanombre;
	}

	public void setScanombre(String scanombre) 
	{
	this.scanombre = scanombre;
	}

	public Double getShapeLeng() 
	{
	return shapeLeng;
	}

	public void setShapeLeng(Double shapeLeng) 
	{
	this.shapeLeng = shapeLeng;
	}

	public Double getShapeArea() 
	{
	return shapeArea;
	}

	public void setShapeArea(Double shapeArea) 
	{
	this.shapeArea = shapeArea;
	}

	public String getMOVEMENTID() 
	{
	return MOVEMENTID;
	}

	public void setMOVEMENTID(String pMOVEMENTID) 
	{
	this.MOVEMENTID = pMOVEMENTID;
	}

	public String getDISPLAYNAME() {
	return DISPLAYNAME;
	}

	public void setDISPLAYNAME(String pDISPLAYNAME) 
	{
	this.DISPLAYNAME = DISPLAYNAME;
	}
}