package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

public class Position implements Serializable{
private PositionId positionId;
private String currentPosition;

public Position() {
	super();
}

public Position(PositionId positionId, String currentPosition) {
	super();
	this.positionId = positionId;
	this.currentPosition = currentPosition;
}
@EmbeddedId
public PositionId getPositionId() {
	return positionId;
}

public void setPositionId(PositionId positionId) {
	this.positionId = positionId;
}

public String getCurrentPosition() {
	return currentPosition;
}

public void setCurrentPosition(String currentPosition) {
	this.currentPosition = currentPosition;
}


}
