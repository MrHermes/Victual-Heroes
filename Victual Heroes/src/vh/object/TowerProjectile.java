package vh.object;

import java.awt.geom.Point2D;

public class TowerProjectile {
	
	private Point2D.Float position;
	private int id, projectileType, projectileDamage;
	private float xSpeed, ySpeed;
	private boolean active = true;
	
	public TowerProjectile(float x, float y, float xSpeed, float ySpeed, int id, int projectileDamage, int projectileType) {
		this.position = new Point2D.Float(x,y);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.id = id;
		this.projectileDamage = projectileDamage;
		this.projectileType = projectileType;
	}
	
	public int getProjectileDamage() {
		return projectileDamage;
	}

	public void move() {
		position.x += xSpeed;
		position.y += ySpeed;
	}

	public Point2D.Float getPosition() {
		return position;
	}

	public void setPosition(Point2D.Float position) {
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectileType() {
		return projectileType;
	}

	public void setProjectileType(int projectileType) {
		this.projectileType = projectileType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
