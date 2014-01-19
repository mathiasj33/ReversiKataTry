package de.rmrw.ReversiKata.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import de.rmrw.ReversiKata.code.IFSpielModel;

public class JavaFXSpiel extends BorderPane implements IFSpielView{
	
	private IFSpielModel model 										= null;
	
	private JavaFXSpielfeldFeldProperties spielfeldFeldProperties 	= null;
	
	
//	@Inject
	private JavaFXSpielfeldView spielfeldView;

//	@Inject
	private JavaFXSpielerView spielerView;

	
	public JavaFXSpiel(IFSpielModel model_, JavaFXSpielfeldFeldProperties spielfeldFeldProperties_) {
		setModel(model_);
		setPadding(new Insets(40, 40, 40, 40));
		spielfeldFeldProperties = spielfeldFeldProperties_;
		spielfeldView = new JavaFXSpielfeldView(model, spielfeldFeldProperties);
		this.setCenter(spielfeldView);
		spielerView = new JavaFXSpielerView(10);
		this.setLeft(spielerView);
		model.addView(this);
	}
	
//	@PostConstruct
//	public void initAfterConstruction()
//	{
//		
//	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	public IFSpielModel getModel() {
		return model;
	}

	public void setModel(IFSpielModel model) {
		this.model = model;
	}

	public JavaFXSpielfeldView getJavaFXSpielfeldView() {
		return spielfeldView;
	}

	public void setJavaFXSpielfeldView(JavaFXSpielfeldView spielfeldView) {
		this.spielfeldView = spielfeldView;
	}

	public JavaFXSpielerView getJavaFXSpielerView() {
		return spielerView;
	}

	public void setJavaFXSpielerView(JavaFXSpielerView spielerView) {
		this.spielerView = spielerView;
	}

}
