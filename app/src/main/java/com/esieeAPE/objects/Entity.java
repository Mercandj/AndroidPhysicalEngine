/**
 * ESIEE OpenSource Project : OpenGL
 * <p/>
 * MARTEL Andy
 * MERCANDALLI Jonathan
 */

package com.esieeAPE.objects;

import com.esieeAPE.lib.WayPosition;
import com.esieeAPE.lib.myVector3D;
import com.esieeAPE.physics.Force;
import com.esieeAPE.physics.PhysicsObjStats;

import java.util.ArrayList;
import java.util.List;

/**
 * Define the object's attributes
 *
 * @author Jonathan
 */
public abstract class Entity {

    public int id;                    // identify entity in an EntityGroup

    public PhysicsObjStats physic = new PhysicsObjStats();

    public myVector3D edgeVerticeMin = null;
    public myVector3D edgeVerticeMax = null;

    public myVector3D position = new myVector3D(0, 0, 0);
    public myVector3D velocity = new myVector3D(0, 0, 0);
    public myVector3D acceleration = new myVector3D(0, 0, 0);
    // Move
    public WayPosition repetedWayPosition;
    // Physics
    public boolean contactEnable = true;
    protected myVector3D sum_force = new myVector3D(0, 0, 0);
    protected List<Force> forces = new ArrayList<Force>();
    protected List<Entity> entitiesContact;

    public abstract void teleport(float x, float y, float z);

    public abstract void translate(float x, float y, float z);

    public abstract void rotate(float a, float x, float y, float z);

    public abstract void scale(float rate);

    public abstract Entity isInside(Entity object);

    public abstract void draw(float[] _mpMatrix, float[] _mvMatrix);

    public abstract void translateRepetedWayPosition();

    public abstract void computeForces(EntityGroup contacts);

    public abstract void applyForces(EntityGroup contacts);

    public abstract void addForce(Force force);
}
