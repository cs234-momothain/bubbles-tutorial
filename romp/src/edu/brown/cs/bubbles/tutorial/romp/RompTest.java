/********************************************************************************/
/*                                                                              */
/*              RompTest.java                                                   */
/*                                                                              */
/*      description of class                                                    */
/*                                                                              */
/*      Written by                                                              */
/*                                                                              */
/********************************************************************************/



package edu.brown.cs.bubbles.tutorial.romp;

import org.junit.*;
import static org.junit.Assert.*;

public class RompTest
{


@Test
public void testAngle()
{
   Angle a1 = new Angle(Math.PI);
   Angle a2 = new Angle(0,-1);
   assertEquals(180.0,a1.getDegrees(),0.0001);
   assertEquals(180.0,a2.getDegrees(),0.0001);
   Angle a3 = a1.subtract(a2);
   assertEquals(0,a3.getRadians(),0.0001);
}
   

@Test
public void testDirection()
{
   Direction d1 = new Direction(true);
   Direction d2 = new Direction(false);
   Direction d3 = new Direction(-1);
   assert(d1.attractsP(d2));
   assert(d1.attractsP(d3));
   assertFalse(d2.attractsP(d3));
}


@Test 
public void testForce()
{
   Force f1 = new Force(1.0,1.0,0.0);
   Force f2 = new Force(Math.sqrt(2),new Angle(Math.PI + Math.PI/4),new Angle(Math.PI/2));
   Force f3 = f1.add(f2);
   assertEquals(f3.getR(),0,0.001);
}


@Test 
public void testMagnet()
{
   Magnet m1 = new Magnet(0,0,new Direction(true));
   Magnet m2 = new Magnet(1,1,new Direction(false));
   Magnet m3 = new Magnet(0.5f,0.5f,new Direction(true));
   Magnet m4 = new Magnet(0.25f,0,new Direction(false));
   assertTrue(m1.attractsP(m2));
   assertFalse(m1.overlap(m3));
   assertTrue(m1.overlap(m4));
}



@Test
public void testVector()
{
   PhysicsVector v1 = new PhysicsVector(1,1,0);
   PhysicsVector v2 = new PhysicsVector(Math.sqrt(2),new Angle(Math.PI/4),new Angle(Math.PI/2));
   PhysicsVector v3 = new PhysicsVector(v2);
   PhysicsVector v4 = v3.reverse();
   PhysicsVector v5 = v4.add(v1);
   PhysicsVector v6 = v1.reverse();
   PhysicsVector v7 = v1.add(v6);
   assertEquals(v5.getR(),0,0.0001);
   assertTrue(v7.zeroP());
}


@Test 
public void testPosition()
{
   Position p1 = new Position(1,1,1);
   Position p2 = new Position(0,0,0);
   Position p3 = new Position(-1,-1,-1);
   Position p4 = p3.add(p1);
   double d1 = p1.distance(p2);
   assertEquals(d1,Math.sqrt(3),0.0001);
   double d2 = p4.distance(p2);
   assertEquals(d2,0,0.0001);
}
   
   
   
   
   
}       // end of class RompTest




/* end of RompTest.java */
