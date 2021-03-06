/*******************************************************************************
 * Educational Online Test Delivery System Copyright (c) 2014 American
 * Institutes for Research
 * 
 * Distributed under the AIR Open Source License, Version 1.0 See accompanying
 * file AIR-License-1_0.txt or at http://www.smarterapp.org/documents/
 * American_Institutes_for_Research_Open_Source_Software_License.pdf
 ******************************************************************************/
package qtiscoringengine;

public class DEBaseType extends DataElement
{
  private BaseType _value;

  public DEBaseType (BaseType bt) {
    _baseType = BaseType.BaseType;
    _value = bt;
  }

  public BaseType getValue () {
    return _value;
  }

  @Override
  public boolean equals (Object e) {
    if (!(e instanceof DataElement))
      return false;

    DataElement d = (DataElement) e;

    if (d.getType () == getType ()) {
      if (_value == ((DEBaseType) d).getValue ())
        return true;
    }
    return false;
  }

  @Override
  public String getStringValue () {
    return _value.toString ();
  }

}
