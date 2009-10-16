package scrum.client.tasks;

import ilarkesto.gwt.client.AWidget;

import java.util.List;

import scrum.client.GenericPredicate;
import scrum.client.common.BlockListWidget;
import scrum.client.dnd.BlockListDropAction;
import scrum.client.sprint.Task;

import com.google.gwt.user.client.ui.Widget;

public class TaskListWidget extends AWidget {

	private BlockListWidget<Task> list;
	private BlockListDropAction<Task> dropAction;

	private TaskBlockContainer container;

	public TaskListWidget(TaskBlockContainer container) {
		this(container, null);
	}

	public TaskListWidget(TaskBlockContainer container, BlockListDropAction<Task> dropAction) {
		this.container = container;
		this.dropAction = dropAction;
	}

	@Override
	protected Widget onInitialization() {
		list = new BlockListWidget<Task>(new TaskBlock.TaskBlockFactory(container), this.dropAction);
		list.setSelectionManager(container.getSelectionManager());
		list.setAutoSorter(Task.NUMBER_COMPARATOR);
		return list;
	}

	public void selectTask(Task task) {
		list.extendObject(task);
	}

	public void setTasks(List<Task> tasks) {
		initialize();
		list.setObjects(tasks);
	}

	public void setTaskHighlighting(GenericPredicate<Task> predicate) {
		list.setTaskHighlighting(predicate);
	}

	public void clearTaskHighlighting() {
		list.clearTaskHighlighting();
	}
}
