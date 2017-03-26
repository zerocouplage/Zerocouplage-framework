package org.zerocouplage.component.mobile.component;

import java.util.ArrayList;

import org.zerocouplage.component.api.component.ZCComboBoxItem;
import org.zerocouplage.component.impl.component.ZCAbstractComboBox;
import org.zerocouplage.component.impl.component.ZCAbstractComponent;
import org.zerocouplage.component.mobile.page.ZCPageMobile;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
/**
 * <p>
 * ZCComboboxMobile is the ZCCombobox component in Mobile
 * </p>
 * 
 * @author ZCTeam 2014
 * 
 */
public class ZCComboboxMobile extends ZCAbstractComboBox {
	private Spinner spinner;

	@Override
	public Object display() throws Exception {
		Object parent = this.getParent();
		while (!(parent instanceof ZCPageMobile)) {
			parent = ((ZCAbstractComponent) parent).getParent();
		}

		spinner = new Spinner((Context) parent);
		ArrayList<String> values = new ArrayList<String>() ;
		
		int tmp =0;
		while(tmp<getItems().size()){
		values.add(getItems().get(tmp).getValue());
		tmp++;
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>((Context) parent,
				android.R.layout.simple_spinner_item, values);

		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinner.setAdapter(adapter);
		spinner.setSelection(1, true);
		return spinner;
	}

	public String getSelectedName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSelectedName(ZCComboBoxItem item) {
		// TODO Auto-generated method stub
		
	}

}
