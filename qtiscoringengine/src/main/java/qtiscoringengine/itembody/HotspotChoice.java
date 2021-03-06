/*******************************************************************************
 * Educational Online Test Delivery System Copyright (c) 2014 American
 * Institutes for Research
 * 
 * Distributed under the AIR Open Source License, Version 1.0 See accompanying
 * file AIR-License-1_0.txt or at http://www.smarterapp.org/documents/
 * American_Institutes_for_Research_Open_Source_Software_License.pdf
 ******************************************************************************/
package qtiscoringengine.itembody;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

import AIR.Common.Helpers._Ref;
import AIR.Common.Utilities.JavaPrimitiveUtils;
import AIR.Common.xml.XmlNamespaceManager;
import qtiscoringengine.QTIUtility;
import qtiscoringengine.Shape;
import qtiscoringengine.ValidationLog;

class HotspotChoice extends SimpleChoice
{
  private Shape         _shape;
  private List<Integer> _coords;

  // todo: add optional attributes

  protected HotspotChoice (String identifier, Shape shape, List<Integer> coords) {
    super (identifier);
    _shape = shape;
    _coords = coords;
  }

  static/* new */HotspotChoice fromXml (Element element, XmlNamespaceManager nsmgr, ValidationLog log) {
    String identifier = element.getAttributeValue (ItemBodyConstants.Identifier);
    String shape = element.getAttributeValue (ItemBodyConstants.Shape);
    String coords = element.getAttributeValue (ItemBodyConstants.Coords);

    List<Integer> coordList = null;
    try {
      coordList = new ArrayList<Integer> ();
      for (String s : QTIUtility.parseDelimitedString (coords)) {
        coordList.add (Integer.parseInt (s));
      }
    } catch (Exception e) {
      log.addMessage (element, e.getMessage ());
      return null;
    }

    if (coordList == null || coordList.size () == 0) {
      log.addMessage (element, "No coords attribute specified -- it is a required attribute");
      return null;
    }

    _Ref<Shape> shp = new _Ref<Shape> (Shape.Default);
    if (!JavaPrimitiveUtils.enumTryParse (Shape.class, shape, true, shp)) {
      log.addMessage (element, "Could not parse value '" + shape + "' to a shape");
      return null; // required attribute, so return null
    }

    return new HotspotChoice (identifier, shp.get (), coordList);
  }
}
