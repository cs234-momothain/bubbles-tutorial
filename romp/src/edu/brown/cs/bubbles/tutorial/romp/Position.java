/********************************************************************************/
/*										*/
/*		Position.java							*/
/*										*/
/*	A Position represents the position of a point in 3-space		*/
/*										*/
/********************************************************************************/

package edu.brown.cs.bubbles.tutorial.romp;


public class Position {

/** Cartesian coordinates */
private float x, y, z;

/** Construct a Position from Cartesian coordinates */
public Position(float x,float y,float z)
{
   this.x = x;
   this.y = y;
   this.z = z;
}

public float getX()
{
   return x;
}

public float getY()
{
   return y;
}

public float getZ()
{
   return z;
}

/** Calculate the distance between the current position and a second position
@return the distance between the two positions
*/
public float distance(Position p2)
{
   float deltaX, deltaY, deltaZ;
   deltaX = x - p2.getX();
   deltaY = y - p2.getY();
   deltaZ = z - p2.getZ();
   return (float) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)
	    + Math.pow(deltaZ, 2));
}


/** Adds two Positions
@return a new Position
*/
public Position add(Position p2)
{
   return new Position(x + p2.getX(),y + p2.getY(),z + p2.getZ());
}

/** Returns a printable representation of the Position */
public String toString()
{
   StringBuffer buf = new StringBuffer();
   buf.append("(");
   buf.append(x);
   buf.append(", ");
   buf.append(y);
   buf.append(", ");
   buf.append(z);
   buf.append(")");
   return buf.toString();
}

}
