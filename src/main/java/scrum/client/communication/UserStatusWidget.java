package scrum.client.communication;

import ilarkesto.gwt.client.AWidget;
import scrum.client.ScrumGwtApplication;
import scrum.client.admin.User;
import scrum.client.context.ProjectContext;

import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class UserStatusWidget extends AWidget {

	private Label label;
	private User user;

	public UserStatusWidget(User user) {
		this.user = user;
	}

	@Override
	protected Widget onInitialization() {
		label = new Label(user.getName());
		label.setStyleName("UserStatusWidget");
		return label;
	}

	@Override
	protected void onUpdate() {
		String color = ScrumGwtApplication.get().getProject().getUserConfig(user).getColor();
		label.getElement().getStyle().setProperty("color", color);
		Highlighter highlighter = new Highlighter();
		label.addMouseMoveHandler(highlighter);
		label.addMouseOutHandler(highlighter);
		if (ScrumGwtApplication.get().getProject().isOnline(user)) {
			label.addStyleName("UserStatusWidget-online");
		} else {
			label.removeStyleName("UserStatusWidget-online");
		}
	}

	class Highlighter implements MouseMoveHandler, MouseOutHandler {

		public void onMouseMove(MouseMoveEvent event) {
			ProjectContext.get().highlightUser(user);
		}

		public void onMouseOut(MouseOutEvent event) {
			ProjectContext.get().highlightUser(null);
		}
	}
}
