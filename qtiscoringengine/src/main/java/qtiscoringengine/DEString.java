/*******************************************************************************
 * Educational Online Test Delivery System 
 * Copyright (c) 2014 American Institutes for Research
 *   
 * Distributed under the AIR Open Source License, Version 1.0 
 * See accompanying file AIR-License-1_0.txt or at
 * http://www.smarterapp.org/documents/American_Institutes_for_Research_Open_Source_Software_License.pdf
 ******************************************************************************/
package qtiscoringengine;


public class DEString extends DataElement {
	private String _value;

	public DEString(String id) {
		_baseType = BaseType.String;
		_value = id;
	}

	String getValue() {
		return _value;
	}

	@Override
	public boolean equals(DataElement d) {
		if (d.getType() == this.getType()) {
			if (_value.equals(((DEString) d).getValue()))
				return true;
		}
		return false;
	}

	@Override
	public String getStringValue() {
		return _value;
	}
}
