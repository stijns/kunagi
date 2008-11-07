









// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.ApplicationGenerator










package scrum.server;

import java.util.*;
import ilarkesto.auth.*;
import ilarkesto.logging.*;
import ilarkesto.base.time.*;
import ilarkesto.base.*;
import ilarkesto.persistence.*;

public abstract class GScrumWebApplication
            extends ilarkesto.ui.web.AWebApplication {

    private static final Logger LOG = Logger.get(GScrumWebApplication.class);

    public static final String TYPE = "scrumWebApplication";

    // --- ensure integrity ---

    public void ensureIntegrity() {
        super.ensureIntegrity();
    }


    // -----------------------------------------------------------
    // - composites
    // -----------------------------------------------------------

    // --- sprintDao ---

    private scrum.server.sprint.SprintDao sprintDao;

    public final scrum.server.sprint.SprintDao getSprintDao() {
        if (sprintDao == null) {
            sprintDao = createSprintDao();
            initializeSprintDao(sprintDao);
        }
        return sprintDao;
    }

    protected scrum.server.sprint.SprintDao createSprintDao() {
        return sprintDao = new scrum.server.sprint.SprintDao();
    }

    protected void initializeSprintDao(scrum.server.sprint.SprintDao bean) {
        autowire(bean);
        Reflect.invokeInitializeIfThere(bean);
    }

    public final void resetSprintDao() {
        sprintDao = null;
    }

    // --- projectDao ---

    private scrum.server.project.ProjectDao projectDao;

    public final scrum.server.project.ProjectDao getProjectDao() {
        if (projectDao == null) {
            projectDao = createProjectDao();
            initializeProjectDao(projectDao);
        }
        return projectDao;
    }

    protected scrum.server.project.ProjectDao createProjectDao() {
        return projectDao = new scrum.server.project.ProjectDao();
    }

    protected void initializeProjectDao(scrum.server.project.ProjectDao bean) {
        autowire(bean);
        Reflect.invokeInitializeIfThere(bean);
    }

    public final void resetProjectDao() {
        projectDao = null;
    }

    // --- impedimentDao ---

    private scrum.server.impediments.ImpedimentDao impedimentDao;

    public final scrum.server.impediments.ImpedimentDao getImpedimentDao() {
        if (impedimentDao == null) {
            impedimentDao = createImpedimentDao();
            initializeImpedimentDao(impedimentDao);
        }
        return impedimentDao;
    }

    protected scrum.server.impediments.ImpedimentDao createImpedimentDao() {
        return impedimentDao = new scrum.server.impediments.ImpedimentDao();
    }

    protected void initializeImpedimentDao(scrum.server.impediments.ImpedimentDao bean) {
        autowire(bean);
        Reflect.invokeInitializeIfThere(bean);
    }

    public final void resetImpedimentDao() {
        impedimentDao = null;
    }

    // --- taskDao ---

    private scrum.server.sprint.TaskDao taskDao;

    public final scrum.server.sprint.TaskDao getTaskDao() {
        if (taskDao == null) {
            taskDao = createTaskDao();
            initializeTaskDao(taskDao);
        }
        return taskDao;
    }

    protected scrum.server.sprint.TaskDao createTaskDao() {
        return taskDao = new scrum.server.sprint.TaskDao();
    }

    protected void initializeTaskDao(scrum.server.sprint.TaskDao bean) {
        autowire(bean);
        Reflect.invokeInitializeIfThere(bean);
    }

    public final void resetTaskDao() {
        taskDao = null;
    }

    // --- backlogItemDao ---

    private scrum.server.project.BacklogItemDao backlogItemDao;

    public final scrum.server.project.BacklogItemDao getBacklogItemDao() {
        if (backlogItemDao == null) {
            backlogItemDao = createBacklogItemDao();
            initializeBacklogItemDao(backlogItemDao);
        }
        return backlogItemDao;
    }

    protected scrum.server.project.BacklogItemDao createBacklogItemDao() {
        return backlogItemDao = new scrum.server.project.BacklogItemDao();
    }

    protected void initializeBacklogItemDao(scrum.server.project.BacklogItemDao bean) {
        autowire(bean);
        Reflect.invokeInitializeIfThere(bean);
    }

    public final void resetBacklogItemDao() {
        backlogItemDao = null;
    }

    // --- dependencies ---

}
