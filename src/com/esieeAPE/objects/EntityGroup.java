/**
 * ESIEE OpenSource Project : OpenGL
 *
 * MARTEL Andy
 * MERCANDALLI Jonathan
 */

package com.esieeAPE.objects;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.esieeAPE.physics.Force;
import com.esieeAPE.physics.PhysicsConst;

/**
 * Use to apply transformations : all in one
 * @author Jonathan
 *
 */
public class EntityGroup extends Entity {
	
	public List<Entity> entities;
	public final Context context;
	
	public EntityGroup(final Context context) {
		this.context = context;
		this.entities = new ArrayList<Entity>();
	}
	
	public EntityGroup(final Context context, List<Entity> entities) {
		this.context = context;
		this.entities = entities;
		if(this.entities == null)
			this.entities = new ArrayList<Entity>();
	}
	
	public void init() {}

	public void addEntity(Entity entity) {
		entity.id = entities.size();
		entities.add(entity);
	}
	
	public Entity getEntity(int id) {
		if(id<entities.size())
			return entities.get(id);
		return null;
	}
	
	@Override
	public Entity isInside(Entity object) {
		Entity res = null;
		l:for(Entity entity : this.entities)
			if((res=entity.isInside(object))!=null)
				break l;
		return res;
	}

	@Override
	public void teleport(float x, float y, float z) {
		for(Entity entity : this.entities)
			entity.teleport(x, y, z);
	}
	
	@Override
	public void translate(float x, float y, float z) {
		for(Entity entity : this.entities)
			entity.translate(x, y, z);
	}

	@Override
	public void rotate(float a, float x, float y, float z) {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(float[] _mpMatrix, float[] _mvMatrix) {
		for(Entity entity : this.entities)
			entity.draw(_mpMatrix, _mvMatrix);
	}

	@Override
	public void scale(float rate) {
		for(Entity entity : this.entities)
			entity.scale(rate);
	}
	
	@Override
	public void translateRepetedWayPosition() {
		for(Entity entity : this.entities)
			entity.translateRepetedWayPosition();
	}

	@Override
	public void computeForces(EntityGroup contacts) {
		for(Entity entity : this.entities)
			entity.computeForces(contacts);
	}
	
	@Override
	public void applyForces(EntityGroup contacts) {
		for(Entity entity : this.entities)
			entity.applyForces(contacts);
	}
	
	@Override
	public void addForce(Force force) {
		for(Entity entity : this.entities)
			entity.forces.add(force);
	}
	
	public void separeObject() {		
		for(Entity ent : entities) {
			Entity entityContact = this.isInside(ent);
			if(entityContact!=null) {
				if(PhysicsConst.REAL_LOOP_TIME * (this.velocity.dY + PhysicsConst.REAL_LOOP_TIME * this.acceleration.dY / 2)>0) {					
					translate(	0, 
								Math.abs(entityContact.position.dY-this.position.dY),
								0);
				}
				else {
					translate(	0, 
								-Math.abs(entityContact.position.dY-this.position.dY),
								0);
				}
			}
		}
	}
}
