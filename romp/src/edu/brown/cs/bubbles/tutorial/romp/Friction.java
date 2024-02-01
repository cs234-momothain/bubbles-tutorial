/********************************************************************************/
/*										*/
/*		Friction.java							*/
/*										*/
/*	Implements calculation relating to the force of friction		*/
/*										*/
/********************************************************************************/

package edu.brown.cs.bubbles.tutorial.romp;

public class Friction {

/** The frictional damping coefficient */
private static double dampingCoefficient;

static {
   dampingCoefficient = calculateDampingCoefficient();
}

/** Calculate the force of friction on the pendulum using the
formula from the assignment.
@return a new Force
*/
public static Force calculateForce(Pendulum p)
{
   PhysicsVector result = new PhysicsVector(p.getVelocity().scalarMultiply(
	    dampingCoefficient));
   return new Force(result.getR(),result.getTheta(),result.getPhi());
}

/** Set the coefficient to an empirical value */
private static double calculateDampingCoefficient()
{
   return -.03;
   // return 0;
}

}
