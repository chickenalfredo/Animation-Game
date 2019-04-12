package core.component;

import core.component.state.*;

/**
 * This component will allow an Entity to have the data necessary for having a
 * state. An entity can have three different states that all run concurrent to 
 * one another. 
 * 
 * @see State
 * @see ConcurrentState
 * @see Direction
 */
public class StateComponent implements Component {
    
    private State state;
    private ConcurrentState concurrentState;
    private Direction direction;

    /**
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the concurrentState
     */
    public ConcurrentState getConcurrentState() {
        return concurrentState;
    }

    /**
     * @param concurrentState the concurrentState to set
     */
    public void setConcurrentState(ConcurrentState concurrentState) {
        this.concurrentState = concurrentState;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {
        this.state = state;
    }

}