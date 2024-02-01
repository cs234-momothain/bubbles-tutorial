/********************************************************************************/
/*										*/
/*		PhysicsVector.java						*/
/*										*/
/*	A <code>PhysicsVector</code> implements a vector for use in		*/
/*	calculations of forces, accelerations, velocities, and other vector	*/
/*	quantities.								*/
/*										*/
/********************************************************************************/

package edu.brown.cs.bubbles.tutorial.romp;

public class PhysicsVector {

/**  Cartesian values for x, y, and z components */
protected double iHat, jHat, kHat;

/** Angle theta for spherical coordinates */
protected Angle  theta;
/** Angle phi for spherical coordinates */
protected Angle  phi;
/** Mangitude/radius for spherical coordinates */
protected double r;

// Constructors
/** Constructs a new PhysicsVector from Cartesian Coordinates. */
public PhysicsVector(double iHat,double jHat,double kHat)
{
   this.iHat = iHat;
   this.jHat = jHat;
   this.kHat = kHat;

   // Convert to spherical
   r = Math.sqrt(Math.pow(iHat, 2) + Math.pow(jHat, 2) + Math.pow(kHat, 2));

   double thetaMag = Math.atan(jHat / iHat);
   double phiMag = Math.asin(kHat / r);

   if (Double.isNaN(thetaMag)) {
      thetaMag = 0;
   }
   if (Double.isNaN(phiMag)) {
      phiMag = 0;
   }

   theta = new Angle(thetaMag);
   if (iHat < 0) {
      theta = theta.reverse();
   }
   phi = new Angle(phiMag);
   if (kHat < 0) {
      phi = phi.reverse();
   }
}

/** Constructs a new PhysicsVector from Spherical Coordinates */
public PhysicsVector(double r,Angle theta,Angle phi)
{
   this.r = r;
   this.theta = theta;
   this.phi = phi;

   // Convert to Cartesian
   iHat = r * theta.cosine() * phi.sine();
   jHat = r * theta.sine() * phi.sine();
   kHat = r * phi.cosine();

}

/** Copy constructor */
public PhysicsVector(PhysicsVector that)
{
   this.iHat = that.getIHat();
   this.jHat = that.getJHat();
   this.kHat = that.getKHat();
   this.r = that.getR();
   this.theta = that.getTheta();
   this.phi = that.getPhi();
}

// Accessors
public double getIHat()
{
   return iHat;
}

public double getJHat()
{
   return jHat;
}

public double getKHat()
{
   return kHat;
}

public double getR()
{
   return r;
}

public Angle getTheta()
{
   return theta;
}

public Angle getPhi()
{
   return phi;
}

// Utilities
/** Multiplies a PhysicsVector by a scalar quantity
@return a new PhysicsVector
*/
public PhysicsVector scalarMultiply(double scalar)
{
   double newR = r * scalar;
   return new PhysicsVector(newR,theta,phi);
}

/** Generates a vector pointing in the opposite direction from the current vector
@return a new PhysicsVector
*/
public PhysicsVector reverse()
{
   return scalarMultiply(-1);
}

/** Adds two vectors
@return a new PhysicsVector
*/
public PhysicsVector add(PhysicsVector pvector)
{
   double newIHat = iHat + pvector.getIHat();
   double newJHat = jHat + pvector.getJHat();
   double newKHat = kHat + pvector.getKHat();
   return new PhysicsVector(newIHat,newJHat,newKHat);
}

/** Generate printable description of the vector
@return String
*/
public String toString()
{
   StringBuffer buf = new StringBuffer();
   buf.append("<PVector iH: ");
   buf.append(iHat);
   buf.append(" jH: ");
   buf.append(jHat);
   buf.append(" kH: ");
   buf.append(kHat);
   buf.append(">");
   return buf.toString();
}

/** Check if a vector is a zero vector
@return <code>true<code> if it is a zero vector, and <code>false</code> otherwise.
*/
public boolean zeroP()
{
   return (r == 0);
}
}
