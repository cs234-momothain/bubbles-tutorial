/********************************************************************************/
/*										*/
/*		Gravity.java							*/
/*										*/
/*	Implements calculations related to the force of gravity 		*/
/*										*/
/********************************************************************************/

package edu.brown.cs.bubbles.tutorial.romp;

public class Gravity {

/** The gravitational constant */
private static double g;

static {
   g = calculateG();
   // System.err.println("Gravity calculated as " + g);
}


public static double getG()
{
   return g;
}

/** Calculate the value of the gravitational constant using the fact that the frequency
of oscillation of the pendulum is 1.25/sec and the formula freq = 2*PI*sqrt(l/g) */
private static double calculateG()
{
   // period of the pendulum is 1.25/sec
   return (Pendulum.getLength() * 4 * Math.pow(Math.PI, 2)) / Math.pow(1.25, 2);
}

/** Calculate the force of gravity on the pendulum using the formula from the assignment.
@return a Force object
*/
public static Force calculateForce(Pendulum p)
{
   // Calculate magnitude
   double magnitude = -Pendulum.getMass() * g * p.getAngle().sine();

   // Error checking - remove me later
   if (Double.isNaN(magnitude)) {
      System.err.println("Got NaN from mass: " + Pendulum.getMass() + ", g: " + g
	       + ", angle: " + p.getAngle() + ", sine(angle): " + p.getAngle().sine());
      System.exit(-1);
   }

   // Calculate angles
   Position pos = p.getPosition();
   // use a pvec to get the angles
   PhysicsVector vec = new PhysicsVector(pos.getX(),pos.getY(),pos.getZ());
   Force gForce = new Force(magnitude,vec.getTheta(),vec.getPhi());
   /*
   System.err.println("  Gravity: " );
   System.err.println(magnitude + ", " + vec.getTheta() + ", " + vec.getPhi());
   System.err.println(gForce);
   */
   return gForce;
}
}
