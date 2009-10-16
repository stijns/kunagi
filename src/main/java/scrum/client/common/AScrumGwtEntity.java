package scrum.client.common;

import ilarkesto.gwt.client.AGwtEntity;

import java.util.Map;

import scrum.client.ComponentManager;

public abstract class AScrumGwtEntity extends AGwtEntity {

	protected static final ComponentManager cm = ComponentManager.get();

	public AScrumGwtEntity() {}

	public AScrumGwtEntity(Map data) {
		super(data);
	}

}
