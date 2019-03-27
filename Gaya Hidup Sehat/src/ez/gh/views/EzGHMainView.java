package ez.gh.views;

import java.util.Arrays;

import ez.utils.EzFX;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class EzGHMainView {
	@FXML
	TextField umurField, beratField, tinggiField;
	TextField[] numberOnlyFields;
	@FXML
	RadioButton tidur6less, tidur79, tidur10more, fisikBeratYes, fisikBeratNo,
				fisikSedangYes, fisikSedangNo, jalan30more, jalan30less,
				gelas3, gelas45, gelas67, gelas8, rokokBtnYes, rokokBtnNo,
				alkoholBtnYes, alkoholBtnNo, stressBtnYes, stressBtnNo;
	RadioButton[] tidur, fisik, fisikSedang, jalan, gelas, rokok, alkohol, stress;
	RadioButton[][] radio;
	@FXML
	ComboBox<String> pagiSayur, pagiKarbo, pagiPro,
					 siangSayur, siangKarbo, siangPro,
					 malamSayur, malamKarbo, malamPro;
	ComboBox<String>[] sayur, karbo, pro;
	@FXML
	Button caclBtn;
	public void initialize() {
		state();
		grouping();
		stateCombos();
		stateNumberOnlys();
		// NEXT: calculate
	}
	private void stateNumberOnlys() {
		for (TextField field : numberOnlyFields)
			EzFX.setNumberOnlyField(field);
	}
	private void stateCombos() {
		for (ComboBox<String>[] boxes : Arrays.asList(sayur, karbo, pro))
			for (ComboBox<String> box : boxes) {
				box.getItems().addAll("0 piring", "1/4 piring", "1/2 piring", "3/4 piring", "1 piring");
				box.getSelectionModel().select(0);
			}
	}
	@SuppressWarnings("unchecked")
	private void state() {
		numberOnlyFields = new TextField[] {umurField, beratField, tinggiField};
		tidur = new RadioButton[] {tidur6less, tidur79, tidur10more};
	    fisik = new RadioButton[] {fisikBeratYes, fisikBeratNo};
	    fisikSedang = new RadioButton[] {fisikSedangYes, fisikSedangNo};
	    jalan = new RadioButton[] {jalan30more, jalan30less};
	    gelas = new RadioButton[] {gelas3, gelas45, gelas67, gelas8};
	    rokok = new RadioButton[] {rokokBtnYes, rokokBtnNo};
	    alkohol = new RadioButton[] {alkoholBtnYes, alkoholBtnNo};
	    stress = new RadioButton[] {stressBtnYes, stressBtnNo};
	    radio = new RadioButton[][] {tidur, fisik, fisikSedang, jalan, gelas, rokok, alkohol, stress};
	    sayur = new ComboBox[] {pagiSayur, siangSayur, malamSayur};
	    karbo = new ComboBox[] {pagiKarbo, siangKarbo, malamKarbo};
	    pro = new ComboBox[] {pagiPro, siangPro, malamPro};
	}
	private void grouping() {
		ToggleGroup group = null;
		for (RadioButton[] btns : radio) {
			group = new ToggleGroup();
			for (RadioButton btn : btns)
				btn.setToggleGroup(group);
		}
	}
}
