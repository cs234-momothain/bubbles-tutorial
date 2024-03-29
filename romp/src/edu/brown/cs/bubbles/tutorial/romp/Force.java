/********************************************************************************/
/*										*/
/*		Force.java							*/
/*										*/
/*	Subclass of PhysicsVector for type safety				*/
/*										*/
/********************************************************************************/

package edu.brown.cs.bubbles.tutorial.romp;

public class Force extends PhysicsVector {

/** Construct a Force from Cartesian Coordinates */
public Force(double iHat,double jHat,double kHat)
{
   super(iHat,jHat,kHat);
}

/** Construct a Force from Spherical Coordinates */
public Force(double r,Angle theta,Angle phi)
{
   super(r,theta,phi);
}

/** Copy Constructor */
public Force(Force that)
{
   super(that);
}

/** Copy Constructor for building a Force from a PhysicsVector */
public Force(PhysicsVector that)
{
   super(that);
}

/** Adds two Forces
@return a new Force
*/
public Force add(Force that)
{
   return new Force(super.add(that));
}

}
