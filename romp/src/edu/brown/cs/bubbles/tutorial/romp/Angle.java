/********************************************************************************/
/*										*/
/*		Angle.java							*/
/*										*/
/*	Implement angle operations						*/
/*										*/
/********************************************************************************/

package edu.brown.cs.bubbles.tutorial.romp;


public class Angle {

/** A constant to avoid recalculation */
private static final double TWO_PI = 2 * Math.PI;
/** The size of the angle in radians */
private double	radians;

// Constructors
/** Construct an Angle from radians */
public Angle(double value)
{
   radians = value;
   reduce();
}

/** Construct an Angle from x and y coordinates */
public Angle(double x,double y)
{
   radians = Math.atan2(x, y);
   if (x < 0) {
      radians += Math.PI;
    }
   reduce();
}

// Accessors
public double getRadians()
{
   return radians;
}

/** Return the size of the angle in degrees */
public double getDegrees()
{
   return (radians * 180) / Math.PI;
}

// Utilities
/** Reduce a negative angle or an angle greater than 2PI
      to something between 0 and 2PI */
private void reduce()
{
   if (radians < 0) {
      radians += TWO_PI;
      while (radians < 0) {
	 radians += TWO_PI;
       }
    }
   else {
      radians = radians % TWO_PI;
    }
}

/** Return the sine of the angle */
public double sine()
{
   return Math.sin(radians);
}

/** Return the cosine of the angle */
public double cosine()
{
   return Math.cos(radians);
}

/** Return an Angle 180degrees opposite the current Angle
      @return a new Angle
      */
public Angle reverse()
{
   return new Angle(radians + Math.PI);
}

/** Subtract one that Angle from this one.
      @return a new Angle */
public Angle subtract(Angle that)
{
   return new Angle(radians - that.getRadians());
}

/** Subtract radians from this Angle
      @return a new Angle */
public Angle subtract(double radians)
{
   return new Angle(this.radians - radians);
}

/** Construct a printable representation of an Angle */
public String toString()
{
   StringBuffer buf = new StringBuffer();
   buf.append("<ANGLE ");
   buf.append(radians);
   buf.append(" rad, ");
   buf.append(getDegrees());
   buf.append(" degrees>");
   return buf.toString();
}

}
