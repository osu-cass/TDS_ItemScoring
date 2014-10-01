/*******************************************************************************
 * Educational Online Test Delivery System 
 * Copyright (c) 2014 American Institutes for Research
 *   
 * Distributed under the AIR Open Source License, Version 1.0 
 * See accompanying file AIR-License-1_0.txt or at
 * http://www.smarterapp.org/documents/American_Institutes_for_Research_Open_Source_Software_License.pdf
 ******************************************************************************/
package tds.itemscoringengine;

public enum PropositionState {

  NotApplicable(-1), NotAsserted(0), Asserted(1);

  private int _ordinal;

  private PropositionState (int value) {
    _ordinal = value;
  };

}
