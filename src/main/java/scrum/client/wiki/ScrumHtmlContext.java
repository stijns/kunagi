package scrum.client.wiki;

import ilarkesto.core.scope.Scope;
import scrum.client.Dao;
import scrum.client.collaboration.ForumSupport;
import scrum.client.common.AScrumGwtEntity;
import scrum.client.workspace.Navigator;

import com.google.gwt.core.client.GWT;

public class ScrumHtmlContext implements HtmlContext {

	private Dao dao;

	public ScrumHtmlContext() {
		this.dao = Scope.get().getComponent(Dao.class);
	}

	@Override
	public String getEntityReferenceHrefOrOnclickAParameter(String reference) {
		// return "onclick='window.scrum.showEntityByReference(\"" + reference + "\")'";
		return "href='" + Navigator.getEntityHref(reference) + "'";
	}

	@Override
	public String getEntityLabelByReference(String reference) {
		AScrumGwtEntity entity = dao.getEntityByReference(reference);
		if (entity == null) {
			dao.requestEntityByReference(reference);
			return null;
		}
		if (entity instanceof ForumSupport) return ((ForumSupport) entity).getLabel();
		return entity.toString();
	}

	@Override
	public String getDownloadUrlByReference(String reference) {
		return GWT.getModuleBaseURL() + "fileDownload?reference=" + reference;
	}

	@Override
	public boolean isAnchorLinks() {
		return false;
	}

}
