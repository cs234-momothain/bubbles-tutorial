/********************************************************************************/
/*										*/
/*		Velocity.java							*/
/*										*/
/*	Subclass of PhysicsVector, used mostly for type safety			*/
/*										*/
/********************************************************************************/

package edu.brown.cs.bubbles.tutorial.romp;


public class Velocity extends PhysicsVector {

// Constructors
/** Construct a force from Cartesian coordinates */
public Velocity(double iHat,double jHat,double kHat)
{
   super(iHat,jHat,kHat);
}

/** Construct a force from spherical coordinates */
public Velocity(double r,Angle theta,Angle phi)
{
   super(r,theta,phi);
}

/** Copy constructor */
public Velocity(Velocity that)
{
   super(that);
}

/** Copy Constructor for building a Velocity from a PhysicsVector */
public Velocity(PhysicsVector that)
{
   super(that);
}

/** Add that Velocity to this one
@return a new Velocity
*/
public Velocity add(Velocity that)
{
   return new Velocity(super.add(that));
}

// Utilities
/** Update a position given the current velocity and a timestep
@return a new Position
*/
public Position updatePosition(Position oldPosition,float timestep)
{
   Position delta = new Position((float) iHat * timestep,(float) jHat * timestep,
	    (float) kHat * timestep);
   // 0.0f); // let Z happen automagically
   return oldPosition.add(delta);
}

/** Update the velocity given an acceleration vector and a timestep
@return a new Velocity
*/
public Velocity updateVelocity(PhysicsVector acceleration,float timestep)
{
   Velocity delta = new Velocity(acceleration.getIHat() * timestep,acceleration.getJHat()
	    * timestep,acceleration.getKHat() * timestep);
   // System.err.println("DeltaV = " + delta);
   return this.add(delta);
}

}
