package scrum.client.risks;

import ilarkesto.gwt.client.ADropdownViewEditWidget;
import ilarkesto.gwt.client.AFieldValueWidget;
import ilarkesto.gwt.client.ARichtextViewEditWidget;
import ilarkesto.gwt.client.ATextViewEditWidget;
import ilarkesto.gwt.client.Gwt;
import scrum.client.collaboration.CommentsWidget;
import scrum.client.common.AScrumWidget;
import scrum.client.common.FieldsWidget;

import com.google.gwt.user.client.ui.Widget;

public class RiskWidget extends AScrumWidget {

	private Risk risk;

	public RiskWidget(Risk risk) {
		super();
		this.risk = risk;
	}

	@Override
	protected Widget onInitialization() {
		FieldsWidget fields = new FieldsWidget();

		fields.add("Label", new ATextViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewerText(risk.getLabel());
			}

			@Override
			protected void onEditorUpdate() {
				setEditorText(risk.getLabel());
			}

			@Override
			protected void onEditorSubmit() {
				risk.setLabel(getEditorText());
			}

		});
		fields.add("Description", new ARichtextViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewerText(risk.getDescription());
			}

			@Override
			protected void onEditorUpdate() {
				setEditorText(risk.getDescription());
			}

			@Override
			protected void onEditorSubmit() {
				risk.setDescription(getEditorText());
			}
		});
		fields.add("Mitigation Plans", new ARichtextViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewerText(risk.getMitigationPlans());
			}

			@Override
			protected void onEditorUpdate() {
				setEditorText(risk.getMitigationPlans());
			}

			@Override
			protected void onEditorSubmit() {
				risk.setMitigationPlans(getEditorText());
			}
		});
		fields.add("Impact", new ADropdownViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewerText(risk.getImpactLabel());
			}

			@Override
			protected void onEditorUpdate() {
				setOptions(RiskComputer.getImpacts());
				setSelectedOption(String.valueOf(risk.getImpact()));
			}

			@Override
			protected void onEditorSubmit() {
				risk.setImpact(Integer.parseInt(getSelectedOption()));
			}
		});
		fields.add("Probability", new ADropdownViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewerText(risk.getProbabilityLabel());
			}

			@Override
			protected void onEditorUpdate() {
				setOptions(RiskComputer.getProbabilities());
				setSelectedOption(String.valueOf(risk.getProbability()));
			}

			@Override
			protected void onEditorSubmit() {
				risk.setProbability(Integer.parseInt(getSelectedOption()));
			}
		});
		fields.add("Priority", new AFieldValueWidget() {

			@Override
			protected void onUpdate() {
				setText(risk.getPriorityLabel());
			}
		});

		return Gwt.createFlowPanel(fields, new CommentsWidget(risk));
	}

}
