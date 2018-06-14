package egen.project.RestApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// POJO class for tires. Having uni-directional one to one mapping with the Reading class
@Entity
public class Tires {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	

	private float frontLeft;
	private float frontRight;
	private float rearLeft;
	private float rearRight;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tires() {}
	
	public Tires(float frontLeft, float frontRight, float rearLeft, float rearRight) {
		this.frontLeft = frontLeft;
		this.frontRight = frontRight;
		this.rearLeft = rearLeft;
		this.rearRight = rearRight;
	}

	public float getFrontLeft() {
		return frontLeft;
	}

	public float getFrontRight() {
		return frontRight;
	}

	public float getRearLeft() {
		return rearLeft;
	}

	public float getRearRight() {
		return rearRight;
	}

	@Override
	public String toString() {
		return "Tires [frontLeft=" + frontLeft + ", frontRight=" + frontRight + ", rearLeft=" + rearLeft
				+ ", rearRight=" + rearRight + "]";
	}
	
	
	

}
