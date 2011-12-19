package org.paukov.diagram.geom;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Description
 * 
 *           |normal
 *           |
 *           | port
 *  ---------*---------  edge
 *  |                 |
 *  |    object       |
 *  |                 |
 *  |                 |
 *  -------------------
 * 
 */
public class Port {

    public enum State {
	free, allocated
    }

    private final Point2D point;
    private State state = State.free;
    private final GeomObject object;
    private final Line2D edge;

    /**
     * @param point
     * @param state
     */
    public Port(Point2D point, State state, GeomObject object, Line2D edge) {
	super();
	this.point = point;
	this.state = state;
	this.object = object;
	this.edge = edge;
    }

    /**
     * @param point
     * @param state
     */
    public Port(Point2D point, GeomObject object, Line2D edge) {
	super();
	this.point = point;
	this.object = object;
	this.edge = edge;
    }

    /**
     * @param point
     * @param state
     */
    public Port(double x, double y, GeomObject object, Line2D edge) {
	super();
	this.point = new Point2D.Double(x, y);
	this.object = object;
	this.edge = edge;
    }

    /**
     * @return Returns the state.
     */
    public State getState() {
	return state;
    }

    /**
     * @param state
     *            The state to set.
     */
    public void setState(State state) {
	this.state = state;
    }

    /**
     * @return Returns the point.
     */
    public Point2D getPoint() {
	return point;
    }

    public GeomObject getObject() {
	return object;
    }

    public Line2D getEdge() {
	return edge;
    }

    public Vector2D getNormalVector() {
	return Vector2D.createNormalVector(edge);
    }

    public Line2D getNormalLine(double length) {
	return getNormalVector().getLine(point, length);
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Port [point=" + point + ", state=" + state + ", edge=" + edge +"]";
    }

}
